/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chny.lexico;

import main.MainGUI;
import sintactico.Lexema;

/**
 *
 * @author Jose
 */
public class Identificadores {
    Lexema lexema;
    
    public boolean q0(String c, int pos, int linea)
    {
        if(pos < c.length())
        {
            switch(c.substring(pos, pos + 1).toLowerCase())
            {
                case "a":
                    return q1(c, pos + 1, linea);
                case "b":
                    return q1(c, pos + 1, linea);
                case "c":
                    return q1(c, pos + 1, linea);
                case "d":
                    return q1(c, pos + 1, linea);
                case "e":
                    return q1(c, pos + 1, linea);
                case "f":
                    return q1(c, pos + 1, linea);
                case "g":
                    return q1(c, pos + 1, linea);
                case "h":
                    return q1(c, pos + 1, linea);
                case "i":
                    return q1(c, pos + 1, linea);
                case "j":
                    return q1(c, pos + 1, linea);
                case "k":
                    return q1(c, pos + 1, linea);
                case "l":
                    return q1(c, pos + 1, linea);
                case "m":
                    return q1(c, pos + 1, linea);
                case "n":
                    return q1(c, pos + 1, linea);
                case "o":
                    return q1(c, pos + 1, linea);
                case "p":
                    return q1(c, pos + 1, linea);
                case "q":
                    return q1(c, pos + 1, linea);
                case "r":
                    return q1(c, pos + 1, linea);
                case "s":
                    return q1(c, pos + 1, linea);
                case "t":
                    return q1(c, pos + 1, linea);
                case "u":
                    return q1(c, pos + 1, linea);
                case "v":
                    return q1(c, pos + 1, linea);
                case "w":
                    return q1(c, pos + 1, linea);
                case "x":
                    return q1(c, pos + 1, linea);
                case "y":
                    return q1(c, pos + 1, linea);
                case "z":
                    return q1(c, pos + 1, linea);
                case "_":
                    return q1(c, pos + 1, linea);
                default:
                    return false;
            }
        }
        return false;
    }
    
    private boolean q1(String c, int pos, int linea)
    {
        if(pos < c.length())
        {
            switch(c.substring(pos, pos + 1).toLowerCase())
            {
                case "a":
                    return q1(c, pos + 1, linea);
                case "b":
                    return q1(c, pos + 1, linea);
                case "c":
                    return q1(c, pos + 1, linea);
                case "d":
                    return q1(c, pos + 1, linea);
                case "e":
                    return q1(c, pos + 1, linea);
                case "f":
                    return q1(c, pos + 1, linea);
                case "g":
                    return q1(c, pos + 1, linea);
                case "h":
                    return q1(c, pos + 1, linea);
                case "i":
                    return q1(c, pos + 1, linea);
                case "j":
                    return q1(c, pos + 1, linea);
                case "k":
                    return q1(c, pos + 1, linea);
                case "l":
                    return q1(c, pos + 1, linea);
                case "m":
                    return q1(c, pos + 1, linea);
                case "n":
                    return q1(c, pos + 1, linea);
                case "o":
                    return q1(c, pos + 1, linea);
                case "p":
                    return q1(c, pos + 1, linea);
                case "q":
                    return q1(c, pos + 1, linea);
                case "r":
                    return q1(c, pos + 1, linea);
                case "s":
                    return q1(c, pos + 1, linea);
                case "t":
                    return q1(c, pos + 1, linea);
                case "u":
                    return q1(c, pos + 1, linea);
                case "v":
                    return q1(c, pos + 1, linea);
                case "w":
                    return q1(c, pos + 1, linea);
                case "x":
                    return q1(c, pos + 1, linea);
                case "y":
                    return q1(c, pos + 1, linea);
                case "z":
                    return q1(c, pos + 1, linea);
                case "_":
                    return q1(c, pos + 1, linea);
                default:
                    return false;
            }
        }
        lexema = new Lexema(401, c, linea);
        MainGUI.lexemas += lexema.getID() + " ";
        MainGUI.pila.push(lexema);
        return true;
    }
}
