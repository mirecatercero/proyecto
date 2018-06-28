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
    int clave;
    String token;
    String tipo;
    String categoria;
    String valor;    

    public Registro(int clave, String token, String tipo, String categoria, String valor) {
        this.clave = clave;
        this.token = token;
        this.tipo = tipo;
        this.categoria = categoria;
        this.valor = valor;
    }
    
    public int getClave()
    {
        return clave;
    }
    
    public void setClave(int clave)
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
