package day10;

/**
 * @author KAU
 */
public interface Administrator {

    Book findBook(String sBook, Book[] books);// поиск книги

    Book giveOutBook(User user, Book book, int days); // выдать книгу

    String notification(User user); //уведомить о просрочке времени возврата
}
