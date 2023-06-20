package loja.jogos;
public class Produtos {
    String nomeProduto;
    String descricaoProduto;
    double precoProduto;
    int quantidadeProduto;
    
    public Produtos(String nomeProduto, String descricaoProduto, double precoProduto, int quantidadeProduto) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getprecoProduto() {
        return precoProduto;
    }

    public void setprecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public String Imprimir(){
        String saida = "";
        saida += "\n Nome do Produto: " + getNomeProduto()+"\n Descrição: "+getDescricaoProduto()+" \n Preço: R$"+getprecoProduto()+"\n Quantidade: "+getQuantidadeProduto()+"\n";
        return saida;
    }

    //ta convertendo o valor dentro dos arrays de ordenação para String
    @Override
    public String toString() {
        return "Nome: " + nomeProduto + ", Preço: " + precoProduto;
    }

}
