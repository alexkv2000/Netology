package day10.Librarry;

import java.util.Date;

/**
 * @author KAU
 */
public class Book {
    public String name;
    public String author;
    public int countPage;
    statusBook status;
    Date dateRegistered; // дата поступления книги
    public Boolean giveOut; //книга выдана

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
        return this.status.equals(statusBook.DISCARDED);
    }

    public void setGiveOut(Boolean giveOut) {
        this.giveOut = giveOut;
    }

    public void setStatus(statusBook status) { //новый статус если НЕ списана
        if (!isRescarded()) {
            this.status = status;
        }
    }

    public statusBook getStatus() {
        return status;
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
                "name='" + this.name + '\'' +
                ", author='" + this.author + '\'' +
                ", countPage=" + this.countPage +
                ", status=" + this.status +
                ", dateRegistered=" + this.dateRegistered +
                ", giveOut=" + this.giveOut +
                '}';
        System.out.println(str);
        return str;
    }


    public Book(final String name, final String author, int countPage, Date dateRegistered) {
        this.name = name;
        this.author = author;
        this.giveOut = false;
        this.countPage = Math.max(countPage, 0);
        if (dateRegistered == null) {
            this.status = statusBook.OTHER;
        } else {
            this.status = statusBook.RECEIVED;
            this.dateRegistered = dateRegistered;
        }

    }
}
