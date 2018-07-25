/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintactico;

/**
 *
 * @author Jose
 */
public class SyntacticAnlysisTable {
    
    public static int ter,not;
    
    public static String [] terminales = {"class", "{", "}", ";", "id", "=", ",", "int", "String", "float", "boolean"
                            , "INT", "STRING", "FLOAT", "BOOLEAN", "+", "-", "*", "/", "for", "(", ")"
                            , ">", "<", ">=", "<=", "==", "++", "--", "while", "if", "&&", "||", "else"};

    public static String[] noterminales = {"Inicio", "Inicio'", "Codigos", "Codigo", "InicioV"
                             , "Asignacion", "Asignacion'", "OP", "Multiple", "TipoD"
                             , "V", "Operador", "CambioV", "Ciclo", "FOR"
                             , "Sentencia", "Sentencia'", "InicioF", "InicioF'", "Igual"
                             , "CondicionF", "CondicionF'", "Relacional'" ,"ActualizarF", "Relacional"
                             , "Aumento", "WHILE", "WHILE'", "CondicionW", "CondicionW'"
                             , "Logico", "Decision", "Decision'", "Else", "Else'"};
    
    public static String[] noterminales2 = {"PRINCIPAL", "PRINCIPAL'", "CONTENIDOS", "CONTENIDO", "DECLARACIONES"
                             , "VARIABLE", "VARIABLE'", "OP", "SIG-VAR", "TIPO"
                             , "VAL", "OPERADORARITMETICO", "CambioV", "CICLO", "FOR"
                             , "FORMA-FOR", "FORMA-FOR'", "DEC", "DEC'", "A-FOR"
                             , "OP", "OP'", "OPERADOR-RELACIONAL'" ,"AU", "OPERADOR-RELACIONAL"
                             , "MASMENOS", "WHILE", "WHILE'", "FORMA-WHILE", "FORMA-WHILE'"
                             , "LOGICO", "IF", "IF'", "ELSE", "ELSE'"};
    
    
    public static String[][] tabla = new String[35][34];
    public static String[][] tabla2 = new String[35][34];
    
