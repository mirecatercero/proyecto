
import chny.lexico.Hash;

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
        Hash hash = new Hash();
        double tuna = hash.hash("int", 500);
        System.out.println(tuna);
        System.out.println(hash.hash("double", 500));
        System.out.println(hash.hash("float", 500));
        //MainGUI mainGUI = new MainGUI();
        //mainGUI.setVisible(true);
    }
}
