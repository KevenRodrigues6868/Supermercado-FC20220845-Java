public class Utensilios extends Produto {
    private String validadeUten;

    public Utensilios(String name, int codigo, float valor, String validadeUten) {
        super(name, codigo, valor);
        this.validadeUten = validadeUten;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Validade: " + validadeUten);  // Exibe a validade do utensílio
    }

    @Override
    public String getValidade() {
        return validadeUten;  // Retorna a validade do utensílio
    }
}
