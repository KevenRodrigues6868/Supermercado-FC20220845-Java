import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static int readNumber(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println(":");
            scanner.next(); // Descarta a entrada inválida
        }
        return scanner.nextInt();
    }

    public static float readFloat(String message) {
        System.out.print(message);
        while (!scanner.hasNextFloat()) {
            System.out.println("Por favor, insira um número decimal válido.");
            scanner.next(); // Descarta a entrada inválida
        }
        return scanner.nextFloat();
    }

    public static String readString(String message) {
        System.out.print(message);
        return scanner.next();
    }
}
