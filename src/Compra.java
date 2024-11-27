import java.util.ArrayList;

public class Compra {
    private ArrayList<Produto> produtos;

    public Compra() {
        produtos = new ArrayList<>();
    }

    // Método para adicionar um produto ao carrinho
    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    // Método para remover um produto do carrinho
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    // Método para buscar um produto no carrinho por código
    public Produto getProdutoPorCodigo(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null; // Retorna null se não encontrar o produto no carrinho
    }

    // Método para exibir os produtos no carrinho
    public void mostrarCompra() {
        System.out.println("Produtos no carrinho:");
        for (Produto p : produtos) {
            System.out.println(p.getName() + " - Código: " + p.getCodigo() + " - Valor: R$ " + p.getValor());
        }
    }

    // Método para calcular o valor total da compra
    public float getValorTotal() {
        float total = 0;
        for (Produto p : produtos) {
            total += p.getValor();
        }
        return total;
    }
}
