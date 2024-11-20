public class ProdutoFactory {
    public static Produto tipodeProduto(int action, String name, int codigo, float valor, String validadeAlimento, String validadeUten, String garantia) {
        switch (action) {
            case 1: // Alimento
                return new Alimento(name, codigo, valor, validadeAlimento);
            case 2: // Utensílio
                return new Utensilios(name, codigo, valor, validadeUten);
            case 3: // Eletroeletrônico
                return new Eletroeletronicos(name, codigo, valor, garantia);
            default:
                throw new IllegalArgumentException("Valor Inserido Invalido");
        }
    }
}
