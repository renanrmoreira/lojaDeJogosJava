package loja.jogos;
import java.util.List;

public class HeapSortDecres {
    public static void heapSort(List<Double> list) {
        int n = list.size();

        // Constrói o heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        // Extrai elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move o elemento raiz (maior valor) para o final
            double temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            // Chama heapify na subárvore reduzida
            heapify(list, i, 0);
        }
    }

    private static void heapify(List<Double> list, int n, int i) {
        int largest = i;  // Inicializa o maior como raiz
        int left = 2 * i + 1;  // Filho esquerdo do nó atual
        int right = 2 * i + 2;  // Filho direito do nó atual

        // Se o filho esquerdo é maior que a raiz
        //mudamos o sinal para ordenar de forma decrescente
        if (left < n && list.get(left) < list.get(largest)) {
            largest = left;
        }

        // Se o filho direito é maior que a raiz
        //mudamos o sinal para ordenar de forma decrescente
        if (right < n && list.get(right) < list.get(largest)) {
            largest = right;
        }

        // Se o maior não é a raiz
        if (largest != i) {
            // Troca a raiz com o maior
            double temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);

            // Recursivamente chama heapify na subárvore afetada
            heapify(list, n, largest);
        }
    }
}
