package unidad1.primo_perdido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.log;
import static java.lang.StrictMath.ceil;
import static unidad1.primo_perdido.Main.primo;

/**
 * @author pedro
 */
public class Primo {
    static List<Boolean> busquedaDePrimos;
    static int[] numerosPrimos;
    static int contadorPrimos = 0;

    public static int buscarPrimoPerdido(int numeroLimite) {
        generarListaDePrimos(numeroLimite);
        return buscar(numerosPrimos, 0, contadorPrimos - 1);
    }

    public static void generarListaDePrimos(int numeroLimite) {
        cribaDeEratostenes(numeroLimite);
        numerosPrimos = new int[(int) ceil(numeroLimite / (log(numeroLimite) - (2 / log(numeroLimite)) - 1))];
        for (int p = 2; p <= numeroLimite; p++){
            if (busquedaDePrimos.get(p)) {
                numerosPrimos[contadorPrimos] = p;
                contadorPrimos++;
            }
        }
    }

    public static void cribaDeEratostenes(int numeroLimite) {
        busquedaDePrimos = new ArrayList<>(Collections.nCopies(numeroLimite + 1, true));
        busquedaDePrimos.set(0, false);
        busquedaDePrimos.set(1, false);
        for (int p = 2; p * p <= numeroLimite; p++) {
            if (busquedaDePrimos.get(p)) {
                for (int i = p * p; i <= numeroLimite; i += p)
                    busquedaDePrimos.set(i, false);
            }
        }
    }

    private static int buscar(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        if (right < left) return arr[mid];
        int num = primo(mid);

        if (arr[mid] < num && arr[mid - 1] == num) return arr[mid];
        if (arr[mid] == num) return buscar(arr, mid + 1, right);
        if (num == -1) return arr[right];
        return buscar(arr, left, mid - 1);
    }
}
