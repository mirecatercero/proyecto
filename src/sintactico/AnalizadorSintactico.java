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
public class AnalizadorSintactico {
    Producciones producciones = new Producciones();
    Lexema lActual, lAnterior;
    
    public boolean analisisSintactico(Stack<Lexema> pila)
    {
        if(pila.size() >= 3)
        {
            String mensaje = "Simón todo chido todo ok saca las guamas";
        boolean correcto = true;
        lActual = pila.pop();
        while(!pila.empty() && MainGUI.pila.size() >= 2)
        {
            lAnterior = pila.peek();
            
            if(producciones.producciones[lActual.getID()][lAnterior.getID()] == 0)
            {
                mensaje = "Todo mal";
                correcto = false;
                lActual = pila.pop();
                lAnterior = pila.peek();
            }
            else
            {
                lActual = pila.pop();
                lAnterior = pila.peek();
            }
        }
        if(producciones.producciones[lActual.getID()][lAnterior.getID()] == 0)
        {
            mensaje = "Todo mal";
            correcto = false;
            lActual = pila.pop();
            lAnterior = pila.peek();
        }
        //lActual = lAnterior;
        lAnterior = pila.pop();
        if(producciones.producciones[lActual.getID()][lAnterior.getID()] == 0 || lAnterior.getID() != 12)
        {
            mensaje = "Todo mal";
            correcto = false;
        }
        
        System.out.println(mensaje);
        return correcto;
        }
        System.out.println("Testoydiciendoquestamal :c");
        return false;
    }
}
