import java.util.ArrayList;

public class ProdutosList {
    private ArrayList<Produto> produtos;

    public ProdutosList() {
        produtos = new ArrayList<>();
    }

    // Método para adicionar um produto à lista
    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    // Método para exibir os produtos cadastrados
    public void printProduto() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Produtos no estoque:");
            for (Produto p : produtos) {
                System.out.println(p.getName() + " - Código: " + p.getCodigo() + " - Valor: R$ " + p.getValor());
                p.exibirDetalhes();  // Exibe validade ou garantia do produto
                System.out.println();  // Espaço entre os produtos
            }
        }
    }

    // Método para buscar um produto por código
    public Produto getProdutoPorCodigo(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }

    // Método para buscar um produto por nome
    public Produto getProdutoPorNome(String nome) {
        for (Produto p : produtos) {
            if (p.getName().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }
}
