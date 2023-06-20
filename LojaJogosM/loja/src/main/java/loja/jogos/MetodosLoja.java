package loja.jogos;
import java.util.ArrayList;

public class MetodosLoja {
    static ArrayList<Produtos> listaProdutos = new ArrayList<>();

    public static void adicionarProduto(Produtos item){
        listaProdutos.add(item);
    }

    public String listarProdutos(){
        String saida = "";
        System.out.println("Produtos cadastrados..:");
        for(Produtos item: listaProdutos){
            saida += item.Imprimir();
        }
        if (saida.equals("")) {
            saida = "Lista vazia.";
        }

        return saida;
    }

    public void removerProduto(String nome){
        for(int i =0; i <listaProdutos.size(); i++){
            if(listaProdutos.get(i).getNomeProduto().equals(nome)){
                listaProdutos.remove(i);
            }
        }
    }

    public void editarProduto(String nome, Produtos item){
        for(int i =0; i <listaProdutos.size(); i++){
            if(listaProdutos.get(i).getNomeProduto().equals(nome)){
                listaProdutos.set(i, item);
            }
        }
    }

    public void ordenarPreco() {
        ArrayList<Double> precos = new ArrayList<>();
        for (Produtos produto : listaProdutos) {
            precos.add(produto.getprecoProduto());
        }
    
        HeapSort.heapSort(precos);
    
        ArrayList<Produtos> produtosOrdenados = new ArrayList<>();
        for (Double preco : precos) {
            for (Produtos produto : listaProdutos) {
                //usado para obter valor absoluto e comparar valores e ignorar casas decimais muito pequenas na comparação
                if (Math.abs(produto.getprecoProduto() - preco) < 0.000001) {
                    produtosOrdenados.add(produto);
                    break;
                }
            }
        }
        for (Produtos produto : produtosOrdenados) {
            System.out.println(produto);
        }
    }
    

    public void ordenarPrecoDecres() {
        ArrayList<Double> precos = new ArrayList<>();
        for (Produtos produto : listaProdutos) {
            precos.add(produto.getprecoProduto());
        }
    
        HeapSortDecres.heapSort(precos);
    
        ArrayList<Produtos> produtosOrdenados = new ArrayList<>();
        for (Double preco : precos) {
            for (Produtos produto : listaProdutos) {
                if (Math.abs(produto.getprecoProduto() - preco) < 0.000001) {
                    produtosOrdenados.add(produto);
                    break;
                }
            }
        }
        for (Produtos produto : produtosOrdenados) {
            System.out.println(produto);
        }
    }

    public void ordenarPorNome() {
        ArrayList<String> nomes = new ArrayList<>();
        for (Produtos produto : listaProdutos) {
            nomes.add(produto.getNomeProduto());
        }

        QuickSort.quickSort(nomes, 0, nomes.size() - 1);

        ArrayList<Produtos> produtosOrdenados = new ArrayList<>();
        for (String nome : nomes) {
            for (Produtos produto : listaProdutos) {
                if (produto.getNomeProduto().equals(nome)) {
                    produtosOrdenados.add(produto);
                    break;
                }
            }
        }
        for (int i = 0; i < produtosOrdenados.size(); i++) {
            System.out.println(produtosOrdenados.get(i));
        }
    }

    public void ordenarPorNomeDecres() {
        ArrayList<String> nomes = new ArrayList<>();
        for (Produtos produto : listaProdutos) {
            nomes.add(produto.getNomeProduto());
        }

        QuickSortDecres.quickSort(nomes, 0, nomes.size() - 1);

        ArrayList<Produtos> produtosOrdenados = new ArrayList<>();
        for (String nome : nomes) {
            for (Produtos produto : listaProdutos) {
                if (produto.getNomeProduto().equals(nome)) {
                    produtosOrdenados.add(produto);
                    break;
                }
            }
        }
        for (int i = 0; i < produtosOrdenados.size(); i++) {
            System.out.println(produtosOrdenados.get(i));
        }
    }


    public void buscarNome(String nomeBuscado){

        ArrayList<String> nomes = new ArrayList<>();
        for (Produtos produto : listaProdutos) {
            nomes.add(produto.getNomeProduto());
        }

        QuickSort.quickSort(nomes, 0, nomes.size() - 1);
        
        BinariaNome binObjName = new BinariaNome();
        String[] listas = nomes.toArray(new String[nomes.size()]);
        int posicao = binObjName.buscaBinariaString(nomeBuscado,listas);
        if (posicao == -1) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Produto encontrado na posição " + posicao + " E o nome do Produto é " + listas[posicao]);
        }

    }
}
