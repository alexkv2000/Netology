package day10.Librarry.user;

import day10.Librarry.Book;
import day10.Librarry.Provider;
import day10.Librarry.User;

import static day10.Librarry.Book.statusBook.*;

public class UserProvaider extends User implements Provider {
    Book book;
    Boolean delivery; //false - принял заказ поставки ,true - поставил книгу

    public UserProvaider(Book book) {
        book.setStatus(ORDER);
        book.setGiveOut(false);
        this.book = book; // статус - "заказ"
        this.delivery = false; //принял заказ поставки
    }

    public void setPayDelivery(Book book) {//статус - "получено"
        book.setStatus(PAID);
        book.setGiveOut(false);
        this.book.setStatus(book.getStatus());
        this.book.setGiveOut(false);
    }

    public boolean isDelivery() {
        return this.delivery;
    }

    @Override
    public void providerBook(Book book) { // доставка книги
        book.setStatus(RECEIVED);
        book.setGiveOut(false);
        this.book.setStatus(RECEIVED);
        this.book.setGiveOut(false);
        this.delivery = true;
    }

    @Override
    public String toString() {
        return "UserProvaider{" +
                "book=" + book +
                ", delivery=" + delivery +
                '}';
    }
}