    public void llenado2(){
        for ( int j = 0; j < 35; j++ ){
            for ( int k = 0; k < 34; k++ ){
                tabla2[j][k] = "";
            }   
        }
        
        tabla2[0][0]= "class PRINCIPAL'";
        
        tabla2[1][1]= "{ CONTENIDOS }";
        
        tabla2[2][2]= "E";   
        tabla2[2][4]= "CONTENIDO CONTENIDOS";
        tabla2[2][7]= "CONTENIDO CONTENIDOS";
        tabla2[2][8]= "CONTENIDO CONTENIDOS";
        tabla2[2][9]= "CONTENIDO CONTENIDOS";
        tabla2[2][10]= "CONTENIDO CONTENIDOS";
        tabla2[2][19]= "CONTENIDO CONTENIDOS";
        tabla2[2][29]= "CONTENIDO CONTENIDOS";
        tabla2[2][30]= "CONTENIDO CONTENIDOS";
        
        tabla2[3][4]= "DECLARACIONES ;";
        tabla2[3][7]= "DECLARACIONES ;";
        tabla2[3][8]= "DECLARACIONES ;";
        tabla2[3][9]= "DECLARACIONES ;";
        tabla2[3][10]= "DECLARACIONES ;";
        tabla2[3][19]= "CICLO";
        tabla2[3][29]= "CICLO";
        tabla2[3][30]= "IF";
        
        tabla2[4][7]= "TIPO VARIABLE SIG-VAR";
        tabla2[4][8]= "TIPO VARIABLE SIG-VAR";
        tabla2[4][9]= "TIPO VARIABLE SIG-VAR";
        tabla2[4][10]= "TIPO VARIABLE SIG-VAR";
        
        tabla2[5][4]= "id VARIABLE'";
        
        tabla2[6][3]= "E";
        tabla2[6][5]= "= VAL OP";
        tabla2[6][6]= "E";
        
        tabla2[7][3]= "E";
        tabla2[7][6]= "E";
        tabla2[7][15]= "OPERADOR-ARITMETICO VAL OP";
        tabla2[7][16]= "OPERADOR VAL OP";
        tabla2[7][17]= "OPERADOR VAL OP";
        tabla2[7][18]= "OPERADOR VAL OP";
        
        tabla2[8][3]= "E";
        tabla2[8][6]= ", VARIABLE SIG-VAR";
        
        tabla2[9][7]= "int";
        tabla2[9][8]= "string";
        tabla2[9][9]= "float";
        tabla2[9][10]= "boolean";
        
        tabla2[10][4]= "id";
        tabla2[10][11]= "INT";
        tabla2[10][12]= "STRING";
        tabla2[10][13]= "FLOAT";
        tabla2[10][14]= "BOOLEAN";
        
        tabla2[11][15]= "+";
        tabla2[11][16]= "-";
        tabla2[11][17]= "*";
        tabla2[11][18]= "/";
        
        tabla2[12][4]= "VARIABLE";
        
        tabla2[13][19]= "FOR";
        tabla2[13][29]= "WHILE";
        
        tabla2[14][19]= "for FORMA-FOR PRINCIPAL'";
        
        tabla2[15][20]= "( PRINCIPAL' )";
        
        tabla2[16][7]= "DEC OP AU";
        
        tabla2[17][7]= "int DEC'";
        
        tabla2[18][4]= "id A-FOR";
        
        tabla2[19][5]= "= VAL";
        
        tabla2[20][3]= "; OP' ;";
        
        tabla2[21][4]= "VAL OPERADOR-RELACIONAL'";
        tabla2[21][11]= "VAL OPERADOR-RELACIONAL'";
        tabla2[21][12]= "VAL OPERADOR-RELACIONAL'";
        tabla2[21][13]= "VAL OPERADOR-RELACIONAL'";
        tabla2[21][14]= "VAL OPERADOR-RELACIONAL'";
        
        tabla2[22][22]= "OPERADOR-RELACIONAL VAL";
        tabla2[22][23]= "OPERADOR-RELACIONAL VAL";
        tabla2[22][24]= "OPERADOR-RELACIONAL VAL";
        tabla2[22][25]= "OPERADOR-RELACIONAL VAL";
        tabla2[22][26]= "OPERADOR-RELACIONAL VAL";
        
        tabla2[23][4]= "id MASMENOS";
        
        tabla2[24][22]= ">";
        tabla2[24][23]= "<";
        tabla2[24][24]= ">=";
        tabla2[24][25]= "<=";
        tabla2[24][26]= "==";
        
        tabla2[25][27]= "++";
        tabla2[25][28]= "--";
        
        tabla2[26][29]= "while WHILE' PRINCIPAL'";
        
        tabla2[27][20]= "( FORMA-WHILE )";
        
        tabla2[28][4]= "TRES-FOR FORMA-WHILE'";
        tabla2[28][11]= "TRES-FOR FORMA-WHILE'";
        tabla2[28][12]= "TRES-FOR FORMA-WHILE'";
        tabla2[28][13]= "TRES-FOR FORMA-WHILE'";
        tabla2[28][14]= "TRES-FOR FORMA-WHILE'";
        
        tabla2[29][21]= "E";
        tabla2[29][31]= "LOGICO TRES-FOR FORMA-WHILE'";
        tabla2[29][32]= "LOGICO TRES-FOR FORMA-WHILE'";
        
        tabla2[30][31]= "&&";
        tabla2[30][32]= "||";
        
        tabla2[31][30]= "if IF' ELSE";
        
        tabla2[32][20]= "( FORMA-WHILE )";
         
        tabla2[33][1]= "PRINCIPAL' ELSE'";
        
        tabla2[34][2]= "E";
        tabla2[34][7]= "E";
        tabla2[34][8]= "E";
        tabla2[34][9]= "E";
        tabla2[34][10]= "E";
        tabla2[34][19]= "E";
        tabla2[34][29]= "E";
        tabla2[34][33]= "else PRINCIPAL'";      
    }
    
