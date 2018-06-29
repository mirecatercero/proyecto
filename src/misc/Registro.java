/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

/**
 *
 * @author Jose
 */
public class Registro {
    long clave;
    String token;
    String tipo;
    String categoria;
    String longitud;
    String valor;    

    public Registro(long clave, String token, String tipo, String longitud, String valor, String categoria) {
        this.clave = clave;
        this.token = token;
        this.tipo = tipo;
        this.longitud = longitud;
        this.valor = valor;
        this.categoria = categoria;
    }
    
    public long getClave()
    {
        return clave;
    }
    
    public void setClave(long clave)
    {
        this.clave = clave;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
