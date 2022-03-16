package unidad1.recursividad;

/**
 * @author Pedro Ayon
 */
public class AlgoritmosRecursivos {

    public static long factorial(int n) {
        if (n == 0) return 1;
        else return n * factorial(n - 1);
    }

    public static long sumaHastaN(int n) {
        if (n == 1) return 1;
        else return n + sumaHastaN(n - 1);
    }

    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long sumaDigitos(int n) {
        if (n == 0) return n;
        else return sumaDigitos(n / 10) + (n % 10);
    }

}
