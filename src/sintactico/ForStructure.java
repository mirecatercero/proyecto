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
public class ForStructure {
    boolean aceptado;
    Lexema lexema;
    
    public boolean q0(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 5)
                q1(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q1(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 33)
                q2(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q2(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 1 || lexema.getID() == 2)
                q3(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q3(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 0)
                q4(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q4(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 16)
                q5(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q5(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 37 || lexema.getID() == 38)
                q6(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q6(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 35)
                q7(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q7(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)
                    q8(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q8(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 14 || lexema.getID() == 15 || lexema.getID() == 25 || lexema.getID() == 26)
                q9(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q9(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 0 || lexema.getID() == 37 || lexema.getID() == 38)
                q10(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q10(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 35)
                q11(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q11(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 0)
                q12(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
    }
    
    private boolean q12(Stack<Lexema> pila, String mensaje)
    {
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 28 || lexema.getID() == 29)
                aceptado = true;
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea();
        }
        return aceptado;
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
        for(int i = 0; i < 11; i++)
        {
            pila.pop();
        }
    }
}
