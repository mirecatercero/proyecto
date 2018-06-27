
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
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

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
    
    public void panelCentral()
    {
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1, 2));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelCentral.setBackground(Color.white);

        txtCode     = new RSyntaxTextArea(30, 120);
        spCode      = new JScrollPane(txtCode);

        txtCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        txtCode.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(txtCode);

        panelCentral.add(sp);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