    public void llenado(){
        for ( int x = 0; x < 35; x++ ){
            for ( int y = 0; y < 34; y++ ){
                tabla[x][y] = "";
            }   
        }
        
        tabla[0][0]= "class Inicio'";
        
        tabla[1][1]= "{ Codigos }";
        
        tabla[2][2]= "E";   
        tabla[2][4]= "Codigo Codigos";
        tabla[2][7]= "Codigo Codigos";
        tabla[2][8]= "Codigo Codigos";
        tabla[2][9]= "Codigo Codigos";
        tabla[2][10]= "Codigo Codigos";
        tabla[2][19]= "Codigo Codigos";
        tabla[2][29]= "Codigo Codigos";
        tabla[2][30]= "Codigo Codigos";
        
        tabla[3][4]= "CambioV ;";
        tabla[3][7]= "InicioV ;";
        tabla[3][8]= "InicioV ;";
        tabla[3][9]= "InicioV ;";
        tabla[3][10]= "InicioV ;";
        tabla[3][19]= "Ciclo";
        tabla[3][29]= "Ciclo";
        tabla[3][30]= "Decision";
        
        tabla[4][7]= "TipoD Asignacion Multiple";
        tabla[4][8]= "TipoD Asignacion Multiple";
        tabla[4][9]= "TipoD Asignacion Multiple";
        tabla[4][10]= "TipoD Asignacion Multiple";
        
        tabla[5][4]= "id Asignacion'";
        
        tabla[6][3]= "E";
        tabla[6][5]= "= V OP";
        tabla[6][6]= "E";
        
        tabla[7][3]= "E";
        tabla[7][6]= "E";
        tabla[7][15]= "Operador V OP";
        tabla[7][16]= "Operador V OP";
        tabla[7][17]= "Operador V OP";
        tabla[7][18]= "Operador V OP";
        
        tabla[8][3]= "E";
        tabla[8][6]= ", Asignacion Multiple";
        
        tabla[9][7]= "int";
        tabla[9][8]= "string";
        tabla[9][9]= "float";
        tabla[9][10]= "boolean";
        
        tabla[10][4]= "id";
        tabla[10][11]= "INT";
        tabla[10][12]= "STRING";
        tabla[10][13]= "FLOAT";
        tabla[10][14]= "BOOLEAN";
        
        tabla[11][15]= "+";
        tabla[11][16]= "-";
        tabla[11][17]= "*";
        tabla[11][18]= "/";
        
        tabla[12][4]= "Asignacion";
        
        tabla[13][19]= "FOR";
        tabla[13][29]= "WHILE";
        
        tabla[14][19]= "for Sentencia Inicio'";
        
        tabla[15][20]= "( Sentencia' )";
        
        tabla[16][7]= "InicioF CondicionF ActualizarF";
        
        tabla[17][7]= "int InicioF'";
        
        tabla[18][4]= "id Igual";
        
        tabla[19][5]= "= V";
        
        tabla[20][3]= "; CondicionF' ;";
        
        tabla[21][4]= "V Relacional'";
        tabla[21][11]= "V Relacional'";
        tabla[21][12]= "V Relacional'";
        tabla[21][13]= "V Relacional'";
        tabla[21][14]= "V Relacional'";
        
        tabla[22][22]= "Relacional V";
        tabla[22][23]= "Relacional V";
        tabla[22][24]= "Relacional V";
        tabla[22][25]= "Relacional V";
        tabla[22][26]= "Relacional V";
        
        tabla[23][4]= "id Aumento";
        
        tabla[24][22]= ">";
        tabla[24][23]= "<";
        tabla[24][24]= ">=";
        tabla[24][25]= "<=";
        tabla[24][26]= "==";
        
        tabla[25][27]= "++";
        tabla[25][28]= "--";
        
        tabla[26][29]= "while WHILE' Inicio'";
        
        tabla[27][20]= "( CondicionW )";
        
        tabla[28][4]= "CondicionF' CondicionW'";
        tabla[28][11]= "CondicionF' CondicionW'";
        tabla[28][12]= "CondicionF' CondicionW'";
        tabla[28][13]= "CondicionF' CondicionW'";
        tabla[28][14]= "CondicionF' CondicionW'";
        
        tabla[29][21]= "E";
        tabla[29][31]= "Logico CondicionF' CondicionW'";
        tabla[29][32]= "Logico CondicionF' CondicionW'";
        
        tabla[30][31]= "&&";
        tabla[30][32]= "||";
        
        tabla[31][30]= "if Decision' Else";
        
        tabla[32][20]= "( CondicionW )";
         
        tabla[33][1]= "Inicio' Else'";
        
        tabla[34][2]= "E";
        tabla[34][7]= "E";
        tabla[34][8]= "E";
        tabla[34][9]= "E";
        tabla[34][10]= "E";
        tabla[34][19]= "E";
        tabla[34][29]= "E";
        tabla[34][33]= "else Inicio'";      
    }

    public SyntacticAnlysisTable() {
        llenado();              
        llenado2();
    }
//    
    public String buscaReglas(String terminal, String noterminal)
    {
        ter = 100;
        not = 100;
        for ( int x = 0; x < 34; x++ )
        { 
        if(terminales[x].equals(terminal))
            ter=x;
        }
        for ( int x = 0; x < 35; x++ )
        { 
            if(noterminales[x].equals(noterminal))
                not=x;
        } 
        if(ter ==100 || not == 100)
            return "";
        return tabla[not][ter];
    }
}
