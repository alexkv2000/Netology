package day10.Librarry;

import java.util.Date;

public class UserAdministrator extends UserLibrarian implements Administrator {

    public UserAdministrator(String fio, Book book, Date dateTook, int toDays, Boolean debtTrue) {
        super(fio, book, dateTook, toDays, debtTrue);
    }

    @Override
    public boolean findBook(String sBook, Book[] books) {// поиск книги
        System.out.println("поиск книги...");
        boolean bFind = false;
        for (Book b : books) {
            if (b.name.equals(sBook) || b.author.equals(sBook)) {
                System.out.printf("Книга найдена: %s - %s. Статус - %s, выдана - {%s}. \n", b.name, b.author, b.status, b.giveOut);
                bFind = true;
            }
        }
        if (!bFind) {
            System.out.printf("Книга/автор {%s} - не найдена.\n", sBook);
        }

        return bFind;
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
        String sNotify = "";
        if (user.getDateEnd() == null) {
            str = "Пользователь {%s} не имеет на руках книг.\n";
            System.out.printf(str, user.fio);
            return sNotify;
        }
        if (user.getDateEnd().before(new Date())) {
            str = "ВНИМАНИЕ! {%s} Пора вернуть книгу {%s - %s} в библиотеку! Дата возврата: %s \n";
            sNotify = user.dateEnd.toString();
        } else str = "{%s} взял книгу {%s - %s}. Дата возврата: %s \n";
        System.out.printf(str, user.fio, user.book.name, user.book.author, user.dateEnd);
        return sNotify;
    }
}
