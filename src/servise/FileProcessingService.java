package servise;

import model.Account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcessingService {
    static public void fileProcessing(Path path) {
        try (FileReader fileReader = new FileReader(path.toFile());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            Pattern pattern = Pattern.compile(String.valueOf(Patterns.TRANSACTION_PATTERN));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String sendersAccount = matcher.group(1);
                    String recipientsAccount = matcher.group(2);
                    int amount = Integer.parseInt(matcher.group(3));
                    TransactionService transaction = new TransactionService(sendersAccount,
                            recipientsAccount,
                            amount,
                            path.getFileName().toString());
                } else {
                    ReportService.logError((path.getFileName().toString()),
                            "косяк с группами матчер",
                            "не обработано");
                }
            }
        } catch (Exception e) {//доделать!!!!!!!!!!!!!!!!!!!
        }

    }

    /*private static void transaction(TransactionService transaction) {
        try {
            Account.transfer(transaction.getSendersAccount(),
                    transaction.getRecipientsAccount(),
                    transaction.getAmount());
            ReportService.logSuccess(transaction);
        } catch (Exception e) {
        }
    }*/
}
