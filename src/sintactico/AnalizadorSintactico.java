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
    Stack<Lexema> respaldo;
    ForStructure forStructure = new ForStructure();
    
    int llApertura, llCierre;
    int pApertura, pCierre;
    
    public AnalizadorSintactico()
    {
        this.llApertura = 0;
        this.llCierre = 0;
        this.pApertura = 0;
        this.pCierre = 0;
    }
    
    public boolean analisisSintactico(Stack<Lexema> pila)
    {   
        if(pila.size() >= 3)
        {
            boolean buscaciclo = false;
            boolean estructura = false;
            String mensaje = "Simón todo chido todo ok saca las guamas";
            boolean correcto = true;
            lActual = pila.pop();
        
            if(lActual.getID() == 31)
                llApertura++;
            if(lActual.getID() == 32)
                llCierre++;
            if(lActual.getID() == 33)
                pApertura++;
            if(lActual.getID() == 34)
                pCierre++;
        
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
            if(lActual.getID() == 31)
                llApertura++;
            if(lActual.getID() == 32)
                llCierre++;
            if(lActual.getID() == 33)
                pApertura++;
            if(lActual.getID() == 34)
            {
                buscaciclo = true;
                pCierre++;
                respaldo =(Stack<Lexema>) pila.clone();
                forStructure.q0(respaldo);
                if(forStructure.checkStatus())
                {
                    estructura = true;
                    pApertura++;
                    forStructure.fixStack(pila);
                    lActual = pila.pop();
                    lAnterior = pila.peek();
                    forStructure.resetStatus();
                }
            }
        }
        
        if(buscaciclo && !estructura)
        {
            mensaje = "Todo mal";
            correcto = false;
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
            System.out.println(llApertura);
            System.out.println(llCierre);
            System.out.println(pApertura);
            System.out.println(pCierre);
        if(producciones.producciones[lActual.getID()][lAnterior.getID()] == 0 || lAnterior.getID() != 12 || pApertura != pCierre || llApertura != llCierre)
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