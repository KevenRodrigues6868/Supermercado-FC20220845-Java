# Sistema de Mercado

Este é um sistema de gerenciamento de um mercado simulado, onde os produtos são de três tipos: **Alimentos**, **Utensílios** e **Eletroeletrônicos**. O sistema permite adicionar produtos ao estoque, realizar compras, calcular o valor total de vendas e registrar o lucro obtido. O valor de caixa inicial do sistema é fixo em R$ 200, e a lógica do caixa mantém esse valor, subtraindo o lucro das compras.

## Estrutura do Projeto

O projeto é composto por várias classes que formam um sistema modular e de fácil manutenção. A seguir, descreverei cada uma das classes principais e suas funções.

### 1. **Classe Produto**
A classe `Produto` é uma classe abstrata que serve de base para os outros tipos de produtos (Alimento, Utensílio e Eletroeletrônico). Ela contém os atributos comuns aos produtos:

- `name` (nome do produto)
- `codigo` (código identificador do produto)
- `valor` (preço do produto)

Além disso, a classe `Produto` define os métodos abstratos `getValidade()` e `exibirDetalhes()`, que são sobrescritos nas subclasses.

#### Métodos:
- `getValidade()`: Este método é implementado nas subclasses para retornar a validade ou garantia do produto.
- `exibirDetalhes()`: Exibe os detalhes do produto, como validade ou garantia, dependendo do tipo de produto.

### 2. **Classe Alimento**
A classe `Alimento` estende a classe `Produto` e representa um tipo de produto perecível. Ela tem o atributo `validadeAlimento` para armazenar a data de validade.

#### Métodos:
- `exibirDetalhes()`: Exibe a validade do alimento.
- `getValidade()`: Retorna a validade do alimento.

### 3. **Classe Utensilios**
A classe `Utensilios` também estende a classe `Produto` e representa produtos que possuem um tempo de validade, mas não são perecíveis.

#### Métodos:
- `exibirDetalhes()`: Exibe a validade do utensílio.
- `getValidade()`: Retorna a validade do utensílio.

### 4. **Classe Eletroeletronicos**
A classe `Eletroeletronicos` estende a classe `Produto` e representa produtos eletrônicos, que têm uma garantia em vez de validade.

#### Métodos:
- `exibirDetalhes()`: Exibe a garantia do eletroeletrônico.
- `getValidade()`: Retorna "Não aplicável", pois a validade não se aplica aos eletroeletrônicos.
- `getGarantia()`: Retorna a garantia do produto eletrônico.

### 5. **Classe ProdutoFactory**
A classe `ProdutoFactory` é responsável por criar instâncias dos diferentes tipos de produtos (Alimento, Utensílio e Eletroeletrônico) com base no tipo de produto fornecido como parâmetro.

#### Método:
- `tipodeProduto()`: Cria um novo produto baseado no tipo fornecido (1 para Alimento, 2 para Utensílio, 3 para Eletroeletrônico).

### 6. **Classe Mercado**
A classe `Mercado` é a classe principal que simula as operações do mercado, como a exibição do estoque, a realização de compras e o controle financeiro. Ela tem os seguintes componentes:

- `Terminal`: Responsável por exibir o menu e obter a entrada do usuário.
- `ProdutosList`: Armazena a lista de produtos disponíveis no estoque.
- `TotalCaixa`: Gerencia o saldo do caixa do mercado.
- `saldo`: Um valor inicial de R$ 200, que nunca é alterado e sempre permanece no caixa.

#### Fluxo Principal:
- **Estoque**: O sistema permite exibir produtos e adicionar novos produtos ao estoque.
- **Compras**: O usuário pode adicionar produtos ao carrinho e finalizar a compra. O sistema calcula o total da compra e atualiza o saldo do caixa.
- **Financeiro**: O sistema permite realizar pesquisas de produtos, fechar o caixa e exibir o total de vendas e o lucro.

### 7. **Classe Compra**
A classe `Compra` representa o processo de compra de um cliente. Ela mantém uma lista de produtos no carrinho e calcula o valor total da compra.

#### Métodos:
- `addProduto()`: Adiciona um produto ao carrinho de compras.
- `removerProduto()`: Remove um produto do carrinho de compras.
- `mostrarCompra()`: Exibe os produtos presentes no carrinho.
- `getValorTotal()`: Calcula e retorna o valor total da compra.

### 8. **Classe TotalCaixa**
A classe `TotalCaixa` gerencia o caixa do mercado, mantendo o valor total das compras realizadas e calculando o lucro.

#### Métodos:
- `adicionarCompra()`: Adiciona o valor de uma compra ao total do caixa.
- `calcularTotal()`: Calcula o total das compras.
- `limpar()`: Limpa o valor do caixa após o fechamento.
- `exibirTotal()`: Exibe o valor total acumulado no caixa.

### 9. **Classe Terminal**
A classe `Terminal` gerencia a interação com o usuário, fornecendo um menu principal e lendo as entradas do usuário.

#### Métodos:
- `showMainMenu()`: Exibe o menu principal com as opções do sistema.
- `readNumber()`: Lê um número informado pelo usuário.
- `readString()`: Lê uma string informada pelo usuário.

## Lógica do Caixa
O sistema mantém o valor do caixa sempre em **R$ 200,00**. Quando uma compra é realizada, o valor total da compra é somado ao caixa. No entanto, o sistema subtrai R$ 200 do total de compras para calcular o lucro. O valor de R$ 200 sempre permanece no caixa, e apenas o valor correspondente ao lucro é retirado. Portanto, o saldo de caixa é atualizado da seguinte maneira:

1. O total da compra é adicionado ao caixa.
2. O valor de R$ 200 é mantido no caixa como saldo inicial.
3. O valor do lucro (valor total da compra - R$ 200) é calculado e retirado do caixa.

### Exemplo:
- Se o valor da compra for R$ 300, o sistema adiciona R$ 300 ao caixa.
- O valor de R$ 200 é mantido, e o lucro de R$ 100 é retirado.

## Como Executar
Para executar o sistema, basta compilar e rodar o arquivo `Mercado.java`:

```bash
javac Mercado.java
java Mercado
