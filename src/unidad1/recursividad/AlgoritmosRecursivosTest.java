package unidad1.recursividad;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pedro Ayon
 */
class AlgoritmosRecursivosTest {

    @org.junit.jupiter.api.Test
    void factorial() {
        assertEquals(120, AlgoritmosRecursivos.factorial(5));
        assertEquals(3628800, AlgoritmosRecursivos.factorial(10));
    }

    @org.junit.jupiter.api.Test
    void sumaHastaN() {
        assertEquals(15, AlgoritmosRecursivos.sumaHastaN(5));
        assertEquals(500500, AlgoritmosRecursivos.sumaHastaN(1000));
    }

    @org.junit.jupiter.api.Test
    void fibonacci() {
        assertEquals(5, AlgoritmosRecursivos.fibonacci(5));
        assertEquals(102334155, AlgoritmosRecursivos.fibonacci(40));
    }

    @org.junit.jupiter.api.Test
    void sumaDigitos() {
        assertEquals(3, AlgoritmosRecursivos.sumaDigitos(111));
        assertEquals(18, AlgoritmosRecursivos.sumaDigitos(12348));
    }
}