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
public class ForStructure {
    boolean aceptado;
    Lexema lexema;
    SyntacticAnlysisTable syntacticAnlysisTable = new SyntacticAnlysisTable();
    int cont = 0;
    
    public boolean q0(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 33)
            {
                pApertura++;
                q1(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            }
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q1(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 1 || lexema.getID() == 2)
                q2(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q2(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 0)
                q3(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q3(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 16)
                q4(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q4(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 37 || lexema.getID() == 38)
                q5(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q5(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 35)
                q6(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q6(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)
                q7(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q7(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 14 || lexema.getID() == 15 || lexema.getID() == 25 || lexema.getID() == 26)
                    q8(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q8(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 0 || lexema.getID() == 37 || lexema.getID() == 38)
                q9(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q9(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 35)
                q10(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q10(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 0)
                q11(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q11(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 27 || lexema.getID() == 28)
                q12(pila, mensaje, txtTraza, reglas, pApertura, pCierre);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + ", cerca de " + lexema.getToken() + "\n";
        }
        return aceptado;
    }
    
    private boolean q12(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas, int pApertura, int pCierre)
    {
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lexema.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lexema.getToken() + "\n");
            buscaReglas(lexema, txtTraza, reglas);
            
            if(lexema.getID() == 34)
            {
                pCierre++;
                aceptado = true;
            }
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
    
    public void resetStatus()
    {
        this.aceptado = false;
    }
    
    public void fixStack(Stack<Lexema> pila)
    {
        for(int i = 0; i < 13; i++)
        {
            pila.pop();
        }
    }
    
    public void fixAfterError(Stack<Lexema> pila, int contador)
    {
        for(int i = 0; i < cont; i++)
            pila.pop();
    }
}
