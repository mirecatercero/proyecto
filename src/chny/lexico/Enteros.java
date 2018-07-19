/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chny.lexico;

import sintactico.Lexema;
import main.MainGUI;

/**
 *
 * @author Jose
 */
public class Enteros
{
    Lexema lexema;
    
    public boolean qo(String c, int pos, int l)
    {
        if(pos < c.length())
        {
                        switch(c.substring(pos, pos + 1))
            {
                case "0":
                    return q1(c, pos + 1, l);
                case "1":
                    return q1(c, pos + 1, l);
                case "2":
                    return q1(c, pos + 1, l);
                case "3":
                    return q1(c, pos + 1, l);
                case "4":
                    return q1(c, pos + 1, l);
                case "5":
                    return q1(c, pos + 1, l);
                case "6":
                    return q1(c, pos + 1, l);
                case "7":
                    return q1(c, pos + 1, l);
                case "8":
                    return q1(c, pos + 1, l);
                case "9":
                    return q1(c, pos + 1, l);
                default:
                    return false;
            }
        }
        return false;
    }
    
    private boolean q1(String c, int pos, int l)
    {
        if(pos < c.length())
        {
                    switch(c.substring(pos, pos + 1))
            {
                case "0":
                    return q1(c, pos + 1, l);
                case "1":
                    return q1(c, pos + 1, l);
                case "2":
                    return q1(c, pos + 1, l);
                case "3":
                    return q1(c, pos + 1, l);
                case "4":
                    return q1(c, pos + 1, l);
                case "5":
                    return q1(c, pos + 1, l);
                case "6":
                    return q1(c, pos + 1, l);
                case "7":
                    return q1(c, pos + 1, l);
                case "8":
                    return q1(c, pos + 1, l);
                case "9":
                    return q1(c, pos + 1, l);
                default:
                    return false;
            }
        }
        lexema = new Lexema(37, c, l);
        MainGUI.lexemas += lexema.getID() + " ";
        MainGUI.pila.push(lexema);
        return true;
    }
}