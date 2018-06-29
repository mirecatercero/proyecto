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
public class Operadores {
    RandomAccessFile operadores;
    String linea;
    
    public boolean validar(String c) throws FileNotFoundException
    {
        try
        {
           operadores =  new RandomAccessFile("operadores", "r"); 
           linea = operadores.readLine();
           while(linea != null)
           {
               if(linea.equals(c))
                   return linea.equals(c);
               else
                   linea = operadores.readLine();
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(operadores != null)
                    operadores.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
