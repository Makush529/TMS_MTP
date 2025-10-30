package tests;

import servise.SearchAndSortFilsService;

import java.nio.file.Path;
import java.util.List;

public class Test3SearchFiles {
    public static void main(String[] args) {
        List<Path> list = SearchAndSortFilsService.searchOrCreateFiles();
    }
}
