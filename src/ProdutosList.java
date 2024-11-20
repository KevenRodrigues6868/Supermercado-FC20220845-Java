import java.util.ArrayList;

public class ProdutosList {
    private ArrayList<Produto> produtos = new ArrayList<>();
    
    // Adicionar um produto ao estoque
    public void addProduto(Produto produto) {
        produtos.add(produto);
    }
    
    // Buscar produto pelo código
    public Produto getProdutoPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.codigo == codigo) {
                return produto;
            }
        }
        return null; // Retorna null se não encontrar
    }
    
    // Exibir todos os produtos no estoque
    public void printProduto() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
