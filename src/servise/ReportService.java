package servise;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReportService {
    public static void log() {
        String logMassage = String.format("%s | %s | %s | %s |%d ",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(Patterns.LOG_TIME_PATTERN.getRegex())));
        //имя файла
        //номер счета
        //номер счета
        //сумма перевода
    }
}