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
public class WhileStructure {
    boolean aceptado;
    Lexema lexema;
    ConditionStructure conditionStructure = new ConditionStructure();
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
            
            if(lexema.getID() == 33)
                q1(pila, mensaje, txtTraza, reglas);
        }
        return aceptado;
    }

    private boolean q1(Stack<Lexema> pila, String mensaje, JTextArea txtTraza, String reglas)
    {
        aceptado = false;
        if(!pila.empty())
            conditionStructure.q0(pila, mensaje, txtTraza, reglas);
        if(conditionStructure.checkStatus())
            aceptado = true;
        else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        return aceptado;
    }
//    
//    private boolean q1(Stack<Lexema> pila, String mensaje)
//    {
//        aceptado = false;
//        if(!pila.empty())
//        {
//            lexema = pila.pop();
//            if(lexema.getID() == 6)
//                aceptado = true;
//            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
//        }
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
    
    public void resetStatus()
    {
        this.aceptado = false;
    }
    
    public void fixStack(Stack<Lexema> pila)
    {
        conditionStructure.fixStack(pila, conditionStructure.cont);
    }
}
