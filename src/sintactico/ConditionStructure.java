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
public class ConditionStructure {
    boolean aceptado;
    Lexema lexema;
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
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)//lee un entero, un real o un identificador
                q1(pila, mensaje, txtTraza, reglas);
            else if(lexema.getID() == 8 || lexema.getID() == 9)//lee true o false
                q2(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
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
            if(lexema.getID() >= 21 && lexema.getID() <= 24)//lee un operador aritmético0
                q3(pila, mensaje, txtTraza, reglas);
            else if(lexema.getID() == 14 || lexema.getID() == 15 || lexema.getID() == 17 || lexema.getID() == 18 || lexema.getID() == 25 || lexema.getID() == 26)//lee un operador relacional
                q4(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
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
            if(lexema.getID() == 18)
                q8(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
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
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)//lee un entero, un real o un identificador
                q1(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
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
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0 || lexema.getID() == 8 || lexema.getID() == 9)//lee un entero, un real o un identificador
                q5(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q5(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
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
            if(lexema.getID() == 19 || lexema.getID() == 20)// lee || o &&
                q0(pila, mensaje, txtTraza, reglas);
            else if(lexema.getID() >= 21 && lexema.getID() <= 24)//lee un operador aritmético
                q6(pila, mensaje, txtTraza, reglas);
            else if(lexema.getID() == 34)
                aceptado = true;
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
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
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)
                q7(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return false;
    }
    
    private boolean q7(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
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
            if(lexema.getID() == 34)
                aceptado = true;
            else if(lexema.getID() == 19 || lexema.getID() == 20)
                q0(pila, mensaje, txtTraza, reglas);
            else if(lexema.getID() >= 21 && lexema.getID() <= 24)//lee un operador aritmético
                q6(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q8(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
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
            if(lexema.getID() == 0 || lexema.getID() == 8 || lexema.getID() == 9)
                q9(pila, mensaje, txtTraza, reglas);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q9(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
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
            if(lexema.getID() == 19 || lexema.getID() == 20)
                q0(pila, mensaje, txtTraza, reglas);
            else if(lexema.getID() == 34)
                aceptado = true;
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q10(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            
        }
        return aceptado;
    }
    
//    public boolean q0(Stack<Lexema> pila)
//    {
//        aceptado = false;
//        cont++;
//        if(!pila.empty())
//        {
//            lexema = pila.pop();
//            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)
//                q1(pila);
//        }
//        return aceptado;
//    }
//    
//    private boolean q1(Stack<Lexema> pila)
//    {
//        aceptado = false;
//        return aceptado;
//    }
    
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
    
    public void fixStack(Stack<Lexema> pila, int cont)
    {
        for(int i = 0; i < cont; i++)
        {
            pila.pop();
        }
    }
}
