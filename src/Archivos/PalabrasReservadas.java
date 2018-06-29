/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 *
 * @author Jose
 */
public class PalabrasReservadas {
    RandomAccessFile palabrasReservadas;
    String linea;
   
    public boolean validar(String c) throws FileNotFoundException
    {
        try
        {
           palabrasReservadas =  new RandomAccessFile("palabrasReservadas", "r"); 
           linea = palabrasReservadas.readLine();
           while(linea != null)
           {
               if(linea.equals(c))
                   return linea.equals(c);
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
