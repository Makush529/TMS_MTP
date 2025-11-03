package servise;

public enum Directions{
    ACCOUNT_DETAILS("src/resources/accountDetails.txt"),
    INPUT("src/resources/input"),//путь к директории вводных данных
    ARCHIVE("src/resources/archive"),//путь к директории архива
    REPORT("src/resources/report/report.txt");

    private final String path;

    Directions(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
