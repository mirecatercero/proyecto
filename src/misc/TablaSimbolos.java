/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.io.RandomAccessFile;

/**
 *
 * @author Jose
 */
public class TablaSimbolos {
    RandomAccessFile tablaSimbolos;
    
    public TablaSimbolos()
    {
        
    }
    
    public void escribir(Registro registro)
    {
        try
        {
            tablaSimbolos = new RandomAccessFile("tablaSimbolos", "rw");
            System.out.println(tablaSimbolos.length());
            System.out.println(registro.getClave());
            if(registro.getClave() > tablaSimbolos.length())
            {
                System.out.println("Sí entra");
                tablaSimbolos.seek(registro.getClave());
                StringBuffer token = new StringBuffer(registro.getToken());
                StringBuffer tipo =  new StringBuffer(registro.getTipo());
                StringBuffer categoria = new StringBuffer(registro.getCategoria());
                StringBuffer valor = new StringBuffer(registro.getValor());
                token.setLength(25);
                tipo.setLength(7);
                categoria.setLength(3);
                valor.setLength(30);
                
                tablaSimbolos.writeChars(token.toString());
                tablaSimbolos.writeChars(tipo.toString());
                tablaSimbolos.writeChars(categoria.toString());
                tablaSimbolos.writeChars(valor.toString());
            }
            System.out.println(tablaSimbolos.length());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void leer()
    {
        try
        {
            tablaSimbolos = new RandomAccessFile("tablaSimbolos", "r");
            tablaSimbolos.seek(350);
            System.out.println(tablaSimbolos.readLine());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
