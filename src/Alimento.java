public class Alimento extends Produto {
    private String validadeAlimento;

    public Alimento(String name, int codigo, float valor, String validadeAlimento) {
        super(name, codigo, valor);
        this.validadeAlimento = validadeAlimento;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Validade: " + validadeAlimento);  // Exibe a validade do alimento
    }

    @Override
    public String getValidade() {
        return validadeAlimento;  // Retorna a validade do alimento
    }
}
