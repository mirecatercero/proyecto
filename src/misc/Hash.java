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
public class Hash {
    
    public long hash(String k)
    {
        char ch = k.charAt(0);
        long val = (long) ch * 128;
        
        if(k.length() > 1)
        {
            for (int i = 1; i < k.length(); i++)
            {
                val += (char) k.charAt(i);
            }
        }
        System.out.println(val);
        return val % 500;
    }
}
