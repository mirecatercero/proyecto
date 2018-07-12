package main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import Archivos.Delimitadores;
import Archivos.PalabrasReservadas;
import Archivos.Operadores;
import chny.lexico.Cadenas;
import chny.lexico.Enteros;
import chny.lexico.Flotantes;
import chny.lexico.Identificadores;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;
import misc.Registro;
import misc.Hash;
import misc.TablaSimbolos;
import sintactico.AutomataPila;
import sintactico.Lexema;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose
 */
public class MainGUI extends JFrame implements ActionListener{
    public static JTextArea txtSalida;
    JMenuBar menuBar;
    JMenu menuArchivo, menuAyuda;
    JMenuItem menuAbrir;
    JButton btnLexico, btnSintactico, btnSemantico, btnLimpiar;
    JScrollPane spCode, spSalida;
    RSyntaxTextArea txtCode;
    
    String[] nombresColumnas = {"Token", "Tipo", "Longitud", "Valor", "Categoria"};
    Object[][] datosSimbolos = new Object[0][4];
    DefaultTableModel tableModel =  new DefaultTableModel(datosSimbolos, nombresColumnas);
    JTable tablaSimbolos;
    JScrollPane spTabla;
    
    String codigo;
    int linea;
    String token = "";
    String salida;
    Registro registro;
    
    Delimitadores delimitadores = new Delimitadores();
    Operadores operadores = new Operadores();
    PalabrasReservadas palabrasReservadas = new PalabrasReservadas(); 
        
    Enteros enteros = new Enteros();
    Flotantes flotantes = new Flotantes();
    Cadenas cadenas = new Cadenas();
    Identificadores identificadores = new Identificadores();
    Hash hash = new Hash();
    TablaSimbolos manejaTabla = new TablaSimbolos();
    
    public static Stack<Lexema> pila = new Stack<Lexema>();
    AutomataPila automataPila = new AutomataPila();
    
    public MainGUI()
    {
        this.setTitle("Analizador Léxico");
        this.setSize(900, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.white);

        menuBar         = new JMenuBar();
        menuArchivo     = new JMenu("Archivo");
        menuAyuda       = new JMenu("Ayuda");
        menuAbrir       = new JMenuItem("Abrir");
        //menuLenguaje    = new JMenuItem("Lenguaje");

        menuBar.add(menuArchivo);
        menuBar.add(menuAyuda);
        menuArchivo.add(menuAbrir);
        //menuAyuda.add(menuLenguaje);

        menuAbrir.addActionListener(this);
        //menuLenguaje.addActionListener(this);

        this.setJMenuBar(menuBar);
        
        
        panelSuperior();
        panelCentral();
        panelInferior();
        
        this.addWindowListener(new WindowAdapter() {
            public void     windowOpened(WindowEvent e)
            {
                txtCode.requestFocus();
            }
        });
    }
    
