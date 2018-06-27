/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chny.lexico;

/**
 *
 * @author Jose
 */
public class Hash {
    double A = 100.0 * 5.0 / 7.0;
    
    /*public double hash(String k, int m)
    {
        char ch = k.charAt(0);
        int val = (int) ch * 128;
        
        if(k.length() > 1)
        {
            for(int i = 0; i < k.length(); i++)
            {
                val += (char) k.charAt(i);
            }
        }
        
        //return Math.floor(m * ((val * A) % 1));
        return m * ((val * A) % 1);
    }*/
    
    public int hash(String k, int m)
    {
        char ch = k.charAt(0);
        int val = (int) ch * 128;
        
        if(k.length() > 1)
        {
            for (int i = 1; i < k.length(); i++)
            {
                val += (char) k.charAt(i);
            }
        }
        
        return val % m;
    }
}
