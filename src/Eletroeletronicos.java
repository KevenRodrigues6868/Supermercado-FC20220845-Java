public class Eletroeletronicos extends Produto {
    private String garantia;

    public Eletroeletronicos(String name, int codigo, float valor, String garantia) {
        super(name, codigo, valor);
        this.garantia = garantia;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Garantia: " + garantia);  // Exibe a garantia do eletroeletrônico
    }

    @Override
    public String getValidade() {
        return "Não aplicável";  // Para Eletroeletrônicos, a validade não é aplicável
    }

	public String getGarantia() {
		// TODO Auto-generated method stub
		return "Não aplicável";  // Para Eletroeletrônicos, a validade não é aplicável
	}
}
