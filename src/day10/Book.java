package day10;

import java.util.Date;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 23:41
 */
public class Book {
    String name;
    String author;
    int countPage;
    statusBook status;
    Date dateRegistered; // дата поступления книги
    Boolean giveOut; //книга выдана

    public enum statusBook {
        ORDER, //заказ
        PAID, //оплачено
        RECEIVED, //получено
        DISCARDED, //списано,
        OTHER, //другое
    }

    public void setRescarded() {
        this.status = statusBook.DISCARDED;
        this.dateRegistered = new Date(); // дата поступления/списания книги
        this.giveOut = false; //книга выдана
    }

    public boolean isRescarded() { //проверка на списания книги
        return this.status.equals(statusBook.DISCARDED) ? true : false;
    }

    public void setStatus(statusBook status) { //новый статус если НЕ списана
        if (!isRescarded()) {
            this.status = status;
        }
    }

    public void setUserOut(User userOut) { //кому выдана
        if (status.equals(statusBook.DISCARDED)) {
            System.out.println("Книга списана, ее нельзя выдать.");
        } else {
            this.giveOut = true;
            System.out.printf("Книга выдана: %s.", userOut.getFio());
        }
    }

    public void setUserIn(User userIn) { // возврат книги
        this.giveOut = false;
    }

    @Override
    public String toString() {
        String str;

        str = "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", countPage=" + countPage +
                ", status=" + status +
                ", giveOut=" + giveOut +
                '}';
        return str;
    }


    public Book(final String name, final String author, int countPage, Date dateRegistered) {
        this.name = name;
        this.author = author;
        this.countPage = countPage > 0 ? countPage : 0;
        if (dateRegistered == null) {
            this.dateRegistered = new Date();
        } else {
            this.dateRegistered = dateRegistered;
        }
        this.status = statusBook.RECEIVED;
    }
}
