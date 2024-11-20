public class Alimento extends Produto {
    String validadeAlimento;

    public Alimento(String name, int codigo, float valor, String validadeAlimento) {
        this.name = name;
        this.codigo = codigo;
        this.valor = valor;
        this.validadeAlimento = validadeAlimento;
    }
}
