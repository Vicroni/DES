/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Saúl Fernando González Domínguez(Vicroni)
 * @version 21/09/2017 1.0
 */
public class Permutador {

    //Tabla de permutacion 1 para las claves 
    private final int[] PC_1 = {
        57, 49, 41, 33, 25, 17, 9, 1,
        58, 50, 42, 34, 26, 18, 10, 2,
        59, 51, 43, 35, 27, 19, 11, 3,
        60, 52, 44, 36, 63, 55, 47, 39,
        31, 23, 15, 7, 62, 54, 46, 38,
        30, 22, 14, 6, 61, 53, 45, 37,
        29, 21, 13, 5, 28, 20, 12, 4
    };

    //Tabla de permutacion 2 para las claves
    private final int[] PC_2 = {
        14, 17, 11, 24, 1, 5, 3, 28,
        15, 6, 21, 10, 23, 19, 12, 4,
        26, 8, 16, 7, 27, 20, 13, 2,
        41, 52, 31, 37, 47, 55, 30, 40,
        51, 45, 33, 48, 44, 49, 39, 56,
        34, 53, 46, 42, 50, 36, 29, 32
    };


    //Tabla de permutacion IP para la cadena 
    private final int[] IP = {
        58, 50, 42, 34, 26, 18, 10, 2,
        60, 52, 44, 36, 28, 20, 12, 4,
        62, 54, 46, 38, 30, 22, 14, 6,
        64, 56, 48, 40, 32, 24, 16, 8,
        57, 49, 41, 33, 25, 17, 9, 1,
        59, 51, 43, 35, 27, 19, 11, 3,
        61, 53, 45, 37, 29, 21, 13, 5,
        63, 55, 47, 39, 31, 23, 15, 7
    };

    //Tabla de expansion para la cadena
    private final int[] E = {
        32, 1, 2, 3, 4, 5, 4, 5,
        6, 7, 8, 9, 8, 9, 10, 11,
        12, 13, 12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21, 20, 21,
        22, 23, 24, 25, 24, 25, 26, 27,
        28, 29, 28, 29, 30, 31, 32, 1
    };


    // Tabla permutacion P para la cadena
    private final int[] P = {
        16, 7, 20, 21,
        29, 12, 28, 17,
        1, 15, 23, 26,
        5, 18, 31, 10,
        2, 8, 24, 14,
        32, 27, 3, 9,
        19, 13, 30, 6,
        22, 11, 4, 25
    };

    // Permutacion final de la cadena
    private final int[] IP_1 = {
        40, 8, 48, 16, 56, 24, 64, 32,
        39, 7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37, 5, 45, 13, 53, 21, 61, 29,
        36, 4, 44, 12, 52, 20, 60, 28,
        35, 3, 43, 11, 51, 19, 59, 27,
        34, 2, 42, 10, 50, 18, 58, 26,
        33, 1, 41, 9, 49, 17, 57, 25
    };
    /**
     * Funcion generica para permutar
     * @param CajaPermutacion es una caja de permutacion
     * @param cadena es la cadena que quiere ser permutada
     * @return la cadena permutada
     */
    private String permutar(int[] CajaPermutacion, String cadena ){
        //Se realiza una permutacion
        String cadenaPermutada = "";
        for (int i = 0; i < CajaPermutacion.length; i++) {
            cadenaPermutada += cadena.charAt(CajaPermutacion[i] - 1);
        }
        return cadenaPermutada;
    }
    
    /**
     * Permutacion especifica para PC_1
     * @param cadena es la cadena que quiere ser permutada
     * @return la cadena permutada
     */
    public String PC_1(String cadena) {
        return this.permutar(this.PC_1, cadena);
    }

    /**
     * Permutacion especifica para PC_2
     * @param cadena es la cadena que quiere ser permutada
     * @return la cadena permutada
     */
    public String PC_2(String cadena) {
        return this.permutar(this.PC_2, cadena);
    }

    /**
     * Permutacion especifica para IP
     * @param cadena es la cadena que quiere ser permutada
     * @return la cadena permutada
     */
    public String IP(String cadena) {
        return this.permutar(this.IP, cadena);
    }

    
    /**
     * Permutacion especifica para E
     * @param cadena es la cadena que quiere ser permutada
     * @return la cadena permutada
     */
    public String E(String cadena) {
        return this.permutar(this.E, cadena);
    }

    /**
     * Permutacion especifica para P
     * @param cadena es la cadena que quiere ser permutada
     * @return la cadena permutada
     */    
    public String P(String cadena) {
        return this.permutar(this.P, cadena);
    }

    /**
     * Permutacion especifica para IP_1
     * @param cadena es la cadena que quiere ser permutada
     * @return la cadena permutada
     */
    public String IP_1(String cadena) {
        return this.permutar(this.IP_1, cadena);
    }
  
}
