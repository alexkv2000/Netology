package day10.Librarry;

/**
 * @author KAU
 */
public interface Administrator {

    boolean findBook(String sBook, Book[] books);// поиск книги

    Book giveOutBook(User user, Book book, int days); // выдать книгу

    String notification(User user); //уведомить о просрочке времени возврата
}
