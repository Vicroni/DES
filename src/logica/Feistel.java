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
public class Feistel {
    
    /**
     * Aplica un cifrado feistel a una cadena y genera las claves apartir de
     * la principal
     * @param cadena es una cadena a la que aplicarle el feistel
     * @param clave es la clave del feistel
     * @return es la cadena cifrada
     */
    public String cifrado(String cadena, String clave){
        String[] claves = new Cerrajero().generarClaves(clave);
        for (String var : claves) {
            cadena = this.aplicarLlave(cadena, var);
        }
        return cadena;
    }
    
    /**
     * Aplica un descifrado feistel a una cadena y genera las claves apartir de
     * la principal
     * @param cadena es una cadena a la que aplicarle el feistel
     * @param clave es la clave del feistel
     * @return es la cadena descifrada
     */    
    public String descifrado(String cadena, String clave){
        String[] claves = new Cerrajero().generarClaves(clave);
        for (int i = claves.length - 1; i >= 0;  i--) {
             cadena = this.aplicarLlave(cadena, claves[i]);
        }
        return cadena;
    }
    
    
    /**
     * Es el algoritmo feistel aplicado a DES
     * @param cadena recibe una cadena la cadena aplicar el feiste
     * @param clave es la llave del feistel
     * @return una cadena a la que se le aplico una llave
     */
    public String aplicarLlave(String cadena, String clave) {
        String Lo = cadena.substring(0, 32);
        String Ro = cadena.substring(32, 64);

        //Se realiza la expansion a 48 bits
        String Ri = new Permutador().E(Ro);

        // Se realiza el xor con la clave
        Ri = this.XOR(Ri, clave);
        
        Ri = new Sustituidor().sustitucion(Ri);

        //Se realiza la permutacion P a Ri
        Ri = new Permutador().P(Ri);

        //Aplicar Xor Lo con Ri
        Ri = this.XOR(Lo, Ri);
        //Concatener de manera invertida
        return Ro + Ri;
    }


    /**
     * Aplica un Xor sin pasar a binario los datos, suponiendo que ambas cadenas
     * son iguales
     *
     * @param binario_1 Un bloque de bits del mismo tamaño que binario_2
     * @param binario_2 Un bloque de bits del mismo tamaño que binario_1
     * @return
     */
    private String XOR(String binario_1, String binario_2) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < binario_1.length(); i++) {
            if (binario_1.charAt(i) == binario_2.charAt(i)) {
                resultado.append('0');
            } else {
                resultado.append('1');
            }
        }
        return resultado.toString();
    } 
}
