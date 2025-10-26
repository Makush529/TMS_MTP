package servise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcessing {
    public void fileProcessing(Path path) {
        try (FileReader fileReader = new FileReader(path.toFile());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            Pattern pattern = Pattern.compile(String.valueOf(Patterns.TRANSACTION_PATTERN));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()){
                    String sendersAccount = matcher.group(1);
                    String recipientsAccount = matcher.group(2);
                    String amount = matcher.group(3);
                }
            }
        } catch (Exception e) {

        }

    }
}
