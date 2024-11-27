# Sistema de Gerenciamento de Mercado Simulado

Este é um sistema de **gerenciamento de um mercado**, projetado para gerenciar o estoque e as transações financeiras de um mercado. O sistema oferece funcionalidades como a adição de produtos ao estoque, realização de compras, cálculo do valor total das vendas, e registro do lucro obtido. Além disso, o mercado simulado possui uma lógica de caixa em que o valor inicial de R$ 200 é mantido constante, e o lucro das vendas é calculado com base nas compras realizadas.

## Funcionalidades Principais

O sistema é composto por uma série de funcionalidades que permitem a administração do mercado. A seguir, detalho as funcionalidades mais importantes que compõem o projeto:

- **Adição de Produtos**: Permite a adição de produtos de diferentes categorias (Alimentos, Utensílios e Eletroeletrônicos) ao estoque do mercado.
- **Controle de Estoque**: Exibe os produtos presentes no estoque e permite ao usuário realizar a compra de produtos.
- **Cálculo de Compras**: O sistema calcula o valor total das compras realizadas e exibe o total de vendas no final de cada transação.
- **Gestão de Caixa**: O caixa do mercado mantém um saldo fixo de R$ 200, sendo que o valor total das compras realizadas é subtraído desse valor para calcular o lucro.
- **Relatórios de Vendas e Lucro**: Permite ao usuário visualizar o total de vendas e o lucro obtido, com base nas compras realizadas durante o uso do sistema.

## Estrutura do Projeto

O projeto é estruturado de maneira modular, com classes que representam as diferentes entidades e funcionalidades do sistema. A seguir, uma descrição detalhada de cada classe, com seus respectivos métodos:

### 1. **Classe Produto**

A classe `Produto` é a classe base para os outros tipos de produtos, como Alimentos, Utensílios e Eletroeletrônicos. Ela possui atributos e métodos comuns para todos os produtos.

#### Atributos:
- `name`: Nome do produto.
- `codigo`: Código único de identificação do produto.
- `valor`: Preço do produto.

#### Métodos:
- **`getValidade()`**: Método abstrato que será implementado nas subclasses para retornar a validade ou garantia do produto.
- **`exibirDetalhes()`**: Método abstrato que será implementado nas subclasses para exibir detalhes específicos de cada tipo de produto.

### 2. **Classe Alimento**

A classe `Alimento` herda de `Produto` e representa produtos perecíveis, como alimentos. Possui um atributo `validadeAlimento`, que armazena a data de validade do alimento.

#### Atributos:
- `validadeAlimento`: Data de validade do alimento.

#### Métodos:
- **`exibirDetalhes()`**: Exibe a validade do alimento, mostrando ao usuário a data até a qual o produto pode ser consumido.
- **`getValidade()`**: Retorna a validade do alimento.

### 3. **Classe Utensilios**

A classe `Utensilios` herda de `Produto` e representa produtos não perecíveis, como utensílios domésticos. Ela contém um atributo `validadeUtensilio`, que indica a validade do produto.

#### Atributos:
- `validadeUtensilio`: Data de validade do utensílio.

#### Métodos:
- **`exibirDetalhes()`**: Exibe a validade do utensílio, proporcionando ao usuário informações sobre a duração do produto.
- **`getValidade()`**: Retorna a validade do utensílio.

### 4. **Classe Eletroeletronicos**

A classe `Eletroeletronicos` também herda de `Produto` e representa produtos eletrônicos, como televisores ou aparelhos de som. Em vez de validade, os produtos eletrônicos possuem um atributo de garantia.

#### Atributos:
- `garantia`: Período de garantia do produto eletrônico.

#### Métodos:
- **`exibirDetalhes()`**: Exibe o período de garantia do produto eletrônico.
- **`getValidade()`**: Retorna "Não aplicável" para validade, pois a garantia é o principal dado a ser fornecido.
- **`getGarantia()`**: Retorna o período de garantia do produto eletrônico.

### 5. **Classe ProdutoFactory**

