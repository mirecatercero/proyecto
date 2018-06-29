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
            tablaSimbolos.seek(registro.getClave());
            System.out.println(registro.getClave());
            String linea = tablaSimbolos.readLine();
            if(linea == null)
            {
                tablaSimbolos.seek(registro.getClave());
                StringBuffer token = new StringBuffer(registro.getToken());
                StringBuffer tipo =  new StringBuffer(registro.getTipo());
                StringBuffer categoria = new StringBuffer(registro.getCategoria());
                StringBuffer valor = new StringBuffer(registro.getValor());
                StringBuffer longitud = new StringBuffer(registro.getLongitud());
                longitud.setLength(1);
                token.setLength(25);
                tipo.setLength(7);
                categoria.setLength(2);
                valor.setLength(30);
                
                //tablaSimbolos.writeLong(registro.getClave());
                tablaSimbolos.writeChars(token.toString());
                tablaSimbolos.writeChars(tipo.toString());
                tablaSimbolos.writeChars(longitud.toString());
                tablaSimbolos.writeChars(valor.toString());
                tablaSimbolos.writeChars(categoria.toString());
                tablaSimbolos.write(0x0d);
            }
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
            String linea = tablaSimbolos.readLine();
            while(linea != null)
            {
                System.out.println(linea);
                linea = tablaSimbolos.readLine();
            }
            tablaSimbolos.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean buscar(long clave)
    {
        try
        {
            tablaSimbolos = new RandomAccessFile("tablaSimbolos", "r");
            tablaSimbolos.seek(clave);
            String linea = tablaSimbolos.readLine();
            if(linea == null)
                return false;
            else return true;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
}
