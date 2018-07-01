
import Archivos.Delimitadores;
import chny.lexico.Cadenas;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import misc.Hash;
import misc.Registro;
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
public class CHNY {
    public static void main(String[] args)
    {
        //TablaSimbolos tabla = new TablaSimbolos();
        //Registro registro = new Registro(350, "tuna", "", "", "", "ID");
        //tabla.escribir(registro);
        //Registro registro2 = new Registro(610, "String", "", "", "", "PR");
        //tabla.escribir(registro2);
        MainGUI mainGUI = new MainGUI();
        mainGUI.setVisible(true);
        //TablaSimbolos tabla = new TablaSimbolos();
        //tabla.leer(13280);
        //Registro registro = new Registro(13760, "String", "", "", "", "PR");
        //System.out.println(tabla.buscar(registro));
    }
}
