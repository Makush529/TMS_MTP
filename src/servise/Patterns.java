package servise;


public enum Patterns {
    ACCOUNT_NUMBER_AND_AMOUNT("([0-9]{10}):([0-9]+)"),
    TRANSACTION_PATTERN("(^([0-9]{10}):([0-9]{10}):([0-9]+)$"),//паттерн записи перевода
    LOG_TIME_PATTERN("dd.MM.yyyy HH:mm:ss");

    private final String regex;

    Patterns(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
