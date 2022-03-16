package unidad1.primo_perdido;

import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Math.*;
import static unidad1.primo_perdido.Primo.buscarPrimoPerdido;

/**
 * @author pedro
 */
public class Main {
    static int numeroLimite;
    static int numeroDePrimos;
    static int primoPerdido;
    static int[] primos = new int[10000001];
    static int llamadas = 0;

    public static void main(String[] args) {
        leerEntrada();
        evaluar(buscarPrimoPerdido(numeroLimite));
    }

    public static void leerEntrada() {
        Scanner scanner = new Scanner(System.in);
        numeroLimite = scanner.nextInt();
        numeroDePrimos = scanner.nextInt();
        primoPerdido = scanner.nextInt();
        IntStream.range(0, numeroDePrimos - 1).forEachOrdered(i -> primos[i] = scanner.nextInt());
    }

    public static void evaluar(int respuesta) {
        System.out.println("Respuesta: " + respuesta);
        if (llamadas == 0) {
            System.out.println("Respuesta incorrecta, no se vale adivinar ");
            return;
        }
        if (respuesta != primoPerdido) {
            System.out.println("Respuesta incorrecta, se esperaba " + primoPerdido);
            return;
        }
        int puntaje = 0;
        if (llamadas <= ceil(log(numeroDePrimos) / log(2))) {
            puntaje = 100;
        } else if (llamadas <= sqrt(numeroDePrimos)) {
            puntaje = 60;
        } else if (llamadas < numeroDePrimos) {
            puntaje = 30;
        } else if (llamadas == numeroDePrimos) {
            puntaje = 5;
        }
        System.out.println("Respuesta correcta!");
        System.out.println("Puntaje para este caso: " + puntaje + "%");
    }

    static int primo(int posicion) {
        llamadas++;
        int respuesta = 0;
        if (posicion >= 0 && posicion < numeroDePrimos - 1) {
            respuesta = primos[posicion];
        }
        System.out.println("primo(" + posicion + ") -> " + respuesta);
        return respuesta;
    }
}
