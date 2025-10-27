package servise;


public enum Patterns {
    TRANSACTION_PATTERN("(^(.*?\\d{5}\\s\\d{5})\\s(\\d{5}\\s\\d{5})\\s(\\d{5}).*?)$"),//паттерн записи перевода
    LOG_TIME_PATTERN("dd.MM.yyyy HH:mm:ss");

    private final String regex;

    Patterns(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
