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
    String terminal;
    int fila, columna, i;
    
    public String[] terminales = {"class", "=", "const", "int", "float", "String", "boolean", "if", "while", "for", ",", ";", "<", ">", "<=", ">=", "!=", "==", "&&", "||", "val", "id", "{", "}", "(", ")", "+", "-", "*", "/", "else", "++", "--"};
    
    public String[] noTerminales = {
        "PRINCIPAL", 
        "PRINCIPAL'", 
        "CONTENIDO", 
        "DECLARACIONES", 
        "CONSTANTE", 
        "TIPO", 
        "VARIABLE", 
        "VARIABLE'", 
        "OP-VAL", 
        "SIG-VAR", 
        "TERMINAL", 
        "OPERACION", 
        "PROCESO", 
        "PROCESO'", 
        "OPERADOR-ARITMETICO", 
        "IF", 
        "FORMA-IF", 
        "ELSE", 
        "IF-ELSE", 
        "PAR-CONDICION", 
        "LL-CONTENIDO", 
        "CONDICION", 
        "OPERACION-CONDICION", 
        "COMP-RELACION", 
        "LOGICO", 
        "OPERADOR-LOGICO", 
        "OPERADOR-RELACIONAL", 
        "WHILE", 
        "FORMA-WHILE", 
        "FOR", 
        "FORMA-FOR", 
        "TRES-FOR", 
        "DEC", 
        "DEC'", 
        "OP", 
        "AU", 
        "MASMENOS"};
    
    public String[][] tas = 
    {
     /*PRINCIPAL*/          {"PRINCIPAL -> class PRINCIPAL'", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
     /*PRINCIPAL'*/         {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "PRINCIPAL' -> { CONTENIDO }", "", "", "", "", "" , "", "", "", "", ""},
     /*CONTENIDO*/          {"", "", "CONTENIDO -> DECLARACIONES", "CONTENIDO -> DECLARACIONES", "CONTENIDO -> DECLARACIONES", "CONTENIDO -> DECLARACIONES", "CONTENIDO -> DECLARACIONES", "CONTENIDO -> IF", "CONTENIDO -> WHILE", "CONTENIDO -> FOR", "", "", "", "", "", "", "", "", "","","", "CONTENIDO -> OPERACION", "", "CONTENIDO -> E", "", "", "", "", "", "", "", "", ""},
     /*DECLARACIONES*/      {"", "", "DECLARACIONES -> CONSTANTE TIPO VARIABLE", "DECLARACIONES -> TIPO VARIABLE", "DECLARACIONES -> TIPO VARIABLE", "DECLARACIONES -> TIPO VARIABLE", "DECLARACIONES -> TIPO VARIABLE", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
     /*CONSTANTE*/          {"", "", "CONSTANTE -> const", "CONSTANTE -> E", "CONSTANTE -> E", "CONSTANTE -> E", "CONSTANTE -> E", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
     /*TIPO*/               {"", "", "", "TIPO -> int", "TIPO -> float", "TIPO -> String", "TIPO -> boolean", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
     /*VARIABLE*/           {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "VARIABLE -> id VARIABLE' SIG-VAR", "", "", "", "", "", "", "", "", "", "", ""},
     /*VARIABLE'*/          {"", "VARIABLE' -> = OP-VAL", "", "", "", "", "", "", "", "", "VARIABLE' -> E", "VARIABLE'-> E", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
     /*OP-VAL*/             {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "OP-VAL -> val ", "OP-VAL -> PROCESO", "", "", "", "", "", "", "", "", "", "", ""},
     /*SIG-VAR*/            {"", "", "", "", "", "", "", "", "", "", "SIG-VAR -> , VARIABLE", "SIG-VAR -> ; CONTENIDO", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "SIG-VAR -> OPERADOR-ARITMETICO PROCESO ", "SIG-VAR -> OPERADOR-ARITMETICO PROCESO ", "SIG-VAR -> OPERADOR-ARITMETICO PROCESO ", "SIG-VAR -> OPERADOR-ARITMETICO PROCESO ", "", "", ""},
     /*TERMINAL*/           {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "TERMINAL -> val", "TERMINAL -> id", "", "", "", "", "", "", "", "", "", "", ""},
     /*OPERACION*/          {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "OPERACION -> id = PROCESO", "", "", "", "", "", "", "", "", "", "", ""},
     /*PROCESO*/            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "PROCESO -> TERMINAL PROCESO'", "PROCESO -> TERMINAL PROCESO'", "", "", "", "", "", "", "", "", "", "", ""},
     /*PROCESO'*/           {"", "", "", "", "", "", "", "", "", "", "", "PROCESO' -> ; CONTENIDO", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "PROCESO' -> OPERADOR-ARITMETICO PROCESO", "PROCESO' -> OPERADOR-ARITMETICO PROCESO", "PROCESO' -> OPERADOR-ARITMETICO PROCESO", "PROCESO' -> OPERADOR-ARITMETICO PROCESO", "", "", ""},
     /*OPERADOR-ARITMETICO*/{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "OPERADOR-ARITMETICO -> +", "OPERADOR-ARITMETICO -> -", "OPERADOR-ARITMETICO -> *", "OPERADOR-ARITMETICO -> /", "", "", ""},
     /*IF*/                 {"", "", "", "", "", "", "", "IF -> if FORMA-IF CONTENIDO", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
     /*FORMA-IF*/           {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "FORMA-IF -> CONDICION LL-CONTENIDO ELSE", "", "", "", "", "", "", "", ""},
     /*ELSE*/               {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ELSE -> IF-ELSE", "", "", "", "", "", "", "ELSE -> IF-ELSE", "", ""},
     /*IF-ELSE*/            {"", "", "", "", "", "", "","IF-ELSE -> IF", "", "", "", "", "", "", "", "", "", "", "","","","", "IF-ELSE -> LL-CONTENIDO", "", "", "", "", "", "", "", "IF-ELSE -> LL-CONTENIDO", "", ""},
     /*PAR-CONDICION*/      {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "PAR-CONDICION -> CONDICION"},
     /*LL-CONTENIDO*/       {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "LL-CONTENIDO -> { CONTENIDO }", "", "", "", "", "", "", "", "","",""},
     /*CONDICION*/          {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","","","","", "CONDICION -> ( OPERACION-CONDICION )", "", "", "", "", "", "", "",""},
     /*OPERACION-CONDICION*/{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","","","", "OPERACION-CONDICION -> COMP-RELACION LOGICO", "OPERACION-CONDICION -> COMP-RELACION LOGICO", "", "", "", "", "", "", "", "", "","",""},
     /*COMP-RELACION*/      {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","","","", "COMP-RELACION -> TERMINAL OPERADOR-RELACIONAL TERMINAL", "COMP-RELACION -> TERMINAL OPERADOR-RELACIONAL TERMINAL", "", "", "", "", "", "", "", "", "","",""},
     /*LOGICO*/             {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","","", "LOGICO -> OPERADOR-LOGICO OPERACION-CONDICION", "LOGICO -> OPERADOR-LOGICO OPERACION-CONDICION", "", "", "", "","", "LOGICO -> E", "", "", "", "", "", "",""},
     /*OPERADOR-LOGICO*/    {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","","", "OPERADOR-LOGICO -> &&", "OPERADOR-LOGICO -> ||", "", "", "", "", "", "", "", "", "", "", "","",""},
     /*OPERADOR-RELACIONAL*/{"", "", "", "", "", "", "", "", "", "", "", "", "OPERADOR-RELACIONAL -> <", "OPERADOR-RELACONAL -> >", "OPERADOR-RELACIONAL -> <=", "OPERADOR-RELACIONAL -> >=", "OPERADOR-RELACIONAL -> !=", "OPERADOR-RELACIONAL -> ==", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",},
     /*WHILE*/              {"", "", "", "", "", "", "", "", "WHILE -> while FORMA WHILE CONTENIDO", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
     /*FORMA-WHILE*/        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "FORMA-WHILE -> CONDICION LL-CONTENIDO",  "", "", "", "", "", "", "", ""},
     /*FOR*/                {"", "", "", "", "", "", "", "", "", "FOR -> for FORMA-FOR CONTENIDO",  "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
     /*FORMA-FOR*/          {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "FORMA-FOR -> FORMA-FOR' LL-CONTENIDO", "", "", "", "", "", "", "", ""},
     /*FORMA-FOR'*/         {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "FORMA-FOR' -> ( TRES-FOR )", "", "", "", "", "", "", "", ""},
     /*TRES-FOR*/           {"", "", "", "TRES-FOR -> DEC OP AU", "TRES-FOR -> DEC OP AU", "TRES-FOR -> DEC OP AU", "TRES-FOR -> DEC OP AU", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
     /*DEC*/                {"", "", "", "DEC- > TIPO DEC' ;", "DEC -> TIPO DEC' ;", "DEC -> TIPO DEC' ;", "DEC -> TIPO DEC' ;",  "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
     /*DEC'*/               {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "DEC' -> id = val", "", "", "", "", "", "", "", "", "", "", ""},
     /*OP*/                 {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "OP -> COMP-RELACION ;", "OP -> COMP-RELACION ;", "", "", "", "", "", "", "", "", "", "", ""},
     /*AU*/                 {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "AU -> id MASMENOS", "", "", "", "", "", "", "", "", "", "", ""},
     /*MASMENOS*/           {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "MASMENOS -> ++", "MASMENOS -> --"}
    };
    
    public String buscaReglas(Lexema lexema, String noTerminal)
    {
        if(lexema.getID() == 37 || lexema.getID() == 38 || lexema.getID() == 39)
            terminal = "val";
        else if(lexema.getID() == 0)
            terminal = "id";
        else terminal = lexema.getToken();
        
        for(i = 0; i < terminales.length; i ++)
        {
            if(terminal.equals(terminales[i]))
                columna = i;
        }
        
        for(i = 0; i < noTerminales.length; i++)
        {
            if(noTerminal.equals(noTerminales[i]))
                fila = i;
        }
        
        if(tas[fila][columna].equals(""))
            return "ERROR";
        else return tas[fila][columna];
    }
}
