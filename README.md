Mercado - Simulador de Caixa de Supermercado
Este é um projeto acadêmico desenvolvido para simular o funcionamento de um caixa de supermercado. O sistema permite realizar vendas, gerenciar o estoque de produtos e controlar o saldo do caixa, incluindo o fechamento de caixa ao final do dia.

Funcionalidades
O sistema simula as seguintes operações de um caixa de supermercado:

Exibição de Estoque: O sistema permite visualizar os produtos disponíveis no estoque.
Realização de Compras: O usuário pode adicionar produtos a uma compra e finalizar a transação.
Controle Financeiro: O saldo do caixa é atualizado com o valor das compras realizadas. Também é possível fechar o caixa, gerando um relatório financeiro.
Fechamento de Caixa: Ao final do expediente, o saldo do caixa é fechado e comparado com o valor inicial de R$ 200,00. O sistema calcula a diferença e informa o valor que deverá ser sacado.
Estrutura do Projeto
O projeto é composto pelas seguintes classes:

1. Classe Mercado
Responsabilidades: Gerencia a simulação do mercado, controla as transações de compra e o saldo do caixa.
Principais Métodos:
startSimulation(): Inicia a simulação, incluindo o cadastro de produtos no estoque.
loop(): Controla o menu principal, permitindo ao usuário interagir com o sistema.
showComprar(): Exibe o processo de compra de produtos.
finalizarCompra(): Finaliza a compra e atualiza o saldo do caixa.
fecharCaixa(): Fecha o caixa, calculando o valor a ser sacado.
2. Classe Terminal
Responsabilidades: Gerencia a interação com o usuário, exibindo menus e capturando entradas no terminal.
Principais Métodos:
showMainMenu(): Exibe o menu principal do sistema.
readNumber(): Lê um número informado pelo usuário.
3. Classe Produto
Responsabilidades: Representa um produto no mercado, com informações como nome, código e valor.
Principais Métodos:
calcValor(): Calcula o valor do produto.
toString(): Retorna uma descrição formatada do produto.
4. Classe ProdutosList
Responsabilidades: Gerencia a lista de produtos disponíveis no estoque.
Principais Métodos:
addProduto(): Adiciona um produto à lista.
printProduto(): Exibe todos os produtos disponíveis.
5. Classe Compra
Responsabilidades: Representa uma compra realizada, armazenando os produtos comprados e o valor total.
Principais Métodos:
addProduto(): Adiciona um produto à compra.
mostrarCompra(): Exibe os produtos da compra.
getValorTotal(): Retorna o valor total da compra.
Como Executar o Projeto
Clone o repositório:

bash
Copiar código
git clone https://github.com/seuusuario/mercado-simulador.git
Compile o projeto: Navegue até o diretório do projeto e compile os arquivos .java:

bash
Copiar código
javac *.java
Execute a simulação: Após compilar, execute a classe Mercado:

bash
Copiar código
java Mercado
Interaja com o Sistema: O terminal irá exibir um menu onde você pode escolher opções como:

Ver o estoque (1)
Realizar uma nova compra (2)
Acessar o menu financeiro (3)
Fechar o caixa (5)
Sair do sistema (4)
