package sintactico;


import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import main.MainGUI;

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
        
        if(pila.size() > 1)
        {
            Lexema tope = pila.peek();
            if(tope.getID() == 12)
            {
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
                            forStructure.q0(respaldo, error, txtTraza, reglas, pApertura, pCierre);
                            if(forStructure.checkStatus())
                            {
                                estructura = true;
                                forStructure.fixStack(pila);
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
                        }
                    }
                
                    if(!pila.empty())
                    {
                        lSiguiente = pila.pop();
                        if(lSiguiente.getID() == 31)
                            llApertura++;
                        if(lSiguiente.getID() == 32)
                            llCierre++;
                        if(lSiguiente.getID() == 33)
                            pApertura++;
                        if(lSiguiente.getID() == 34)
                            pCierre++;
                    }
                    
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
                    
                    String m = "";
                    
                    System.out.println(llApertura + " " + llCierre + " " + pApertura + " " + pCierre);
                    if(!correcto)
                        m = "Análiis sintáctico finalizado con errores";
                    else m = "Análisis sintáctico finalizado correctamente";
                    
                    if(llApertura != llCierre || pApertura != pCierre)
                        txtTraza.setText(txtTraza.getText() + "\n" + "Análiis sintáctico finalizado con errores. El número de llaves de apertura/cierre y paréntesis de apertura/cierre no coincide");
                    else txtTraza.setText(txtTraza.getText() + "\n" + "Análisis sintáctico finalizado correctamente");
                }
            }
            else txtTraza.setText("Error de sintaxis: programa no comienza con la palabra reservada class. El análisis sintáctico no será llevado a cabo");
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