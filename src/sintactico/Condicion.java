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
public class Condicion
{
    Lexema lexema;
    boolean aceptado;
    
    public boolean q0(Stack<Lexema> pila)//identificador, true, false, entero, flotante o String
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 601 || lexema.getID() == 701 || lexema.getID() == 901 || lexema.getID() == 309 || lexema.getID() == 310 || lexema.getID() == 401)
            {
                pila.pop();
                q1(pila);
            }
        }
        return false;
    }
    
    private boolean q1(Stack<Lexema> pila)//operador relacional
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 201 || lexema.getID() == 202 || lexema.getID() == 204 || lexema.getID() == 205 || lexema.getID() == 212 || lexema.getID() == 213)
            {
                pila.pop();
                q2(pila);
            }
        }
        return aceptado;
    }
    
    private boolean q2(Stack<Lexema> pila)//identificador, true, false, entero, flotante o String
    {
        aceptado = true;
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 601 || lexema.getID() == 701 || lexema.getID() == 901 || lexema.getID() == 309 || lexema.getID() == 310 || lexema.getID() == 401)
            {
                pila.pop();
            }
        }
        return aceptado;
    }
    
    private boolean q3(Stack<Lexema> pila)//doble pipe o doble ampersand
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 206 || lexema.getID() == 207)
            {
                q0(pila);
            }
        }
        return aceptado;
    }
}
