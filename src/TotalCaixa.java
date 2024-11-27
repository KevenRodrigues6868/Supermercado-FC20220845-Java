import java.util.ArrayList;

public class TotalCaixa {
    private ArrayList<Float> valores;

    public TotalCaixa() {
        valores = new ArrayList<>();
    }

    // Método para adicionar um valor à lista de compras
    public void adicionarCompra(float valor) {
        valores.add(valor);
    }

    // Método para calcular o total das compras
    public float calcularTotal() {
        float total = 0;
        for (Float valor : valores) {
            total += valor.floatValue();  // Garantindo o uso do valor primitivo float
        }
        return total;
    }

    // Método para limpar a lista após fechar o caixa
    public void limpar() {
        valores.clear();
    }

    // Método para exibir o total do caixa
    public void exibirTotal() {
        System.out.println("Total no caixa: R$ " + calcularTotal());
    }
}
