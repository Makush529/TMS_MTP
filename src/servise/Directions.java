package servise;

public enum Directions{
    INPUT("src/resources/"),//путь к директории вводных данных
    ARCHIVE("src/resources/");//путь к директории архива


    private final String path;

    Directions(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
