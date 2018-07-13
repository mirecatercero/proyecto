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
public class Lexema {
    int ID;
    String token;
    int linea;

    public Lexema(int ID, String token, int linea) {
        this.ID = ID;
        this.token = token;
        this.linea = linea;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    } 
}
