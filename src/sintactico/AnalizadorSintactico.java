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
    
//    public void analisisSintactico(Stack<Lexema> pila, JTextArea txtTraza)
//    {   
//        error = "";
//        traza = "";
//        
//        if(pila.size() >= 3)
//        {
//            boolean buscaciclo = false;
//            boolean estructura = false;
//            
//            lexema = pila.pop();
//        }
//        if(pila.size() >= 3)
//        {
//                boolean buscaciclo = false;
//                boolean estructura = false;
//                String mensaje = "Simón todo chido todo ok saca las guamas";
//                boolean correcto = true ;
//                lActual = pila.pop();
//                if(lActual.getID() == 39)
//                    txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
//                else
//                    txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
//                
//                if(lActual.getID() == 31)
//                    llApertura++;
//                if(lActual.getID() == 32)
//                    llCierre++;
//                if(lActual.getID() == 33)
//                    pApertura++;
//                if(lActual.getID() == 34)
//                    pCierre++;
//                
//                while(!pila.empty() && MainGUI.pila.size() >= 2)
//                {
//                    lAnterior = pila.peek();
//                    
//                    if(producciones.producciones[lActual.getID()][lAnterior.getID()] == 0)
//                    {
//                        error += "Error de sintaxis en linea " + lAnterior.getLinea() + "\n";
//                        mensaje = "Todo mal";
//                        correcto = false;
//                        lActual = pila.pop();
//                        if(lActual.getID() == 39)
//                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
//                        else
//                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
//                        lAnterior = pila.peek();
//                    }
//                    else
//                    {
//                        lActual = pila.pop();
//                        if(lActual.getID() == 39)
//                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
//                        else
//                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
//                        lAnterior = pila.peek();
//                    }
//                    if(lActual.getID() == 31)
//                        llApertura++;
//                    if(lActual.getID() == 32)
//                        llCierre++;
//                    if(lActual.getID() == 33)
//                        pApertura++;
//                    if(lActual.getID() == 34)
//                    {
//                        buscaciclo = true;
//                        pCierre++;
//                        respaldo =(Stack<Lexema>) pila.clone();
//                        forStructure.q0(respaldo, error);
//                        if(forStructure.checkStatus())
//                        {
//                            estructura = true;
//                            pApertura++;
//                            forStructure.fixStack(pila);
//                            lActual = pila.pop();
//                            if(lActual.getID() == 39)
//                                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
//                            else
//                                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
//                            lAnterior = pila.peek();
//                            forStructure.resetStatus();
//                        }
//                        else
//                        {
//                            respaldo = (Stack<Lexema>) pila.clone();
//                            whileStructure.q0(respaldo, error);
//                            if(whileStructure.checkStatus())
//                            {
//                                estructura = true;
//                                pApertura++;
//                                whileStructure.fixStack(pila);
//                                lActual = pila.pop();
//                                if(lActual.getID() == 39)
//                                    txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
//                                else
//                                    txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
//                                lAnterior = pila.peek();
//                                whileStructure.resetStatus();
//                            }else
//                            {
//                                respaldo = (Stack<Lexema>) pila.clone();
//                                IfStructure.q0(respaldo, error);
//                                if(IfStructure.checkStatus())
//                                {
//                                    estructura = true;
//                                    pApertura++;
//                                    IfStructure.fixStack(pila);
//                                    lActual = pila.pop();
//                                    if(lActual.getID() == 39)
//                                        txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
//                                    else
//                                        txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
//                                    lAnterior = pila.peek();
//                                    IfStructure.resetStatus();
//                                }
//                            }
//                        }
//                    }
//                }
//                
//                if(buscaciclo && !estructura)
//                {
//                    mensaje = "Todo mal";
//                    correcto = false;
//                }
//                if(producciones.producciones[lActual.getID()][lAnterior.getID()] == 0)
//                {
//                    error += "Error de sintaxis en linea " + lAnterior.getLinea() + "\n";
//                    mensaje = "Todo mal";
//                    correcto = false;
//                    lActual = pila.pop();
//                    if(lActual.getID() == 39)
//                        txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
//                    else
//                        txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
//                    lAnterior = pila.peek();
//                }
//                
//                lAnterior = pila.pop();
//                if(producciones.producciones[lActual.getID()][lAnterior.getID()] == 0 || lAnterior.getID() != 12 || pApertura != pCierre || llApertura != llCierre)
//                {
//                    if(producciones.producciones[lActual.getID()][lAnterior.getID()] == 0);
//                    error += "Error de sintaxis en linea " + lAnterior.getLinea() + "\n";
//                    mensaje = "Todo mal";
//                    correcto = false;
//                }
//        }
//    }

    public void analisisSintactico(Stack<Lexema> pila, JTextArea txtTraza)
    {
        error = "";
        txtTraza.setText("");
        if(pila.size() >= 3)
        {
            boolean buscaciclo = false;
            boolean estructura = false;
            boolean correcto = true;
            
            while(!pila.empty() && pila.size() >= 2)
            {
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
                    forStructure.q0(respaldo, error, txtTraza, reglas);
                    if(forStructure.checkStatus())
                    {
                        estructura = true;
                        forStructure.fixStack(pila);
                        lActual = pila.pop();
                        if(lActual.getID() == 39)
                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
                        else
                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
                        buscaReglas(lActual, txtTraza);
                        lSiguiente = pila.peek();
                    }
                }
                
                if(lActual.getID() == 6)
                {
                    buscaciclo = true;
                    respaldo = (Stack<Lexema>) pila.clone();
                    whileStructure.q0(respaldo, error, txtTraza, reglas);
                    if(whileStructure.checkStatus())
                    {
                        estructura = true;
                        whileStructure.fixStack(pila);
                        lActual = pila.pop();
                        if(lActual.getID() == 39)
                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
                        else
                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
                        buscaReglas(lActual, txtTraza);
                        lSiguiente = pila.peek();
                    }
                }
                
                if(lActual.getID() == 7)
                {
                    buscaciclo = true;
                    respaldo = (Stack<Lexema>) pila.clone();
                    IfStructure.q0(respaldo, error, txtTraza, reglas);
                    if(IfStructure.checkStatus())
                    {
                        estructura = true;
                        IfStructure.fixStack(pila);
                        lActual = pila.pop();
                        if(lActual.getID() == 39)
                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"");
                        else
                            txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken());
                        buscaReglas(lActual, txtTraza);
                        lSiguiente = pila.peek();
                    }
                }
                
                if(buscaciclo && !estructura)
                    correcto = false;
                
                if(producciones.producciones[lActual.getID()][lSiguiente.getID()] == 0)
                {
                    correcto = false;
                    error += "Error de sintaxis en la linea " + lActual.getLinea();
                    lActual = pila.pop();
                    if(lActual.getID() == 39)
                        txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"\n");
                    else
                        txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken() + "\n");
                    buscaReglas(lActual, txtTraza);
                    lSiguiente = pila.peek();
                }
            }
            
            if(lActual.getID() == 39)
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token \"" + lActual.getToken() + "\"\n");
            else
                txtTraza.setText(txtTraza.getText() + "\n" + "Analizando token " + lActual.getToken() + "\n");
            buscaReglas(lActual, txtTraza);
            lSiguiente = pila.pop();
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