/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import main.MainGUI;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import sintactico.Lexema;
import main.MainGUI;

/**
 *
 * @author Jose
 */
public class Delimitadores {
    RandomAccessFile delimitadores;
    String linea;
    String[] separado;
    Lexema lexema;
    
    public boolean validar(String c, int l) throws FileNotFoundException
    {
        try
        {
           delimitadores =  new RandomAccessFile("delimitadores", "r"); 
           linea = delimitadores.readLine();
           while(linea != null)
           {
               separado = linea.split(" ");
               lexema = new Lexema(Integer.parseInt(separado[1]), separado[0], l);
               if(lexema.getToken().equals(c))
               {
                   if(lexema.getToken().equals(c))
                   {
                       //MainGUI.pila.push(lexema);
                       return true;
                   }
               }
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
    
    public String[] buscaLexema(String token) throws Exception
    {
        try
        {
            delimitadores = new RandomAccessFile("delimitadores", "r");
            linea = delimitadores.readLine();
            while(linea != null)
            {
                separado = linea.split(" ");
                lexema = new Lexema(Integer.parseInt(separado[1]), separado[0], 0);
                if(lexema.getToken().equals(token))
                {
                    return separado;
                }
                else linea = delimitadores.readLine();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
