/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.math.BigInteger;

/**
 *
 * @author Saúl Fernando González Domínguez(Vicroni)
 * @version 21/09/2017 1.0
 */
public class Cerrajero {
    //Tabla de currimiento 1 para las claves
    private final int[] TC_1 = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1}; 
     
    /**
     * Genera 16 sub-claves en base a una principal
     * @param clave es la clave principal
     * @return 
     */
    public String[] generarClaves(String clave) {
        //Transformar la clave de 64 bits en un binario
        String claves[] = new String[16];
        String claveBinaria = new BigInteger(clave, 16).toString(2);
        if (claveBinaria.length() != 64) {
            int n = 64 - claveBinaria.length();
            for (int i = 0; i < n; i++) {
                claveBinaria = "0" + claveBinaria;
            }
        }

        //Hacer una reduccion cad 8 bits para tener un clave de 56 bits
        StringBuilder reduccion = new StringBuilder();
        for (int i = 0; i < claveBinaria.length(); i++) {
            if ((i + 1) % 8 != 0) {
                reduccion.append(claveBinaria.charAt(i));
            }
        }

        //Hacer la primera permutacion
        String clavePermutadaU = new Permutador().PC_1(claveBinaria);

        //Dividir en dos bloques
        String c = clavePermutadaU.substring(0, 28);
        String d = clavePermutadaU.substring(28, 56);


        //Se hace un  currimiento para obtener 16 claves c
        String[] c_recorrida = new String[16];
        c_recorrida[0] = this.currimiento(c, 0);
        for (int i = 1; i < 16; i++) {
            c_recorrida[i] = this.currimiento(c_recorrida[i - 1], i);
        }

        //Se hace un  currimiento para obtener 16 claves c
        String[] d_recorrida = new String[16];
        d_recorrida[0] = this.currimiento(d, 0);
        for (int i = 1; i < 16; i++) {
            d_recorrida[i] = this.currimiento(d_recorrida[i - 1], i);
        }

        //Se unen las respectivas claves  c y d, 
        //despues de meten a la caja de permutación
        for (int i = 0; i < 16; i++) {
            claves[i] = this.permutacion_subclaves(c_recorrida[i], d_recorrida[i]);
        }
        return claves;
    }
    
    /**
     * Realiza un currimiento a cualquier cadena de string binaria
     * @param subclave cadena que se quiere currir
     * @param i numero de currimientos aplicados
     * @return 
     */
    private String currimiento(String subclave, int i) {
        for (int j = 0; j < this.TC_1[i]; j++) {
            subclave = subclave.substring(1, subclave.length()) + subclave.charAt(0);
        }
        return subclave;
    }
    
    /**
     * realiza la permutacion con PC_2 de las sub-claves
     * @param c es la parte izquierda de la subclaves
     * @param d es la parte derecha de la subclaves
     * @return 
     */
    private String permutacion_subclaves(String c, String d) {
        String subclave = c + d;
        String res = new Permutador().PC_2(subclave);
        return res;
    }
}
