/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Saúl Fernando González Domínguez(Vicroni)
 * @version 21/09/2017 1.0
 */
public class Parseador {

    /**
     * Es el metodo que transforma cadenas de 64 bits en binario a una sola en
     * hexagesimal
     *
     * @param cadenas64 es la serie de cadenas en binario
     * @return una sola cadena en hexagesimal
     */
    public String binToHex(ArrayList<String> cadenas64) throws Exception {
        //Se unen los bloques de 64 bits
        String finalEncrypted = "";
        for (int i = 0; i < cadenas64.size(); i++) {
            // Se parsea el binario a hexagesimal
            try {
                String subcadena_hexagesimal = new BigInteger(cadenas64.get(i), 2).toString(16);
                int d = subcadena_hexagesimal.length();
                for (int j = 0; j < (16 - d); j++) {
                    subcadena_hexagesimal = "0" + subcadena_hexagesimal;
                }
                finalEncrypted += subcadena_hexagesimal;
            } catch (Exception ex) {
                throw new Exception("Fallo al convertir hexagesimal a binario");
            }
        }

        return finalEncrypted;
    }

    /**
     * Es el metodo que trasnforma la cadena hexagesimal a una serie de cadenas
     * en binario de 64 bits
     *
     * @param cadena es la cadena en binario
     * @return es la serie de cadenas en binario
     */
    public ArrayList<String> hexToBin(String cadena) throws Exception {
        //Dividir la cadena en bloques de 16 cifras hexagesimales
        ArrayList<String> cadenas64 = new ArrayList<>();
        do {
            String subcadena = "";
            int d = cadena.length();
            for (int i = 0; i < (16 - d); i++) {
                cadena = "0" + cadena;
            }
            for (int i = 0; i < 16; i++) {
                subcadena += cadena.charAt(i);
            }
            cadena = cadena.substring(16, cadena.length());
            //Transformacion de cadena a binario
            String subcadena_binaria = new BigInteger(subcadena, 16).toString(2);
            //Autocompletar los 64 bits
            d = subcadena_binaria.length();
            for (int i = 0; i < (64 - d); i++) {
                subcadena_binaria = "0" + subcadena_binaria;
            }
            try {
                cadenas64.add(subcadena_binaria);
            } catch (Exception ex) {
                throw new Exception("Fallo al convertir hexagesimal a  binario");
            }
        } while (cadena.length() > 0);

        return cadenas64;
    }
}
