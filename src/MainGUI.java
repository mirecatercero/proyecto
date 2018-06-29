
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
import javax.swing.table.TableModel;
import misc.Registro;
import misc.Hash;
import misc.TablaSimbolos;

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
    }
    
        @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnLexico)
        {
            salida = "";
            limpiaTabla(tableModel);
            analisisLexico();
            manejaTabla.leer();
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
        codigo = txtCode.getText();
        int i =0;
        linea = 1;
        token = "";
        long clave;
        
        do
        {
            try
            {
                if(i == codigo.length())
                {
                    analizaToken(token, linea);
                    token = "";
                }else if(Character.toString(codigo.charAt(i)).equals(" "))
                {
                    analizaToken(token, linea);
                    token = "";
                }else if(Character.toString(codigo.charAt(i)).equals("\n"))
                {
                    analizaToken(token, linea);
                    token = "";
                    linea += 1;
                }else if(delimitadores.validar(Character.toString(codigo.charAt(i))))
                {
                    clave = hash.hash(Character.toString(codigo.charAt(i)));
                    registro = new Registro(clave, Character.toString(codigo.charAt(i)), "", "", "", "DE");
                    agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                    manejaTabla.escribir(registro);
                    token = "";
                }else
                    token += Character.toString(codigo.charAt(i));
                i++;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }while(i <= codigo.length());
        txtSalida.setText(salida);
    }
    
    public void analizaToken(String token, int linea)
    {
        long clave;
        try
        {
            if(palabrasReservadas.validar(token))
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "", "", "", "PR");
                    agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                    manejaTabla.escribir(registro);
                }
                else if(identificadores.q0(token, 0))
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "", "", "", "ID");
                    agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                    manejaTabla.escribir(registro);
                }else if(enteros.qo(token, 0))
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "int", "4", "", "DG");
                    agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                    manejaTabla.escribir(registro);
                }else if(flotantes.q0(token, 0))
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "float", "8", "", "DG");
                    agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());    
                    manejaTabla.escribir(registro);
                }else if(operadores.validar(token))
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "", "", "", "OP");
                    agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                    manejaTabla.escribir(registro);
                }else if(cadenas.qo(token, token.length()))
                {
                    clave = hash.hash(token);
                    registro = new Registro(clave, token, "String", "", "", "CA");
                    agregarDatosTabla(registro.getToken(), registro.getTipo(), registro.getLongitud(), registro.getValor(), registro.getCategoria());
                    manejaTabla.escribir(registro);
                }else if(token.compareTo("") != 0)
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
    
    public void limpiaTabla(DefaultTableModel tableModel)
    {
        tableModel.setRowCount(0);
    }
}
