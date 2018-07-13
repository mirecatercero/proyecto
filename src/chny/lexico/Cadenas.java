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
public class Cadenas {
    Lexema lexema;
    public boolean qo(String c, int pos)
    {   
        if(c.length() != 0)
        {
            String firstP = c.substring(0,1);
            String lastP = c.substring(pos-1,pos);
            String comilla = "\"";            
            if (firstP.equals(comilla)&& lastP.equals(comilla))
            {
                String cadena = c.substring(1,pos-1);
                int valid = cadena.indexOf("\"");
                if (valid ==-1)
                {
                    lexema = new Lexema(39, cadena, 0);
                    MainGUI.lexemas += lexema.getID() + " ";
                    MainGUI.pila.push(lexema);
                    return true;
                }
                else return false;
            }else
            {
                return false;
            }
        }
        return false;
    }
}
