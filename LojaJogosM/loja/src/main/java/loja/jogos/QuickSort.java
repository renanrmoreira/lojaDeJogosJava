package loja.jogos;
import java.util.ArrayList;

public class QuickSort {
    public static void quickSort(ArrayList<String> lista, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(lista, inicio, fim);
            quickSort(lista, inicio, indicePivo - 1);
            quickSort(lista, indicePivo + 1, fim);
        }
    }

    private static int particionar(ArrayList<String> lista, int inicio, int fim) {
        String pivo = lista.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (lista.get(j).compareTo(pivo) <= 0) {
                i++;
                trocar(lista, i, j);
            }
        }

        trocar(lista, i + 1, fim);
        return i + 1;
    }

    private static void trocar(ArrayList<String> lista, int i, int j) {
        String temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
}
