package servise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SearchAndSortFilsService {
    public static void searchOrCreateFiles() {
        try {/**пересмотреть енамы!!!!!!*/
            Path inputDirections = Paths.get(Directions.INPUT.getPath());
            Path archiveDirections = Paths.get(Directions.ARCHIVE.getPath());
            Files.createDirectories(inputDirections);//создам если не существует
            Files.createDirectories(archiveDirections);//создам если не существует

            List<Path>filesList=Files.list(inputDirections)//список файлов с расширением txt
                    .filter(p->p.toString().endsWith(".txt"))
                    .collect(Collectors.toList());
            if (filesList.isEmpty()){//проверка наличия файлов тхт
                System.out.println("No files with the .txt extension were found");
                return;
            }
            for (Path file: filesList){
                FileProcessingService.fileProcessing(file);
                //переместить отработанный файл в архив
            }
        } catch (IOException e) {
            throw new RuntimeException(e);//написать ОШИБКИ
        }
    }
}
