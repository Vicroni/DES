/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import generico.EjecucionTiempo;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.DES;

/**
 *
 * @author Saúl Fernando González Domínguez(Vicroni)
 * @version 21/09/2017 1.0
 */
public class main extends EjecucionTiempo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new main().run();
    }

    @Override
    public void hilo() {
        DES jaiba = new DES();
//        System.out.println(0x7ff8000000000000L);
//        System.out.println(-21^2);
//        System.out.println(jaiba.cifrar("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef", "133457799BBCDFF1"));
        try {
            System.out.println("Cifrado     1: " + jaiba.cifrar("0123456789abcdef0123456789abcdef", "133457799BBCDFF1"));
            System.out.println("Descifrado  1: " + jaiba.desicifrar(jaiba.cifrar("0123456789abcdef", "133457799BBCDFF1"), "133457799BBCDFF1"));
            System.out.println("Cifrado     2: " + jaiba.cifrar("ffffffffffffffffffffffffffffffff", "133457799BBCDFF1"));
            System.out.println("Descifrado  2: " + jaiba.desicifrar(jaiba.cifrar("ffffffffffffffffffffffffffffffff", "133457799BBCDFF1"), "133457799BBCDFF1"));
            System.out.println("Cifrado     1: " + jaiba.cifrar("8787878787878787", "0E329232EA6D0D73"));
            System.out.println("Descifrado  2: " + jaiba.desicifrar(jaiba.cifrar("8787878787878787", "0E329232EA6D0D73"), "0E329232EA6D0D73"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
