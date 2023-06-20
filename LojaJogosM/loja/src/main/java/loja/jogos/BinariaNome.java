package loja.jogos;
public class BinariaNome {

    public int buscaBinariaString(String nome, String[] nomes) {
        int inicio = 0;
        int fim = nomes.length - 1;

        while (inicio <= fim) {
            int meio = (fim + inicio) / 2;
            int comparacao = nome.compareTo(nomes[meio]);

            if (comparacao == 0) {
                return meio;
            }

            if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return -1;
    }

}
