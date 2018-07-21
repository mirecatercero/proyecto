/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintactico;


import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import main.MainGUI;
/**
 *
 * @author Jose
 */
public class AnalizadorSintactico {
    Producciones producciones = new Producciones();
    SyntacticAnlysisTable syntacticAnlysisTable = new SyntacticAnlysisTable();
    Lexema lActual, lSiguiente, lexema;
    Stack<Lexema> respaldo;
    ForStructure forStructure = new ForStructure();
    WhileStructure whileStructure = new WhileStructure();
    IfStructure IfStructure = new IfStructure();
    ConditionDecAsig conditionDecAsig = new ConditionDecAsig();
    
    int llApertura, llCierre;
    int pApertura, pCierre;
    String error;
    String traza;
    String reglas = "";
    
    public AnalizadorSintactico()
    {
        this.llApertura = 0;
        this.llCierre = 0;
        this.pApertura = 0;
        this.pCierre = 0;
    }

    public void analisisSintactico(Stack<Lexema> pila, JTextArea txtTraza)
    {
        String s = "All good";
        error = "";
        txtTraza.setText("");
        if(pila.size() >= 3)
        {
            boolean buscaciclo = false;
            boolean estructura = false;
            boolean correcto = true;
            
            while(!pila.empty() && pila.size() >= 2)
            {
                //respaldo = (Stack<Lexema>) pila.clone();
                //conditionDecAsig.q0(respaldo, error, txtTraza, reglas);
                //if(conditionDecAsig.checkStatus())
                    //conditionDecAsig.fixStack(pila);
                //else s = "ya valio";
                
                lActual = pila.pop();
                
                if(lActual.getID() == 31)
                    llApertura++;
                if(lActual.getID() == 32)
                    llCierre++;
                if(lActual.getID() == 33)
                    pApertura++;
                if(lActual.getID() == 34)
                    pCierre++;
                
                if(lActual.getID() == 39)
                    txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"\n");
                else
                    txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken() + "\n");
                buscaReglas(lActual, txtTraza);
                lSiguiente = pila.peek();                
                
                if(lActual.getID() == 5)
                {
                    buscaciclo = true;
                    respaldo = (Stack<Lexema>) pila.clone();
                    forStructure.q0(respaldo, error, txtTraza, reglas, pApertura, pCierre);
                    if(forStructure.checkStatus())
                    {
                        estructura = true;
                        forStructure.fixStack(pila);
//                        lActual = pila.pop();
//                        
//                        if(lActual.getID() == 31)
//                            llApertura++;
//                        if(lActual.getID() == 32)
//                            llCierre++;
//                        if(lActual.getID() == 33)
//                            pApertura++;
//                        if(lActual.getID() == 34)
//                            pCierre++;
//                        
//                        if(lActual.getID() == 39)
//                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
//                        else
//                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
//                        buscaReglas(lActual, txtTraza);
//                        lSiguiente = pila.peek();
                    }
                    else correcto = false;
                }
                
                if(lActual.getID() == 6)
                {
                    buscaciclo = true;
                    respaldo = (Stack<Lexema>) pila.clone();
                    whileStructure.q0(respaldo, error, txtTraza, reglas, pApertura, pCierre);
                    if(whileStructure.checkStatus())
                    {
                        estructura = true;
                        whileStructure.fixStack(pila);
//                        lActual = pila.pop();
//                        
//                        if(lActual.getID() == 31)
//                            llApertura++;
//                        if(lActual.getID() == 32)
//                            llCierre++;
//                        if(lActual.getID() == 33)
//                            pApertura++;
//                        if(lActual.getID() == 34)
//                            pCierre++;
//                        
//                        if(lActual.getID() == 39)
//                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
//                        else
//                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
//                        buscaReglas(lActual, txtTraza);
//                        if(!pila.empty())
//                            lSiguiente = pila.peek();
                    }
                    else correcto = false;
                }
                
                if(lActual.getID() == 7)
                {
                    buscaciclo = true;
                    respaldo = (Stack<Lexema>) pila.clone();
                    IfStructure.q0(respaldo, error, txtTraza, reglas, pApertura, pCierre);
                    if(IfStructure.checkStatus())
                    {
                        estructura = true;
                        IfStructure.fixStack(pila);
//                        lActual = pila.pop();
//                        
//                        if(lActual.getID() == 31)
//                            llApertura++;
//                        if(lActual.getID() == 32)
//                            llCierre++;
//                        if(lActual.getID() == 33)
//                            pApertura++;
//                        if(lActual.getID() == 34)
//                            pCierre++;
//                        
//                        if(lActual.getID() == 39)
//                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
//                        else
//                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
//                        buscaReglas(lActual, txtTraza);
//                        if(!pila.empty())
//                        lSiguiente = pila.peek();
                    }
                    else correcto = false;
                }
                
                if(buscaciclo && !estructura)
                    correcto = false;
                
                if(producciones.producciones[lActual.getID()][lSiguiente.getID()] == 0)
                {
                    s = "ya valio";
                    correcto = false;
                    error += "Error de sintaxis en la linea " + lActual.getLinea() + ", cerca de " + lActual.getToken() + "\n";
//                    lActual = pila.pop();
//                    
//                    if(lActual.getID() == 31)
//                            llApertura++;
//                        if(lActual.getID() == 32)
//                            llCierre++;
//                        if(lActual.getID() == 33)
//                            pApertura++;
//                        if(lActual.getID() == 34)
//                            pCierre++;
//                    
//                    if(lActual.getID() == 39)
//                        txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"\n");
//                    else
//                        txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken() + "\n");
//                    buscaReglas(lActual, txtTraza);
//                    if(!pila.empty())
//                    lSiguiente = pila.peek();
                }
            }
            
