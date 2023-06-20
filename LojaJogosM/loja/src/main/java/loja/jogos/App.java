package loja.jogos;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        MetodosLoja lista = new MetodosLoja();
        Scanner scan = new Scanner(System.in);
        Scanner scanNum = new Scanner(System.in);
        boolean jsonImport = true;
        int menu = 10;

        while(menu != 0){

            System.out.println("\n##### Menu Loja Virtual #####");
            System.out.println("Escolha uma das opções:");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastre um novo produto");
            System.out.println("2 - Faça a edição de um produto");
            System.out.println("3 - Remova um produto");
            System.out.println("4 - Liste todos os produtos");
            System.out.println("5 - Ordenar por ordem alfabética");
            System.out.println("6 - Ordenar por preço");
            System.out.println("7 - Buscar por nome");
            System.out.println("8 - Inserir lista JSON");
            System.out.print("Digite: ");
            
            try {
                menu = scanNum.nextInt();
                

                switch (menu) {
                    case 0:

                    break;

                    case 1:
                        System.out.println("Cadastro de Produto");
                        System.out.print("Digite o nome do Produto: ");
                        String nomeProduto = scan.nextLine();
                        System.out.print("Digite a descrição do Produto: ");
                        String descricaoProduto = scan.nextLine();
                        System.out.print("Digite o preço do Produto: ");
                        double precoProduto = scanNum.nextInt();
                        System.out.print("Digite a quantidade do Produto: ");
                        int quantidade = scanNum.nextInt();

                        Produtos item = new Produtos(nomeProduto, descricaoProduto, precoProduto, quantidade);

                        MetodosLoja.adicionarProduto(item);
                    break;

                    case 2:
                        System.out.println("Editar um Produto");
                        System.out.print("Digite o nome do Produto a ser Editado: ");
                        String nomeE = scan.nextLine(); 

                        System.out.print("Digite o novo nome do Produto: ");
                        String nomeEditar = scan.nextLine();
                        System.out.print("Digite a nova descrição do Produto: ");
                        String descricaoEditar = scan.nextLine();
                        System.out.print("Digite o novo preço do Produto: ");
                        double precoEditar = scanNum.nextInt();
                        System.out.print("Digite a nova quantidade do Produto: ");
                        int quantidadeEditar = scanNum.nextInt();

                        Produtos contEditar = new Produtos(nomeEditar, descricaoEditar, precoEditar, quantidadeEditar);

                        lista.editarProduto(nomeE, contEditar);
                    break;

                    case 3:
                        System.out.println("Remova um Produto");
                        System.out.print("Digite o nome do Produto: ");
                        String nomeR = scan.nextLine();
                        lista.removerProduto(nomeR);
                        break;

                        case 4:
                        System.out.println(lista.listarProdutos());
                    break;

                    case 5:
                        System.out.println("1-Ordenar por ordem crescente\n2-Ordenar por ordem decrescente");
                        System.out.print("Digite: ");
                        String escolhaOrdemAlf = scan.nextLine();
                        if (escolhaOrdemAlf.equals("1")) {
                            System.out.println("Ordenando itens por ordem alfabética CRESCENTE");
                            lista.ordenarPorNome();
                            
                        } else if(escolhaOrdemAlf.equals("2")) {
                            System.out.println("Ordenando itens por ordem alfabética DECRESCENTE");
                            lista.ordenarPorNomeDecres();
                        }
                        else{
                            System.out.println("Valor inválido!");
                        }
                    break;

                    case 6:
                        System.out.println("1-Ordenar por ordem crescente\n2-Ordenar por ordem decrescente");
                        System.out.print("Digite: ");
                        String escolhaOrdem = scan.nextLine();
                        if (escolhaOrdem.equals("1")) {
                            System.out.println("Ordenando por preço CRESCENTE");
                            lista.ordenarPreco();   
                        } else if(escolhaOrdem.equals("2")) {
                            System.out.println("Ordenando por preço DECRESCENTE");
                            lista.ordenarPrecoDecres();
                        }
                        else{
                            System.out.println("Valor inválido!");
                        }
                    
                    break;

                    case 7:
                        System.out.println("Buscar nome do produto");
                        System.out.print("Digite o nome do produto: ");
                        String nomeBuscar = scan.nextLine();
                        lista.buscarNome(nomeBuscar);
                    break;

                    case 8:
                        if (jsonImport) {
                            Arquivo.ImportarJSON("loja\\lib\\produtos.json");
                            jsonImport = false;

                            System.out.println("Lista importada com sucesso!");
                        } else {
                            System.out.println("Esta lista já foi importada.");
                        }
                    break;

                    default:
                        System.out.println("Opção Inválida");
                    break;
                }

            } catch (Exception e) {

                System.out.println("Caractere inválido.");
                break;

            }
        }
        scan.close();
        scanNum.close();

        System.out.println("Encerrando Sistema.");
    }
}
