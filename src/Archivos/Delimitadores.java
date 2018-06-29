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
public class Delimitadores {
    RandomAccessFile delimitadores;
    String linea;
    
    public boolean validar(String c) throws FileNotFoundException
    {
        try
        {
           delimitadores =  new RandomAccessFile("delimitadores", "r"); 
           linea = delimitadores.readLine();
           while(linea != null)
           {
               if(linea.equals(c))
                   return linea.equals(c);
               else
                   linea = delimitadores.readLine();
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(delimitadores != null)
                    delimitadores.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
