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
    
    public boolean q0(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 27 || lexema.getID() == 28)
                q1(pila);
        }
        return aceptado;
    }
    
    private boolean q1(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 0)
                q2(pila);
        }
        return aceptado;
    }
    
    private boolean q2(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 35)
                q3(pila);
        }
        return aceptado;
    }
    
    private boolean q3(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)
                q4(pila);
        }
        return aceptado;
    }
    
    private boolean q4(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 14 || lexema.getID() == 15 || lexema.getID() == 25 || lexema.getID() == 26)
                q5(pila);
        }
        return aceptado;
    }
    
    private boolean q5(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 0)
                q6(pila);
        }
        return aceptado;
    }
    
    private boolean q6(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 35)
                q7(pila);
        }
        return aceptado;
    }
    
    private boolean q7(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)
                    q8(pila);
        }
        return aceptado;
    }
    
    private boolean q8(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 16)
                q9(pila);
        }
        return aceptado;
    }
    
    private boolean q9(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 0)
                q10(pila);
        }
        return aceptado;
    }
    
    private boolean q10(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 1 || lexema.getID() == 2)
                q11(pila);
        }
        return aceptado;
    }
    
    private boolean q11(Stack<Lexema> pila)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 33)
                q12(pila);
        }
        return aceptado;
    }
    
    private boolean q12(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.pop();
            if(lexema.getID() == 5)
                aceptado = true;
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
