package servise;

public enum Directions{
    INPUT("src/resources/input"),//путь к директории вводных данных
    ARCHIVE("src/resources/archive"),//путь к директории архива
    REPORT("src/resources/report");


    private final String path;

    Directions(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
