package servise;

public enum Patterns {
    TRANSACTION_PATTERN("(^(.*?\\d{5}\\s\\d{5})\\s(\\d{5}\\s\\d{5})\\s(\\d{5}).*?)$"),//паттерн записи перевода
    PATTERN_OF_LOG("123");

    private final String regex;

    Patterns(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
