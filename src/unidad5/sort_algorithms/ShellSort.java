package unidad5.sort_algorithms;

import java.util.ArrayList;
import java.util.Arrays;

import static unidad5.sort_algorithms.SortUtils.*;

public class ShellSort<T extends Comparable<T>> {
    public ArrayList<T> sort(ArrayList<T> array) {
        int size = array.size();
        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                T temp = array.get(i);
                int j;
                for (j = i; j >= gap && greater(array.get(j - gap), temp); j -= gap)
                    array.set(j, array.get(j - gap));
                array.set(j, temp);
            }
        }
        return array;
    }

    public static void shellSort(int[] a, int n) {
        int i, gap = n;
        int aux;
        boolean swapped;
        while (gap > 1) {
            gap /= 2;
            swapped = true;
            while (swapped) {
                swapped = false;
                i = 0;
                while ((i + gap) < n) {
                    if (a[i] > a[i + gap]) {
                        aux = a[i];
                        a[i] = a[i + gap];
                        a[i + gap] = aux;
                        swapped = true;
                    }
                    ++i;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{14, 6, 13, 8, 34, 67, 2, 5, 77};
        shellSort(a, 9);
        System.out.println(Arrays.toString(a));
    }
}
