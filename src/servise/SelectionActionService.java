package servise;

import java.util.Scanner;


public class SelectionActionService {
    public static void select() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("in");
        int userChoise = scanner.nextInt();
        switch (userChoise) {
            case 1 ->SearchAndSortFilsService.searchOrCreateFiles();
            case 2 -> System.out.println("info");
            default -> System.out.println("default");
        }

    }
}
