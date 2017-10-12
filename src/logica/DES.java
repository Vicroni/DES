/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
/**
 *
 * @author Saúl Fernando González Domínguez(Vicroni)
 * @version 21/09/2017 1.0
 */
public class DES {

    /**
     * Permite encriptar cadenas largas mayores a 64 bits
     *
     * @param cadena La cadena a encriptar
     * @param clave La clave del encriptado
     * @return La cadena ya encriptada
     */
    public String cifrar(String cadena, String clave) throws Exception {

        //Division del trabajo en 64 bits para simplificar  
        ArrayList<String> cadenas64 = null;
        try {
            cadenas64 = new Parseador().hexToBin(cadena);
        } catch (Exception ex) {
            throw new Exception("Fallo al convertir hexagesimal a binario");
        }

        //Aplicar el cifrado para 64 bits
        for (int i = 0; i < cadenas64.size(); i++) {
            cadenas64.set(i, this.cifrar_64(cadenas64.get(i), clave));
        }
//      
////       Aplicar el cifrado para 64 bits
//        HiloCifrado[] c = new HiloCifrado[cadenas64.size()];
//        for (int i = 0; i < cadenas64.size(); i++) {
//            c[i] = new HiloCifrado(i, cadenas64, clave);
//            c[i].start();
////            cadenas64.set(i, this.descifrar_64(cadenas64.get(i), clave));
//        }
//        for (HiloCifrado c1 : c) {
//            try {
//                c1.join();
//            } catch (InterruptedException ex) {
//                System.out.println("Fallo al sincronizar hilos");
//            }
//        }

        String resultado = null;
        try {
            //Unir las cadenas de resultado
            resultado = new Parseador().binToHex(cadenas64);
        } catch (Exception ex) {
            throw new Exception("Fallo al convertir hexagesimal a binario");
        }

        return resultado;
    }

    /**
     * Permite desencriptar cadenas largas mayores a 64 bits
     *
     * @param cadena La cadena a desencriptar
     * @param clave La clave del desencriptado
     * @return La cadena ya desencriptada
     */
    public String desicifrar(String cadena, String clave) throws Exception {

        //Division del trabajo en 64 bits para simplificar  
        ArrayList<String> cadenas64 = null;
        try {
            cadenas64 = new Parseador().hexToBin(cadena);
        } catch (Exception ex) {
            throw new Exception("Fallo al convertir hexagesimal a binario");
        }
        
        //Aplicar el descifrado para 64 bits
        for (int i = 0; i < cadenas64.size(); i++) {
            cadenas64.set(i, this.descifrar_64(cadenas64.get(i), clave));
        }


        String resultado = null;
        try {
            //Unir las cadenas de resultado
            resultado = new Parseador().binToHex(cadenas64);
        } catch (Exception ex) {
            throw new Exception("Fallo al convertir hexagesimal a binario");
        }

        return resultado;
    }

    /**
     * Encipta los bloques de solo 64 bits
     *
     * @param cadena Recibe una cadena en forma de binario de 64 bits
     * @param clave Recibe una clave de 48 bits
     * @return un bloque el 64 bits encriptado
     */
    public String cifrar_64(String cadena, String clave) {

        //Aplicar permutacion IP
        String cadenaPermutada = new Permutador().IP(cadena);

        // Aplicar las 16 claves
        cadenaPermutada = new Feistel().cifrado(cadenaPermutada, clave);

        //Invertir la cadena R(16)L(16)
        cadenaPermutada = cadenaPermutada.substring(32, 64) + cadenaPermutada.substring(0, 32);

        //Permutacion final
        String encriptado = new Permutador().IP_1(cadenaPermutada);

        return encriptado;
    }

    /**
     * Encipta los bloques de solo 64 bits
     *
     * @param cadena Recibe una cadena en forma de binario de 64 bits
     * @param clave Recibe una clave de 48 bits
     * @return un bloque el 64 bits descifrado
     */
    public String descifrar_64(String cadena, String clave) {

        //Aplicar permutacion IP
        String cadenaPermutada = new Permutador().IP(cadena);

        // Aplicar las 16 claves a la inversa
        cadenaPermutada = new Feistel().descifrado(cadenaPermutada, clave);

        //Invertir la cadena R(16)L(16)
        cadenaPermutada = cadenaPermutada.substring(32, 64) + cadenaPermutada.substring(0, 32);

        //Permutacion final
        String encriptado = new Permutador().IP_1(cadenaPermutada);

        return encriptado;
    }

}
