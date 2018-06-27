
import java.awt.BorderLayout;
import java.awt.Color;
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
    JButton btnLexico;
    JScrollPane spCode;
    RSyntaxTextArea txtCode;
   
    public MainGUI()
    {
        this.setTitle("Analizador Léxico");
        this.setSize(900, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.white);

        menuBar         = new JMenuBar();
        menuArchivo     = new JMenu("Archvio");
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
        
        panelCentral();
    }
    
    public void panelCentral()
    {
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1, 2));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelCentral.setBackground(Color.white);

        txtCode     = new RSyntaxTextArea(20, 60);
        spCode      = new JScrollPane(txtCode);

        txtCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        txtCode.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(txtCode);

        panelCentral.add(sp);
        this.getContentPane().add(panelCentral, BorderLayout.CENTER);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
