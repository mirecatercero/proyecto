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
public class ConditionStructure {
    boolean aceptado;
    Lexema lexema;
    int cont = 0;
    
    public boolean q0(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
        }
        return aceptado;
    }
}
