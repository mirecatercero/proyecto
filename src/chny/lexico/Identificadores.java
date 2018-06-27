/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chny.lexico;

/**
 *
 * @author Jose
 */
public class Identificadores {
    public boolean q0(String c, int pos)
    {
        if(pos < c.length())
        {
            switch(c.substring(pos, pos + 1).toLowerCase())
            {
                case "a":
                    return q1(c, pos + 1);
                case "b":
                    return q1(c, pos + 1);
                case "c":
                    return q1(c, pos + 1);
                case "d":
                    return q1(c, pos + 1);
                case "e":
                    return q1(c, pos + 1);
                case "f":
                    return q1(c, pos + 1);
                case "g":
                    return q1(c, pos + 1);
                case "h":
                    return q1(c, pos + 1);
                case "i":
                    return q1(c, pos + 1);
                case "j":
                    return q1(c, pos + 1);
                case "k":
                    return q1(c, pos + 1);
                case "l":
                    return q1(c, pos + 1);
                case "m":
                    return q1(c, pos + 1);
                case "n":
                    return q1(c, pos + 1);
                case "o":
                    return q1(c, pos + 1);
                case "p":
                    return q1(c, pos + 1);
                case "q":
                    return q1(c, pos + 1);
                case "r":
                    return q1(c, pos + 1);
                case "s":
                    return q1(c, pos + 1);
                case "t":
                    return q1(c, pos + 1);
                case "u":
                    return q1(c, pos + 1);
                case "v":
                    return q1(c, pos + 1);
                case "w":
                    return q1(c, pos + 1);
                case "x":
                    return q1(c, pos + 1);
                case "y":
                    return q1(c, pos + 1);
                case "z":
                    return q1(c, pos + 1);
                case "_":
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
            switch(c.substring(pos, pos + 1).toLowerCase())
            {
                case "a":
                    return q1(c, pos + 1);
                case "b":
                    return q1(c, pos + 1);
                case "c":
                    return q1(c, pos + 1);
                case "d":
                    return q1(c, pos + 1);
                case "e":
                    return q1(c, pos + 1);
                case "f":
                    return q1(c, pos + 1);
                case "g":
                    return q1(c, pos + 1);
                case "h":
                    return q1(c, pos + 1);
                case "i":
                    return q1(c, pos + 1);
                case "j":
                    return q1(c, pos + 1);
                case "k":
                    return q1(c, pos + 1);
                case "l":
                    return q1(c, pos + 1);
                case "m":
                    return q1(c, pos + 1);
                case "n":
                    return q1(c, pos + 1);
                case "o":
                    return q1(c, pos + 1);
                case "p":
                    return q1(c, pos + 1);
                case "q":
                    return q1(c, pos + 1);
                case "r":
                    return q1(c, pos + 1);
                case "s":
                    return q1(c, pos + 1);
                case "t":
                    return q1(c, pos + 1);
                case "u":
                    return q1(c, pos + 1);
                case "v":
                    return q1(c, pos + 1);
                case "w":
                    return q1(c, pos + 1);
                case "x":
                    return q1(c, pos + 1);
                case "y":
                    return q1(c, pos + 1);
                case "z":
                    return q1(c, pos + 1);
                case "_":
                    return q1(c, pos + 1);
                default:
                    return false;
            }
        }
        return true;
    }
}
