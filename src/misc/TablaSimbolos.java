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
            StringBuffer token = new StringBuffer(registro.getToken());
            StringBuffer tipo =  new StringBuffer(registro.getTipo());
            StringBuffer categoria = new StringBuffer(registro.getCategoria());
            StringBuffer valor = new StringBuffer(registro.getValor());
            StringBuffer longitud = new StringBuffer(registro.getLongitud());
            longitud.setLength(1);
            token.setLength(25);
            tipo.setLength(7);
            categoria.setLength(2);
            valor.setLength(15);
                
            //tablaSimbolos.writeLong(registro.getClave());
            tablaSimbolos.writeChars(token.toString() + " ");
            tablaSimbolos.writeChars(tipo.toString());
            tablaSimbolos.writeChars(longitud.toString());
            tablaSimbolos.writeChars(valor.toString());
            tablaSimbolos.writeChars(categoria.toString());
            tablaSimbolos.writeChars("\n");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void leer(long clave)
    {
        try
        {
            tablaSimbolos = new RandomAccessFile("tablaSimbolos", "r");
            tablaSimbolos.seek(clave);
            System.out.println(tablaSimbolos.length());
            String token = "";
            String linea = tablaSimbolos.readLine();
            int i = 0;
            do
            {
                token += Character.toString(linea.charAt(i));
                i++;
            }while(!Character.toString(linea.charAt(i)).equals(" "));
            System.out.println(token);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean buscar(Registro registro)
    {
        try
        {
            tablaSimbolos = new RandomAccessFile("tablaSimbolos", "r");
            if(tablaSimbolos.length() > 0)
            {
                if(registro.getClave() <= tablaSimbolos.length() - 104)
                {
                    tablaSimbolos.seek(registro.getClave());
                    String token = "";
                    String linea = tablaSimbolos.readLine();
                    int i = 0;
                    if(Character.toString(linea.charAt(i)).equals("\""))
                    {
                        do
                        {
                            if((int) linea.charAt(i) != 0)
                                token += Character.toString(linea.charAt(i));
                            i++;
                        }while(!Character.toString(linea.charAt(i)).equals("\""));
                    }else
                    {
                        do
                        {
                            if((int) linea.charAt(i) != 0)
                                token += Character.toString(linea.charAt(i));
                            i++;
                        }while(!Character.toString(linea.charAt(i)).equals(" "));
                    }
                    if(token.indexOf(registro.getToken()) != -1)
                        return true;
                    else return false;
                }
            }
            else return false;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
