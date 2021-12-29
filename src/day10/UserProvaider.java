package day10;

import static day10.Book.statusBook.*;

public class UserProvaider implements Provider {
    Book book;
    Boolean delivery; //false - принял заказ поставки ,true - поставил книгу

    public UserProvaider(Book book) {
        book.status = ORDER;
        this.book = book; // статус - "заказ"
        delivery = false; //принял заказ поставки
    }

    public void setPayDelivery(Book book) {//статус - "получено"
        book.status = PAID;
        this.book.status = book.status.PAID;
    }

    public boolean isDelivery() {
        return this.delivery;
    }

    @Override
    public void providerBook(Book book) { // доставка книги
        book.status = RECEIVED;
        this.book.status = RECEIVED;
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
