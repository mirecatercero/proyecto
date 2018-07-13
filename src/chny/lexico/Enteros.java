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
    
    public boolean qo(String c, int pos)
    {
        if(pos < c.length())
        {
                        switch(c.substring(pos, pos + 1))
            {
                case "0":
                    return q1(c, pos + 1);
                case "1":
                    return q1(c, pos + 1);
                case "2":
                    return q1(c, pos + 1);
                case "3":
                    return q1(c, pos + 1);
                case "4":
                    return q1(c, pos + 1);
                case "5":
                    return q1(c, pos + 1);
                case "6":
                    return q1(c, pos + 1);
                case "7":
                    return q1(c, pos + 1);
                case "8":
                    return q1(c, pos + 1);
                case "9":
                    return q1(c, pos + 1);
                default:
                    return false;
            }
        }
        return false;
    }
    
    private boolean q1(String c, int pos)
    {
        if(pos < c.length())
        {
                    switch(c.substring(pos, pos + 1))
            {
                case "0":
                    return q1(c, pos + 1);
                case "1":
                    return q1(c, pos + 1);
                case "2":
                    return q1(c, pos + 1);
                case "3":
                    return q1(c, pos + 1);
                case "4":
                    return q1(c, pos + 1);
                case "5":
                    return q1(c, pos + 1);
                case "6":
                    return q1(c, pos + 1);
                case "7":
                    return q1(c, pos + 1);
                case "8":
                    return q1(c, pos + 1);
                case "9":
                    return q1(c, pos + 1);
                default:
                    return false;
            }
        }
        lexema = new Lexema(601, c, 0);
        MainGUI.lexemas += lexema.getID() + " ";
        return true;
    }
}