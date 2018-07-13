/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintactico;

import java.util.Stack;
import sintactico.SintacticalAnalyzer;

/**
 *
 * @author Jose
 */
public class While
{
    Lexema lexema;
    boolean aceptado;
    
    public boolean q0(Stack<Lexema> pila)//Llave de cierre }
    {
        aceptado = false;
        if(pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 102)
            {
                pila.pop();
                q1(pila);
            }
        }
        return aceptado;
    }
    
    private boolean q1(Stack<Lexema> pila)//Llave de apertura { o código
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 101)
            {
                pila.pop();
                q2(pila);
            }
            else
            {
                pila.pop();
                q3(pila);
            }
        }
        return aceptado;
    }
    
    private boolean q2(Stack<Lexema> pila)//condicion del while
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 105)
            {
                pila.pop();
                SintacticalAnalyzer.acondicion.q0(SintacticalAnalyzer.pila);
            }
        }
        return false;
    }
    
    private boolean q3(Stack<Lexema> pila)
    {
        return false;
    }
}