        @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnLexico)
        {
            try
            {
                salida = "";
                limpiaTabla(tableModel);
                analisisLexico();
                analisisSintactico(pila);
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }else if(e.getSource() == btnSintactico)
        {
            System.out.println("Sintactico");
            analisisSintactico(pila);
        }
    }
    
    public void panelCentral()
    {
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1, 2));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelCentral.setBackground(Color.white);

        txtCode     = new RSyntaxTextArea(30, 80);
        spCode      = new JScrollPane(txtCode);
        
        tablaSimbolos = new JTable(tableModel);
        spTabla = new JScrollPane(tablaSimbolos);

        txtCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        txtCode.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(txtCode);

        panelCentral.add(sp);
        panelCentral.add(spTabla);
        this.getContentPane().add(panelCentral, BorderLayout.CENTER);
        
        pack();
    }
    
    public void panelSuperior()
    {
        JPanel panelSuperior =  new JPanel();
        panelSuperior.setLayout(new FlowLayout(10));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        panelSuperior.setBackground(Color.white);
        
        JPanel panelSuperior1 = new JPanel();
        panelSuperior1.setLayout(new FlowLayout(10));
        
        
        btnLexico     = new JButton("Léxico");
        btnSintactico = new JButton("Sintáctico");
        btnSemantico  = new JButton("Semántico");
        btnLimpiar = new JButton("Limpiar");
        
        btnLexico.addActionListener(this);
        
        panelSuperior1.add(btnLexico);
        panelSuperior1.add(btnSintactico);
        panelSuperior1.add(btnSemantico);
        panelSuperior1.add(btnLimpiar);
        
        panelSuperior.add(panelSuperior1, BorderLayout.WEST);
        this.getContentPane().add(panelSuperior, BorderLayout.NORTH);
    }
    
    public void panelInferior()
    {
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(1, 1));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));
        panelInferior.setBackground(Color.white);
        
        txtSalida = new JTextArea(8, 0);
        spSalida = new JScrollPane(txtSalida);
        spSalida.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        txtSalida.setForeground(Color.red);
        txtSalida.setEditable(false);
        
        panelInferior.add(spSalida);
        this.getContentPane().add(panelInferior, BorderLayout.SOUTH);
    }
    
    public void analisisLexico()
    {
        //recupera el código
        codigo = txtCode.getText();
        int i =0;
        linea = 1;
        token = "";//inicializa token como cadena vacía para forzar la primer validación
        long clave;
        
        do
        {
            try
            {
                if(i == codigo.length())
                {
                    analizaToken(token, linea);
                    token = "";
                }else if(Character.toString(codigo.charAt(i)).equals(" "))//si encuentra un espacio en blanco, analiza el token antes de ese espacio
                {
                    analizaToken(token, linea);
                    token = "";
                }else if(Character.toString(codigo.charAt(i)).equals("\n"))//si encuentra un salto de linea, analiza el token antes de ese salto
                {
                    analizaToken(token, linea);
                    token = "";
                    linea += 1;
                }else if(Character.toString(codigo.charAt(i)).equals("#"))//si encuentra un comentario, lo excluye del análisis
                {
                    while(Character.toString(codigo.charAt(i)).compareTo("\n") != 0 && i < codigo.length() - 1)//recorre los caracteres del comentario hasta que encuentra un salgo de linea
                        i++;
                    linea += 1;
                }else if(Character.toString(codigo.charAt(i)).equals("\"") && token.compareTo("") == 0)
                {
                    token += Character.toString(codigo.charAt(i));//Si encuentra comillas dobles, asigna texto al token hasta que encuentre otras comillas, un salto de linea, o se termine el código
                    i++;
                    if(i < codigo.length())
                    {
                        while(Character.toString(codigo.charAt(i)).compareTo("\"") != 0 && Character.toString(codigo.charAt(i)).compareTo("\n") != 0 && i < codigo.length())
                        {
                            if(Character.toString(codigo.charAt(i)).equals("\""))
                            {
                                token += Character.toString(codigo.charAt(i));
                                break;
                            }
                            else if(Character.toString(codigo.charAt(i)).equals("\n"))
                            {
                                break;
                            }
                            else if(i == codigo.length() - 1)
                            {
                                token += Character.toString(codigo.charAt(i));
                                break;
                            }
                            else
                            {
                                token += Character.toString(codigo.charAt(i));
                                i++;
                                if(Character.toString(codigo.charAt(i)).equals("\""))
                                    token += Character.toString(codigo.charAt(i));
                            }
                        }
                    }
                    analizaToken(token, linea);
                    token = "" ;
                    if(i < codigo.length())
                    {
                        if(Character.toString(codigo.charAt(i)).equals("\n"))
                            linea += 1;
                    }
                }else if(Character.toString(codigo.charAt(i)).equals("\t"))
                    i++;
                else if(delimitadores.validar(Character.toString(codigo.charAt(i)), linea))//si encuentra un delimitador, lo mete a la tabla de símbolos y analiza el token antes del delimitador
                {
                    analizaToken(token, linea);
                    clave = hash.hash(Character.toString(codigo.charAt(i)));
                    registro = new Registro(clave, Character.toString(codigo.charAt(i)), "", "", "", "DE");
                    if (!manejaTabla.buscar(registro) || !buscaTabla(tableModel, registro))
                    {
                         agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                         manejaTabla.escribir(registro);
                    }
                    token = "";
                }
                else
                    token += Character.toString(codigo.charAt(i));//si nada de lo anterior se cumple, se concatena el token con el caracter del codigo en la posicion i
                i++;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }while(i <= codigo.length());//mientras aún haya caracteres por analizar el ciclo continua
        txtSalida.setText(salida);
    }
    
    public void analizaToken(String token, int linea)
    {
        long clave;
        try
        {
            if(palabrasReservadas.validar(token, linea))//si el token analizado es una palabra reservada, lo mete a la tabla
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "", "", "", "PR");
                    if (!manejaTabla.buscar(registro) || !buscaTabla(tableModel, registro))
                    {
                         agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                         manejaTabla.escribir(registro);
                    }
                }
                else if(identificadores.q0(token, 0, linea))//si el token analizado es un identificador, lo mete a la tabla
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "", "", "", "ID");
                    if (!manejaTabla.buscar(registro) || !buscaTabla(tableModel, registro))
                    {
                         agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                         manejaTabla.escribir(registro);
                    }
                }else if(enteros.qo(token, 0))//si el token analizado es un numero entero, lo mete a la tabla
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "int", "4", "", "DG");
                    if (!manejaTabla.buscar(registro) || !buscaTabla(tableModel, registro))
                    {
                         agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                         manejaTabla.escribir(registro);
                    }
                }else if(flotantes.q0(token, 0))//si el token analizado es un numero con punto flotante, lo mete a la tabla
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "float", "8", "", "DG");
                    if (!manejaTabla.buscar(registro) || !buscaTabla(tableModel, registro))
                    {
                         agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                         manejaTabla.escribir(registro);
                    }
                }else if(operadores.validar(token, linea))//si el token analizado es un operador, lo mete a la tabla
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "", "", "", "OP");
                    if (!manejaTabla.buscar(registro) || !buscaTabla(tableModel, registro))
                    {
                         agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                         manejaTabla.escribir(registro);
                    }
                }
                else if(cadenas.qo(token, token.length()))//si el token analizado es una cadena, lo mete a la tabla
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "String", "", "", "CA");
                    if (!manejaTabla.buscar(registro) || !buscaTabla(tableModel, registro))
                    {
                         agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                         manejaTabla.escribir(registro);
                    }
                }
                else if(token.compareTo("") != 0)//si nada de lo anterior se cumple y el token no es una cadena vacia, entonces hay un error léxico
                {
                    salida += "Error en linea " + linea + ": " + token + " no forma parte del lenguaje\n";
                    linea += 1;
                }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void agregarDatosTabla(String token, String tipo, String categoria, String longitud, String valor)
    {
        Object[] fila = {token, tipo, categoria, longitud, valor};
        tableModel.addRow(fila);
    }
    
    public boolean buscaTabla(DefaultTableModel tableModel, Registro registro)
    {
        boolean existe = false;
        if(tableModel.getRowCount() == 0)
            return existe;
        else
        {
            for(int i = 0; i < tableModel.getRowCount(); i ++)
            {
                if(registro.getToken().equals(tableModel.getValueAt(i, 0)))
                    existe = true;
            }
        }
        return existe;
    }
    
    public void limpiaTabla(DefaultTableModel tableModel)
    {
        tableModel.setRowCount(0);
    }
    
    public void analisisSintactico(Stack<Lexema> pila)
    {
//        while(!pila.empty())
//            System.out.println(pila.pop().getToken());
        if(automataPila.q0(pila))
            System.out.println("Correcto");
        else System.out.println("Todo mal");
    }
    
    public void tejona()
    {
    }
}