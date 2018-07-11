/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintactico;

import java.util.Stack;
import main.MainGUI;

/**
 *
 * @author Jose
 */
public class AutomataPila {
    Lexema lexema;
    
    public boolean q0(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 102)
            {
                pila.pop();
                return q1(pila);
            }
        }
        return false;
    }
    
    private boolean q1(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 101)
            {
                pila.pop();
                return q2(pila);
            }
            else if(lexema.getID() == 103)
            {
                pila.pop();
                return q4(pila);
            }
        }
        return false;
    }
    
    private boolean q2(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 312)
            {
                pila.pop();
                return q3(pila);
            }
        }
        return false;
    }
    
    private boolean q3(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
        }
        return true;
    }
    
    private boolean q4(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 401)
            {
                pila.pop();
                q5(pila);
            }
            else if(lexema.getID() == 601 || lexema.getID() == 701 || lexema.getID() == 801 || lexema.getID() == 901)
            {
                pila.pop();
                q14(pila);
            }
        }
        return true;
    }
    
    private boolean q5(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 401)
            {
                pila.pop();
                return q6(pila);
            }
        }
        return false;
    }
    
    private boolean q6(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 305 || lexema.getID() == 306 || lexema.getID() == 307 || lexema.getID() == 308)
            {
                pila.pop();
                return q10(pila);
            }
        }
        return false;
    }
    
    private boolean q10(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 3012)
            {
                pila.pop();
                q3(pila);
            }
        }
        return false;
    }
    
    private boolean q14(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 203)
            {
                pila.pop();
                q15(pila);
            }
        }
        return false;
    }
    
    private boolean q15(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 401)
            {
                pila.pop();
                q16(pila);
            }
        }
        return false;
    }
    
    private boolean q16(Stack<Lexema> pila)
    {
        if(!pila.empty())
        {
            lexema = pila.peek();
            if(lexema.getID() == 101)
            {
                pila.pop();
                q10(pila);
            }
        }
        return false;
    }
}
