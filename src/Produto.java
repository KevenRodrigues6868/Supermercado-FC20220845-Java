public abstract class Produto {
    private String name;
    private int codigo;
    private float valor;

    public Produto(String name, int codigo, float valor) {
        this.name = name;
        this.codigo = codigo;
        this.valor = valor;
    }

    public String getName() {
        return name;
    }

    public int getCodigo() {
        return codigo;
    }

    public float getValor() {
        return valor;
    }

    // Método abstrato para obter a validade, a ser implementado nas subclasses
    public abstract String getValidade();

    // Método exibirDetalhes pode ser sobrescrito nas subclasses
    public void exibirDetalhes() {
        System.out.println("Detalhes do produto não definidos.");
    }
}
