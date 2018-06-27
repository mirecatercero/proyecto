
package chny.lexico;


public class Automatas {
    
    public boolean esEntero(String c)
    {
        boolean aceptado = true;
        int contador = 0;
        while(contador < c.length())
        {
            char ch = c.charAt(contador);
            if(!Character.isDigit(ch))
                aceptado = false;
            contador++;
        }
        return aceptado;
    }
    
    public boolean esFlotante(String c)
    {
        boolean aceptado = true;
        int contador = 0;
        while(contador < c.length())
        {
            char ch = c.charAt(contador);
        }
        return aceptado;
    }
}