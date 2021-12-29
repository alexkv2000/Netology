package day10;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 23:27
 */
public interface Reader {
    void takeBook(Book book, int toDays); //брать книгу

    void returnBook(Book book); //вернуть книгу

}
