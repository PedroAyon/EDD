package unidad1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pedro
 */
public class ManejoDeMemoria {
    public static void main(String[] args) {
        // Memoria estática
        int numero; // 32 bits
        numero = 18; // 32 bits
        numero = 999999; // 32 bits

        int[] arreglo = new int[20]; // Espacio reservado = 32 bits * 20 = 640 bits
        for (int i = 0; i < 20; i++) {
            arreglo[i] = i;
        }
        // arreglo sigue ocupando 640 bits de espacio en memoria

        // Memoria dinamica

        LinkedList<Integer> lista = new LinkedList<>(); // Espacio actual: 0 bits
        lista.push(10); // Espacio actual: 32 bits
        for (int i = 1; i < 10; i++) {
            lista.push(i);
        }
        // Espacio actual: 320 bits
        lista.pop(); // Espacio actual: 288
    }
}
