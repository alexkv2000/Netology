package day10;

import java.util.Date;

public class UserAdministrator extends UserLibrarian implements Administrator {

    public UserAdministrator(String fio, Book book, Date dateTook, int toDays, Boolean debtTrue) {
        super(fio, book, dateTook, toDays, debtTrue);
    }

    @Override
    public Book findBook(String sBook, Book[] books) {// поиск книги
        System.out.println("поиск книги...");
        for (Book b : books) {
            if (b.name.equals(sBook) || b.author.equals(sBook)) {
                System.out.printf("Книга найдена: %s - %s. Статус - %s, выдана - {%s}. \n", b.name, b.author, b.status, b.giveOut);
                return b;
            }
        }
        System.out.printf("Книга/автор {%s} - не найдена.\n", sBook);
        return null;
    }

    @Override
    public Book giveOutBook(User user, Book book, int days) {// выдать книгу
        if (notification(user).equals("")) {
            user.takeBook(book, days);
        }
        return user.book;
    }

    @Override
    public String notification(User user) {//уведомить о просрочке времени возврата
        String str;
        if (user.getDateEnd().after(new Date())) {
            str = "ВНИМАНИЕ. Пора вернуть книгу в библиотеку.";
        } else str = "";
        System.out.printf("ВНИМАНИЕ! {%s} Пора вернуть книгу {%s - %s} в библиотеку! Дата возврата: %s \n", user.fio, user.book.name, user.book.author, user.dateEnd);
        return str;
    }
}
