import java.util.Scanner;

public class Terminal {
    private Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("MENU PRINCIPAL: \n");
        System.out.println("1 - Estoque:");
        System.out.println("2 - Abrir Nova Venda: ");
        System.out.println("3 - Financeiro:");
        System.out.println("4 - Sair");
        System.out.println("5 - Fechar Caixa"); // Nova opção para fechar o caixa
        return Console.readNumber("Escolha uma opção: ");
    }

   

    public int readNumber(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
}