A classe `ProdutoFactory` é responsável por criar diferentes tipos de produtos com base em um código fornecido. Ela utiliza o padrão de design **Factory Method** para instanciar os tipos específicos de produtos.

#### Métodos:
- **`tipodeProduto()`**: Este método recebe um número que corresponde ao tipo de produto (1 para Alimento, 2 para Utensílio, 3 para Eletroeletrônico) e retorna uma instância do tipo de produto adequado.

### 6. **Classe Mercado**

A classe `Mercado` centraliza as operações do mercado. Ela exibe o estoque, realiza compras, calcula os totais das compras e registra o lucro obtido. A classe também gerencia o caixa e os relatórios financeiros.

#### Atributos:
- `estoque`: Lista de produtos presentes no estoque do mercado.
- `caixa`: Instância da classe `TotalCaixa` que controla o saldo de caixa.

#### Métodos:
- **`exibirEstoque()`**: Exibe a lista de produtos disponíveis no estoque.
- **`adicionarProduto()`**: Adiciona um novo produto ao estoque.
- **`realizarCompra()`**: Permite ao usuário realizar a compra de produtos, calcula o valor total da compra e atualiza o caixa do mercado.
- **`visualizarRelatorio()`**: Exibe o total de vendas e o lucro obtido até o momento.

### 7. **Classe Compra**

A classe `Compra` gerencia as transações de compra dos clientes. Ela mantém uma lista de produtos no carrinho e calcula o valor total da compra.

#### Atributos:
- `produtos`: Lista de produtos adicionados ao carrinho de compras.
- `valorTotal`: Valor total da compra realizada.

#### Métodos:
- **`addProduto()`**: Adiciona um produto ao carrinho de compras.
- **`removerProduto()`**: Remove um produto do carrinho.
- **`mostrarCompra()`**: Exibe os produtos que foram adicionados ao carrinho.
- **`getValorTotal()`**: Calcula o valor total da compra, somando o preço de todos os produtos no carrinho.

### 8. **Classe TotalCaixa**

A classe `TotalCaixa` gerencia o saldo do caixa do mercado. Ela mantém o valor inicial de R$ 200 e calcula o lucro com base nas compras realizadas.

#### Atributos:
- `saldo`: O saldo do caixa do mercado.

#### Métodos:
- **`adicionarCompra()`**: Adiciona o valor de uma compra ao total do caixa.
- **`calcularTotal()`**: Calcula o total das compras realizadas, subtraindo o valor inicial de R$ 200 para determinar o lucro.
- **`limpar()`**: Limpa o valor do caixa, preparando-o para um novo ciclo de transações.
- **`exibirTotal()`**: Exibe o valor total acumulado no caixa.

### 9. **Classe Terminal**

A classe `Terminal` gerencia a interação com o usuário. Ela exibe o menu principal e coleta as entradas do usuário para realizar as operações no sistema.

#### Métodos:
- **`showMainMenu()`**: Exibe o menu principal com as opções de operação (visualizar estoque, realizar compras, visualizar relatório, etc.).
- **`readNumber()`**: Lê um número informado pelo usuário, utilizado para selecionar as opções do menu.
- **`readString()`**: Lê uma string informada pelo usuário, útil para capturar dados como o nome do produto.

## Lógica do Caixa

A lógica de gerenciamento de caixa no sistema garante que o valor inicial de **R$ 200,00** seja mantido constante, independentemente do número de transações realizadas. Durante uma compra, o valor total da transação é somado ao caixa, mas o lucro é calculado com base na diferença entre o valor da compra e o saldo inicial de R$ 200,00.

### Exemplo de Funcionamento:
- **Compra de R$ 300**: O sistema adiciona R$ 300 ao caixa, mas subtrai os R$ 200 iniciais, deixando um lucro de R$ 100.

Este método de gestão de caixa é utilizado para garantir que o saldo inicial do mercado seja sempre o mesmo, e o lucro obtido nas transações seja registrado separadamente.

## Como Executar

Para executar o sistema, basta compilar e rodar o arquivo `Mercado.java`:

```bash
javac Mercado.java
java Mercado
