import java.util.ArrayList;

public class Compra {
    private ArrayList<Produto> itens;
    private float valorTotal;

    public Compra() {
        itens = new ArrayList<>();
        valorTotal = 0;
    }

    public void addProduto(Produto produto) {
        itens.add(produto);
        valorTotal += produto.calcValor();
    }

    public void mostrarCompra() {
        System.out.println("Itens da Compra:");
        for (Produto p : itens) {
            System.out.println(p);
        }
        System.out.println("Valor total da compra: R$ " + valorTotal);
    }

    public float getValorTotal() {
        return valorTotal;
    }
}
