package servise;

import model.Transaction;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReportService {
    public static void logSuccess(Transaction transaction) {
        String logMassage = String.format("%s| %s| %s| %s| %d| %n",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(Patterns.LOG_TIME_PATTERN.getRegex())),
                transaction.getFileName(),
                transaction.getAccountFrom(),
                transaction.getAccountTo(),
                transaction.getAmount());
        logWrite(logMassage);
    }

    public static void logError(String file, String massage, String status) {
        String logMassage = String.format("%s| %s| %s| %s| %n",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(Patterns.LOG_TIME_PATTERN.getRegex())),
                file,
                massage,
                status);
        logWrite(logMassage);
    }

    public static void logWrite(String logMassage) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get((Directions.REPORT.getPath())),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            bufferedWriter.write(logMassage);
        } catch (Exception e) {
        }
    }

    public static void logDisplay() {
        //вторая
    }
}