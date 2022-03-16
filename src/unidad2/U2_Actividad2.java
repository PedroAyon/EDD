package unidad2;

import java.util.Arrays;

/**
 * @author Pedro Ayon
 */
public class U2_Actividad2 {
    static int fibonacciN1 = 0, fibonacciN2 = 1, fibonacciN3 = 0;

    public static void main(String[] args) {
        System.out.println("Revertir string 'abcdefg' -> " + revertirString("abcdefg"));
        System.out.print("Serie fibonacci -> " + fibonacciN1 + " " + fibonacciN2);
        serieFibonacci(10);
        System.out.println();
        System.out.println("Revertir número 12345 -> " + revertirNumero(12345));
        System.out.println("Potencia de 5 elevado a la 4ta potencia -> " + potenciar(5, 4));
        System.out.println("Suma de cuadrados de 1 hasta 5 -> " + sumaNCuadrados(5));
        int[] arreglo = {1, 2, 3, 4, 5};
        System.out.println("Suma de los elementos del arreglo [1, 2, 3, 4, 5] -> " + sumaElementosArreglo(arreglo, arreglo.length));
    }

    public static String revertirString(String string) {
        if (string.isEmpty()) return string;
        return revertirString(string.substring(1)) + string.charAt(0);
    }

    static void serieFibonacci(int contador) {
        if (contador > 0) {
            fibonacciN3 = fibonacciN1 + fibonacciN2;
            fibonacciN1 = fibonacciN2;
            fibonacciN2 = fibonacciN3;
            System.out.print(" " + fibonacciN3);
            serieFibonacci(contador - 1);
        }
    }

    public static int revertirNumero(int numero) {
        if (numero < 10) return numero;
        int log10Num = (int) (Math.log10(numero));
        return numero % 10 * (int) Math.pow(10, log10Num) + revertirNumero(numero / 10);
    }

    public static int potenciar(int base, int potencia) {
        if (potencia == 0) return 1;
        int potenciaMitad;
        potenciaMitad = potenciar(base, potencia / 2);
        if (potencia % 2 == 0) return potenciaMitad * potenciaMitad;
        else return base * potenciaMitad * potenciaMitad;
    }

    public static int sumaNCuadrados(int numero) {
        if (numero == 1) return numero;
        return numero * numero + sumaNCuadrados(numero - 1);
    }

    public static int sumaElementosArreglo(int[] arreglo, int longitud) {
        if (longitud == 1) return arreglo[0];
        return arreglo[longitud - 1] + sumaElementosArreglo(arreglo, longitud - 1);
    }
}
