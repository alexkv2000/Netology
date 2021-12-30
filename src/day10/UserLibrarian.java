package day10;

import java.util.Date;

import static day10.Book.statusBook.ORDER;

public class UserLibrarian extends User implements Librarian {
    Book book;

    public UserLibrarian(String fio, Book book, Date dateTook, int toDays, Boolean debtTrue) {
        super(fio, book, dateTook, toDays, debtTrue);
        this.book = book;
    }

    public UserLibrarian() {

    }


    @Override
    public String toString() {
        return "UserLibrarian{" +
                "book=" + book +
                '}';
    }

    @Override
    public Book orderNewBook(Book book) { //заказать книгу
        Book bookNew = new Book(book.name, book.author, book.countPage, new Date());
        bookNew.setStatus(ORDER); //статус "заказ"
        bookNew.setGiveOut(true);
        this.book = bookNew;
        return this.book;
    }
}
