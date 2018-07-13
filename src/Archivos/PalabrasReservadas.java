/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import main.MainGUI;
import sintactico.Lexema;

/**
 *
 * @author Jose
 */
public class PalabrasReservadas {
    RandomAccessFile palabrasReservadas;
    String linea;
    String[] separado;
    Lexema lexema;
   
    public boolean validar(String c, int l) throws FileNotFoundException
    {
        try
        {
           palabrasReservadas =  new RandomAccessFile("palabrasReservadas", "r"); 
           linea = palabrasReservadas.readLine();
           while(linea != null)
           {
               separado = linea.split(" ");
               lexema = new Lexema(Integer.parseInt(separado[1]), separado[0], l);
               if(lexema.getToken().equals(c))
               {
                   if(lexema.getToken().equals(c))
                   {
                       MainGUI.lexemas += lexema.getID() + " ";
                       MainGUI.pila.push(lexema);
                       return true;
                   }
               }
               else
                   linea = palabrasReservadas.readLine();
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(palabrasReservadas != null)
                    palabrasReservadas.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
