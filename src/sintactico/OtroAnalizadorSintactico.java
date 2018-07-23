/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintactico;

import java.util.Stack;
import javax.swing.JTextArea;

/**
 *
 * @author Jose
 */
public class OtroAnalizadorSintactico {
    SyntacticAnlysisTable syntacticAnlysisTable = new SyntacticAnlysisTable();
    Lexema lexema;
    String terminal, regla, segundaRegla, s = "", error = "";
    Stack<String> reglas = new Stack<String>();
    int columna;
    String[] reglaSeparada, segundaReglaSeparada;
    
    public void analisisSintactico(Stack<Lexema> pila, JTextArea txtTraza)
    {
        reglas.push("PRINCIPAL");
        while(!pila.empty())
        {
            lexema = pila.peek();
            
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 39)
                terminal = "val";
            else if(lexema.getID() == 0)
                terminal = "id";
            else terminal = lexema.getToken();
            
            if(terminal.equals(reglas.peek()))
            {
                if(!pila.empty())
                    pila.pop();
                if(!reglas.empty())
                    reglas.pop();
            }
            
            if(!reglas.empty())
                s = reglas.pop();
            
            if(!pila.empty())
            {
                lexema = pila.peek();
                
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando el token " + lexema.getToken() + "\n");
                regla = syntacticAnlysisTable.buscaReglas(lexema, s);
            }
            
            if(!regla.equals("ERROR"))
            {
                txtTraza.setText(txtTraza.getText() + "Regla a analizar: " + regla + "\n");
                if(!regla.equals("E"))
                {
                    reglaSeparada = regla.split(" -> ");
                    reglaSeparada = reglaSeparada[1].split(" ");
                        for(int i = reglaSeparada.length - 1; i >= 0; i--)
                        {
                            if(!reglaSeparada[i].equals("E"))
                                reglas.push(reglaSeparada[i]);
                        }
                }
            }
            else error += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
    }
    
    public String getErrors()
    {
        return this.error;
    }
}
