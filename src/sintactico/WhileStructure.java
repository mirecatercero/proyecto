/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintactico;

import java.util.Stack;

/**
 *
 * @author Jose
 */
public class WhileStructure {
    boolean aceptado;
    Lexema lexema;
    ConditionStructure conditionStructure = new ConditionStructure();
    
    public boolean q0(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 33)
                q1(pila, mensaje);
        }
        return aceptado;
    }

    private boolean q1(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
            conditionStructure.q0(pila, mensaje);
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
