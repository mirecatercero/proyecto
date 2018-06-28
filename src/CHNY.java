
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
        TablaSimbolos tabla = new TablaSimbolos();
        Registro registro = new Registro(350, "tejon", "boolean", "DIG", "elTunel");
        tabla.escribir(registro);
        tabla.leer();
        MainGUI mainGUI = new MainGUI();
        mainGUI.setVisible(true);
    }
}
