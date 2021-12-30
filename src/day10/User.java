package day10;

import day10.Utils.DateUtil;

import java.util.Date;

/**
 * @author KAU
 */
public class User extends DateUtil implements Reader {
    String fio;
    Book book; //какую книгу взял пользователь в библиотеке(читает)
    Date dateTook; //дата когда взял
    int toDays; //на какое кол-во дней взял почитать
    Date dateEnd; //дата возврата
    Boolean debtTrue; //имеется задолженность

    public User() {
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setDateTook(Date dateTook) {
        this.dateTook = dateTook;
    }

    public void setToDays(int toDays) {
        this.toDays = toDays;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setDebtTrue(Boolean debtTrue) {
        this.debtTrue = debtTrue;
    }

    @Override
    public String toString() {
        String str;
        if (book != null) {
            str = "User{" +
                    "fio='" + fio + '\'' +
                    ", book=" + book.name + " " + book.author +
                    ", dateTook=" + dateTook +
                    ", toDays=" + toDays +
                    ", dateEnd=" + dateEnd +
                    ", debtTrue=" + debtTrue +
                    '}';
        } else {
            str = "User{" +
                    "fio='" + fio + '\'' +
                    ", dateTook=" + dateTook +
                    ", toDays=" + toDays +
                    ", dateEnd=" + dateEnd +
                    ", debtTrue=" + debtTrue +
                    '}';
        }
        return str;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public User(String fio, Book book, Date dateTook, int toDays, Boolean debtTrue) {
        this.fio = fio;
        this.book = book;
        book.giveOut = true;
        this.dateTook = dateTook; //когда взял книгу
        this.toDays = toDays; //на сколько дней
        //TODO нужно доделать
        this.dateEnd = addDays(dateTook, toDays);
        this.debtTrue = debtTrue; //имеется задолженность
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public Book getBook() {
        return book;
    }

    public Boolean getDebtTrue() {
        return debtTrue;
    }

    @Override
    public void takeBook(Book book, int toDays) {  //брать книгу
        if (book.status == Book.statusBook.RECEIVED && !book.giveOut) { //книга в наличии (получена) и не выдана
            book.giveOut = true; //книга выдана
            this.book = book; // пользователь книгу взял
            this.dateTook = new Date(); // когда взял
            this.toDays = toDays; // на кол-во дней
            this.dateEnd = addDays(dateTook, toDays); //дата возврата
            this.debtTrue = true; //появилась задолженность

        } else if (book.isRescarded()) {
            System.out.println("Книга списана, нет в наличии.");
        } else if (book.status == Book.statusBook.ORDER || book.status == Book.statusBook.PAID) {
            System.out.printf("Книга скоро будет (в заказе). Планируемая дата поставки %s.\n", book.dateRegistered);
        } else if (book.status == Book.statusBook.OTHER) {
            System.out.print("Статус книги не ясен.\n");
        } else if (book.giveOut) {
            System.out.printf("Книга %s - %s выдана, ждите.\n", book.name, book.author);
        }

    }

    @Override
    public void returnBook(Book book) { // пользователь книгу отдал
        this.book = null;
        book.setGiveOut(false); //книга выдана
        this.dateTook = null; // когда взял
        this.toDays = 0; // на кол-во дней
        this.dateEnd = null; //дата возврата
        this.debtTrue = false; //появилась задолженность
    }

}
