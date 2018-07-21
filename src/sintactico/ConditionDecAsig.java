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
public class ConditionDecAsig {
    Lexema lexema;
    boolean aceptado;
    int cont = 0;
    SyntacticAnlysisTable syntacticAnlysisTable = new SyntacticAnlysisTable();
    
    public boolean q0(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            cont++;
            if(lexema.getID() == 1 || lexema.getID() == 2 || lexema.getID() == 3 || lexema.getID() == 4)//lee un entero, un real o boolean o lo demas alv
                q1(pila, mensaje, txtTraza, reglas);
            else if(lexema.getID() == 0)//lee si es ID
                q6(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        
        return aceptado;
    }
    
    private boolean q1(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            cont++;
            if(lexema.getID() == 0)
                q2(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q2(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            cont++;
            if(lexema.getID() == 16)
                q3(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
        
    private boolean q3(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            cont++;
            
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 39 || lexema.getID() == 0)
                q4(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q4(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            cont++;
            
            if(lexema.getID() == 35)
                q5(pila, mensaje, txtTraza, reglas);
            else if(lexema.getID() >= 14 && lexema.getID() <= 18)
                q1(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
        
    private boolean q5(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
    {
        aceptado = true;
        return aceptado;
    }
            
    private boolean q6(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            cont++;
            
            if(lexema.getID() == 16)
                q3(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
   public void buscaReglas(Lexema lexema, JTextArea txtTraza, String reglas)
    {
        int columna = 0;
        String token = lexema.getToken();
        if(lexema.getID() == 38 || lexema.getID() == 37 || lexema.getID() == 39)
            token = "val";
        else if(lexema.getID() == 0)
            token = "id";
        
        for(int i = 0; i < syntacticAnlysisTable.tas[0].length; i++)
        {
            if(syntacticAnlysisTable.tas[0][i].equals(token))
                columna = i;
        }
        
        for(int j = 1; j < syntacticAnlysisTable.tas.length; j++)
        {
            if(!syntacticAnlysisTable.tas[j][columna].equals(""))
                reglas += syntacticAnlysisTable.tas[j][columna] + "\n";
        }
        
        txtTraza.setText(txtTraza.getText() + "\n" + reglas);
        reglas = "";
    } 
   
   public boolean checkStatus()
    {
        return this.aceptado;
    }
    
    public void fixStack(Stack<Lexema> pila)
    {
        for(int i = 0; i < cont; i++)
        {
            pila.pop();
        }
    }
    
}
