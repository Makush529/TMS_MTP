package servise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchAndSortFils {
    public static void searchOrCreateFiles() {
        try {
            Path inputDirections = Paths.get(Directions.INPUT.getPath());
            Path archiveDirections = Paths.get(Directions.ARCHIVE.getPath());
            Files.createDirectories(inputDirections);
            Files.createDirectories(archiveDirections);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
