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
public class Operadores {
    RandomAccessFile operadores;
    String linea;
    String[] separado;
    Lexema lexema;
    
    public boolean validar(String c, int l) throws FileNotFoundException
    {
        try
        {
           operadores =  new RandomAccessFile("operadores", "r"); 
           linea = operadores.readLine();
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
