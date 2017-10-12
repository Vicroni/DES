/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

/**
 *
 * @author Saúl Fernando González Domínguez(Vicroni)
 * @version 21/09/2017 1.0
 */
public abstract class EjecucionTiempo {
    /**
     * Es una clase con un metodo abtracto que permite medir el tiempo
     * de ejecucion con un presicion en nanosegundo
     */
    public void run() {
        long startTime = System.nanoTime();
        this.hilo();
        long endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución: " + (endTime-startTime)/1e6 + " ms");
    }
    
    public abstract void hilo();
}
