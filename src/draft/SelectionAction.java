package draft;

import java.util.Scanner;


public class SelectionAction {
    public static void select() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("in");
        int userChoise = scanner.nextInt();
        switch (userChoise) {
            case 1 -> System.out.println("goParcing");
            case 2 -> System.out.println("info");
            default -> System.out.println("default");
        }

    }
}
