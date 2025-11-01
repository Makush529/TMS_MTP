package servise;

import exceptions.InsufficientFundsException;
import exceptions.InvalidTransactionException;
import model.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchAndSortFilsService {
    public static List<Path> searchOrCreateFiles() {
        try {
            AccountService.createAccountNumbers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {/**пересмотреть енамы!!!!!!*/
            Path inputDirections = Paths.get(Directions.INPUT.getPath());
            Path archiveDirections = Paths.get(Directions.ARCHIVE.getPath());
            Files.createDirectories(inputDirections);//создам если не существует
            Files.createDirectories(archiveDirections);//создам если не существует

            List<Path> filesList = Files.list(inputDirections)//список файлов с расширением txt
                    .filter(p -> p.toString().endsWith(".txt"))
                    .collect(Collectors.toList());
            if (filesList.isEmpty()) {//проверка наличия файлов тхт
                System.out.println("No files with the .txt extension were found");
            } else {
                for (Path file : filesList) {
                    fileProcessing(file);
                    System.out.println(file);//забыл уже для чего это тут.....
                }
            }
            return filesList;
        } catch (IOException e) {
            throw new RuntimeException(e);//написать ОШИБКИ
        }
    }

    static public void fileProcessing(Path path) {
        try (FileReader fileReader = new FileReader(path.toFile());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            Pattern pattern = Pattern.compile(Patterns.TRANSACTION_PATTERN.getRegex());
            String line;
            int counter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("строка: " + (counter = counter + 1));
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String accountFrom = matcher.group(1);
                    String accountIn = matcher.group(2);
                    int amount = Integer.parseInt(matcher.group(3));
                    Transaction transaction = new Transaction(accountFrom, accountIn, amount, path.getFileName().toString());
                    executeTransaction(transaction);
                } else {
                    ReportService.logError(path.getFileName().toString(), "что то пошло не так(серч и сорт)", "FALSE");
                }
            }
        } catch (Exception e) {
            ReportService.logError(path.getFileName().toString(), "file processing error", "FALSE");
        }

    }

    private static void executeTransaction(Transaction transaction) {
        try {
            AccountService.transfer(transaction.getAccountFrom(),
                    transaction.getAccountTo(),
                    transaction.getAmount());
            ReportService.logSuccess(transaction);
        } catch (InvalidTransactionException e) {
            ReportService.logError(transaction.getFileName(),
                    "invalid account", "FALSE");
        } catch (InsufficientFundsException e) {
            ReportService.logError(transaction.getFileName(),
                    "malo deneeg", "FALSE");
        }
    }
}
