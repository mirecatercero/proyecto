/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintactico;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JTextArea;

/**
 *
 * @author Jose
 */
public class OtroAnalizadorSintactico {
    
    //public static ArrayList<String> Codigo = AnalisisLexico.Codigo;
    public static ArrayList<String> tabla = new ArrayList<>();
    SyntacticAnlysisTable sintactica = new SyntacticAnlysisTable();
    Lexema lexema;
    String simbolo;
    String error;
          
    public void analisis(ArrayList<Lexema> Codigo, JTextArea txtTraza){
        error = "";
        int ban =0; 
        Codigo.add(new Lexema(100, "$", 0));
        tabla.add("$");
        tabla.add("Inicio");
        String rempleaso;
        
        while (!Codigo.isEmpty())
        {
            lexema = Codigo.get(0);
            if(lexema.getID() == 37)
                simbolo = "INT";
            else if(lexema.getID() == 38)
                simbolo = "FLOAT";
            else if(lexema.getID() == 39)
                simbolo = "STRING";
            else if(lexema.getID() == 0)
                simbolo = "id";
            else if(lexema.getID() == 8 || lexema.getID() == 9)
                simbolo = "BOOLEAN";
            else simbolo = lexema.getToken();
            
            if(simbolo.equals(tabla.get((tabla.size()-1))))
            {
                Codigo.remove(0);
                tabla.remove((tabla.size()-1));
                continue;
            }
            
            lexema = Codigo.get(0);
            if(lexema.getID() == 37)
                simbolo = "INT";
            else if(lexema.getID() == 38)
                simbolo = "FLOAT";
            else if(lexema.getID() == 39)
                simbolo = "STRING";
            else if(lexema.getID() == 0)
                simbolo = "id";
            else if(lexema.getID() == 8 || lexema.getID() == 9)
                simbolo = "BOOLEAN";
            else simbolo = lexema.getToken();
            
            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando el token " + lexema.getToken() + "\n");
            
            rempleaso = sintactica.buscaReglas(simbolo, tabla.remove((tabla.size()-1)));
            if(!rempleaso.equals(""))
            {
                txtTraza.setText(txtTraza.getText() + "Regla a analizar: " + sintactica.tabla2[sintactica.not][sintactica.ter] + "\n");
                if(!rempleaso.equals("E"))
                {
                    String[] separa = rempleaso.split(" ");
                    for (int i = separa.length-1; i >= 0 ; i--)
                        tabla.add(separa[i]);
                }
            }
            else
            {
                error += "Error de sintaxis en linea " + lexema.linea + ", cerca de " + lexema.getToken();
                System.out.println("Error alv");
                tabla.clear();
                Codigo.clear();
                ban = 1;
                break;
            }     
        }
        
        if(tabla.isEmpty() && Codigo.isEmpty() && ban ==0)
            System.out.println("Sobres simon todo chido");
        else
        {
            if(error.equals(""))
                error += "Error de sintaxis en linea " + lexema.linea + ", cerca de " + lexema.getToken();
            tabla.clear();
            Codigo.clear();
        }   
    }
    
    public String getErrors()
    {
        return this.error;
    }
}
