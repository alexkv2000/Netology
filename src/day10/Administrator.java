package day10;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 23:34
 */
public interface Administrator {
    Book findBook(Book book); // поиск книги

    Book giveOutBook(User user); // выдать книгу

    String notification(Reader reader); //уведомить о просрочке времени возврата
}
