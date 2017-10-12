/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.ArrayList;
import logica.DES;

/**
 *
 * @author SAUL
 */
public class HiloCifrado extends Thread {
    
    private ArrayList<String> cadenas64;
    private String clave;
    private int i;     

    public HiloCifrado(int i, ArrayList<String> cadenas64, String clave) {
        super(Integer.toString(i));
        this.i = i;
        this.cadenas64 = cadenas64;
        this.clave = clave;
    }

    @Override
    public void run() {
        this.cadenas64.set(i, new DES().cifrar_64(this.cadenas64.get(i), this.clave));
    } 

}


