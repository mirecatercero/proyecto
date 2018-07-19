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
    
    public boolean q0(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)//lee un entero, un real o un identificador
                q1(pila, mensaje);
            else if(lexema.getID() == 8 || lexema.getID() == 9)//lee true o false
                q2(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q1(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() >= 21 && lexema.getID() <= 24)//lee un operador aritmético0
                q3(pila, mensaje);
            else if(lexema.getID() == 14 || lexema.getID() == 15 || lexema.getID() == 17 || lexema.getID() == 18 || lexema.getID() == 25 || lexema.getID() == 26)//lee un operador relacional
                q4(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q2(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 18)
                q8(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q3(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)//lee un entero, un real o un identificador
                q1(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q4(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)//lee un entero, un real o un identificador
                q5(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q5(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 19 || lexema.getID() == 20)// lee || o &&
                q0(pila, mensaje);
            else if(lexema.getID() >= 21 && lexema.getID() <= 24)//lee un operador aritmético
                q6(pila, mensaje);
            else if(lexema.getID() == 34)
                aceptado = true;
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q6(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 0)
                q7(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return false;
    }
    
    private boolean q7(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 34)
                aceptado = true;
            else if(lexema.getID() == 19 || lexema.getID() == 20)
                q0(pila, mensaje);
            else if(lexema.getID() >= 21 && lexema.getID() <= 24)//lee un operador aritmético
                q6(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q8(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 0 || lexema.getID() == 8 || lexema.getID() == 9)
                q9(pila, mensaje);
            else mensaje += "Error de sintaxis en linea " + lexema.getLinea() + "\n";
        }
        return aceptado;
    }
    
    private boolean q9(Stack<Lexema> pila, String mensaje)
    {
        aceptado = false;
        if(!pila.empty())
        {
            lexema = pila.pop();
            cont++;
            if(lexema.getID() == 19 || lexema.getID() == 20)
                q0(pila, mensaje);
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
    
    public boolean checkStatus()
    {
        return this.aceptado;
    }
    
    public void fixStack(Stack<Lexema> pila, int cont)
    {
        for(int i = 0; i < cont - 1; i++)
        {
            pila.pop();
        }
    }
}
