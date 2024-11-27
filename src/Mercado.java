public class Mercado {
    private Terminal terminal;
    private ProdutosList produtoList;
    private float saldo;
    private TotalCaixa totalCaixa;  // Usando TotalCaixa em vez de ArrayList<Float>

    public Mercado() {
        terminal = new Terminal();
        produtoList = new ProdutosList();
        saldo = 200.00f; // Saldo inicial
        totalCaixa = new TotalCaixa();  // Inicializando a classe TotalCaixa
    }

    public void startSimulation() {
        // Inicializa produtos
        produtoList.addProduto(ProdutoFactory.tipodeProduto(1, "Bolacha Rancheiro", 1, 10.50f, "45 dias", null, null));
        produtoList.addProduto(ProdutoFactory.tipodeProduto(2, "Colher", 2, 5.20f, null, "360 dias", null));
        produtoList.addProduto(ProdutoFactory.tipodeProduto(3, "Sanduicheira", 3, 120.75f, null, null, "2 anos"));

        loop();
    }

    private void loop() {
        int opcao = -1;
        while (opcao != 4) {
            opcao = terminal.showMainMenu();
            switch (opcao) {
                case 1:
                    showEstoque();
                    break;
                case 2:
                    Compra compra = new Compra();
                    showComprar(compra);
                    break;
                case 3:
                    showFinanceiro();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private void showEstoque() {
        int opcao;
        do {
            System.out.println("\n--- Estoque ---");
            System.out.println("1 - Exibir produtos");
            System.out.println("2 - Adicionar produto");
            System.out.println("3 - Voltar");
            opcao = Console.readNumber("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    produtoList.printProduto();
                    break;
                case 2:
                    adicionarProduto();
                    break;
                case 3:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 3);
    }

    private void adicionarProduto() {
        int tipo = Console.readNumber("Tipo de produto: 1 - Alimento, 2 - Utensílio, 3 - Eletroeletrônico: ");
        String nome = Console.readString("Nome: ");
        int codigo = Console.readNumber("Código: ");
        float valor = Console.readFloat("Valor: ");

        Produto novoProduto;
        switch (tipo) {
            case 1:
                String validadeAlimento = Console.readString("Validade do alimento: ");
                novoProduto = new Alimento(nome, codigo, valor, validadeAlimento);
                break;
            case 2:
                String validadeUtensilio = Console.readString("Validade do utensílio: ");
                novoProduto = new Utensilios(nome, codigo, valor, validadeUtensilio);
                break;
            case 3:
                String garantia = Console.readString("Garantia: ");
                novoProduto = new Eletroeletronicos(nome, codigo, valor, garantia);
                break;
            default:
                System.out.println("Tipo inválido.");
                return;
        }

        produtoList.addProduto(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }
    
    private void pesquisarProduto() {
        int opcaoPesquisa = Console.readNumber("Escolha o tipo de pesquisa: 1 - Código, 2 - Nome: ");
        Produto produto = null;
        
        if (opcaoPesquisa == 1) {
            int codigo = Console.readNumber("Digite o código do produto: ");
            produto = produtoList.getProdutoPorCodigo(codigo);
        } else if (opcaoPesquisa == 2) {
            String nome = Console.readString("Digite o nome do produto: ");
            produto = produtoList.getProdutoPorNome(nome);
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        // Verificar se o produto foi encontrado
        if (produto != null) {
            System.out.println("\nProduto encontrado:");
            System.out.println("Nome: " + produto.getName());
            
            // Verificar o tipo do produto e exibir a validade/garantia correspondente
            if (produto instanceof Alimento) {
                System.out.println("Validade: " + ((Alimento) produto).getValidade());
            } else if (produto instanceof Utensilios) {
                System.out.println("Validade: " + ((Utensilios) produto).getValidade());
            } else if (produto instanceof Eletroeletronicos) {
                System.out.println("Garantia: " + ((Eletroeletronicos) produto).getGarantia());
            } else {
                System.out.println("Produto sem validade ou garantia.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }


    private void showComprar(Compra compra) {
        boolean continuar = true;
        while (continuar) {
            int codigo = Console.readNumber("Código do produto (ou 0 para finalizar, 5 para remover um item): ");
            if (codigo == 0) {
                continuar = false;
                System.out.println("Compra finalizada.");
            } else if (codigo == 5) {
                // Remover um item do carrinho
                int produtoRemover = Console.readNumber("Digite o código do produto a remover do carrinho: ");
                Produto produto = compra.getProdutoPorCodigo(produtoRemover); // Método para buscar produto no carrinho
                if (produto != null) {
                    compra.removerProduto(produto);  // Remover o produto
                    System.out.println(produto.getName() + " removido do carrinho.");
                } else {
                    System.out.println("Produto não encontrado no carrinho.");
                }
            } else {
                Produto produto = produtoList.getProdutoPorCodigo(codigo);
                if (produto != null) {
                    compra.addProduto(produto);
                    System.out.println(produto.getName() + " adicionado.");
                } else {
                    System.out.println("Produto não encontrado.");
                }
            }
        }
        finalizarCompra(compra);
    }


    private void finalizarCompra(Compra compra) {
        compra.mostrarCompra();
        float total = compra.getValorTotal();
        totalCaixa.adicionarCompra(total);  // Usando TotalCaixa para adicionar o total da compra
        saldo += total;
        System.out.println("Saldo atualizado: R$ " + saldo);
    }

    private void showFinanceiro() {
        int opcao;
        do {
            System.out.println("\n--- Menu Financeiro ---");
            System.out.println("1 - Pesquisar produto");
            System.out.println("2 - Fechar caixa");
            System.out.println("3 - Voltar");
            opcao = Console.readNumber("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    pesquisarProduto(); // Chama o método de pesquisa
                    break;
                case 2:
                    fecharCaixa(); // Fecha o caixa
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 3);
    }

    private void fecharCaixa() {
        // Exibe o total acumulado no caixa
        totalCaixa.exibirTotal();  // Exibe o total das vendas registradas
        
        // Calcula o valor total das vendas líquidas
        float totalVendasLiquidas = totalCaixa.calcularTotal() - 200;
        
        // Exibe a mensagem com o valor das vendas líquidas e o valor que ficará no caixa
        System.out.println("Total de vendas líquidas: R$ " + totalVendasLiquidas);
        
        // Exibe o valor que ficará no caixa (vendas líquidas + R$ 200 de saldo inicial)
        float valorNoCaixa = totalVendasLiquidas + 200;
        System.out.println("Valor que ficará no caixa: R$ " + valorNoCaixa);
        
        // Limpa os valores do caixa após fechar o dia
        totalCaixa.limpar();  // Limpa a lista após fechar o caixa
    }

    
    
    public static void main(String[] args) {
        Mercado mercado = new Mercado();
        mercado.startSimulation();
    }
}
