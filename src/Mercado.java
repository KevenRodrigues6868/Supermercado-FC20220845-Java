import java.util.ArrayList;

public class Mercado {
    private Terminal terminal;
    private ProdutosList produtoList;
    private float saldo; // Saldo do caixa
    private ArrayList<Float> TotalCaixa; // Lista para armazenar o total das compras realizadas

    public Mercado() {
        terminal = new Terminal();
        produtoList = new ProdutosList();
        saldo = 200.00f; // Saldo inicial de 200,00
        TotalCaixa = new ArrayList<>();
    }

    public void startSimulation() {
        // Inicializa produtos na loja
        produtoList.addProduto(ProdutoFactory.tipodeProduto(1, "Bolacha Rancheiro", 1, 10.50f, "45 dias", null, null));
        produtoList.addProduto(ProdutoFactory.tipodeProduto(2, "Colher", 2, 5.20f, null, "360 dias", null));
        produtoList.addProduto(ProdutoFactory.tipodeProduto(3, "Sanduicheira", 3, 120.75f, null, null, "2 anos"));
        
        loop();
    }

    private void loop() {
        Compra compra = new Compra();
        int opcao = -1;
        while (opcao != 4) {
            opcao = terminal.showMainMenu();
            switch (opcao) {
                case 1:
                    produtoList.printProduto(); // Exibe estoque
                    break;
                case 2:
                    showComprar(compra); // Abre o processo de compra
                    break;
                case 3:
                    // Aqui você pode adicionar funcionalidades financeiras
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                case 5: // Nova opção para fechar caixa
                    fecharCaixa();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private void showComprar(Compra compra) {
        boolean continuarCompra = true;
        while (continuarCompra) {
            int codigoProduto = Console.readNumber("Digite o código do produto (ou 0 para finalizar): ");
            if (codigoProduto == 0) {
                continuarCompra = false;
                System.out.println("Compra finalizada!");
            } else {
                Produto produto = produtoList.getProdutoPorCodigo(codigoProduto);
                if (produto != null) {
                    compra.addProduto(produto);
                    System.out.println("Produto " + produto.name + " adicionado à compra.");
                } else {
                    System.out.println("Produto não encontrado.");
                }
            }
            compra.mostrarCompra();
            
            if (continuarCompra) {
                int opcao = Console.readNumber("Deseja adicionar outro produto? (1 - Sim / 2 - Não): ");
                if (opcao == 2) {
                    continuarCompra = false;
                    System.out.println("Compra finalizada!");
                }
            }
        }

        finalizarCompra(compra);
    }

    private void finalizarCompra(Compra compra) {
        System.out.println("Resumo da Compra:");
        compra.mostrarCompra();
        float valorTotal = compra.getValorTotal();
        System.out.println("Valor total da compra: R$ " + valorTotal);
        TotalCaixa.add(valorTotal); // Adiciona o valor da compra à lista TotalCaixa
        saldo += valorTotal; // Atualiza o saldo do caixa
        System.out.println("Novo saldo do caixa: R$ " + saldo);
    }

    // Método para fechar o caixa
    private void fecharCaixa() {
        float totalCompras = 0;
        // Soma o total das compras
        for (float valor : TotalCaixa) {
            totalCompras += valor;
        }
        
        // Calcula a diferença entre o total das compras e o valor inicial de 200
        float valorSaque = totalCompras - 200;
        System.out.println("Valor total das compras: R$ " + totalCompras);
        System.out.println("Valor a ser sacado (total - R$ 200): R$ " + valorSaque);
        
        saldo = 200; // Deixa o saldo do caixa com R$ 200,00 após o fechamento
        TotalCaixa.clear(); // Limpa a lista de compras realizadas
    }

    public static void main(String[] args) {
        Mercado mercado = new Mercado();
        mercado.startSimulation();
    }
}