            if(!pila.empty())
                lSiguiente = pila.pop();
            
            if(lActual.getID() == 31)
                llApertura++;
            if(lActual.getID() == 32)
                llCierre++;
            if(lActual.getID() == 33)
                pApertura++;
            if(lActual.getID() == 34)
                pCierre++;
            
            if(lActual.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken() + "\n");
            buscaReglas(lActual, txtTraza);
            
            System.out.println(llApertura + " " + llCierre + " " + pApertura + " " + pCierre);
            if(!correcto)
                txtTraza.setText(txtTraza.getText() + "\n" + "Análiis sintáctico finalizado con errores");
            else txtTraza.setText(txtTraza.getText() + "\n" + "Análisis sintáctico finalizado correctamente");
            
            if(llApertura != llCierre || pApertura != pCierre)
                txtTraza.setText(txtTraza.getText() + "\n" + "Análiis sintáctico finalizado con errores. El número de llaves de apertura/cierre y paréntesis de apertura/cierre no coincide");
            else txtTraza.setText(txtTraza.getText() + "\n" + "Análisis sintáctico finalizado correctamente");
        }
    }
    
    public void buscaReglas(Lexema lexema, JTextArea txtTraza)
    {
        int columna = 0;
        String token = lexema.getToken();
        if(lexema.getID() == 38 || lexema.getID() == 37 || lexema.getID() == 39)
            token = "val";
        else if(lexema.getID() == 0)
            token = "id";
        
        for(int i = 0; i < syntacticAnlysisTable.tas[0].length; i++)
        {
            if(syntacticAnlysisTable.tas[0][i].equals(token))
                columna = i;
        }
        
        for(int j = 1; j < syntacticAnlysisTable.tas.length; j++)
        {
            if(!syntacticAnlysisTable.tas[j][columna].equals(""))
                reglas += syntacticAnlysisTable.tas[j][columna] + "\n";
        }
        
        txtTraza.setText(txtTraza.getText() + "\n" + reglas);
        reglas = "";
    }
    
    public String getErrors()
    {
        return this.error;
    }
}