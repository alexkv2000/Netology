package day7.step21;

public class AnsiColor {
    public static final String ANSI_RED = "\u001B[41m"; // подцветка разницы доход - расход - красный фон
    static final String ANSI_BLACK = "\u001b[30m"; // черный
    static final String ANSI_SCARLET = "\u001b[31m"; // алый
    static final String ANSI_GREEN = "\u001b[32m"; // зеленый
    static final String ANSI_YELLOW = "\u001b[33m"; // Жёлтый
    static final String ANSI_BLUE = "\u001b[34m"; // Синий
    static final String PURPLE = "\u001b[35m"; // Пурпурный
    static final String ANSI_CYAN = "\u001b[36m"; // Голубой
    static final String ANSI_WHITE = "\u001b[37m"; // Белый
    public static final String ANSI_RESET = "\u001B[0m"; // конец подцветки - черный фон

    static final String ANSI_CLEAR_TERMINAL = "\033[2J";
}
