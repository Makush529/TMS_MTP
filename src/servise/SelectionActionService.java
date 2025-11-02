package servise;

import java.io.IOException;
import java.util.Scanner;


public class SelectionActionService {
    public static void select() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - start parsing\n" +
                    "2 - show report\n" +
                    "3 - exit");
            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 -> SearchAndSortFilsService.searchOrCreateFiles();
                case 2 -> {
                    try {
                        ReportService.logDisplay();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 0 -> {
                    System.out.println("program completed");
                    System.exit(0);
                }
                default -> System.out.println("Invalid command entered");
            }

        }
    }
}