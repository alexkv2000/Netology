package day6.OnlineReads;

import day5.step51.GenerateNumBooks;

import java.util.Date;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-22 11:41
 */
public class Books extends Author {
    private int idBook; // порядковый номер пользователя
    private String dateRegistered; // дата регистрации пользователя
    private String nameBook;
    private int countOfPages;
    private boolean statusBook; // статус книга выдана или нет (для Офлайна - пробы есть или нет в библиотеке)
    private Class<User> userRead;
    private String comments;

    public void bookRead(Class<User> user, Books book) {
        if (book.statusBook) {
            this.statusBook = !this.statusBook;
            userRead = user;
        }
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook, String author) {
        this.idBook = GenerateNumBooks.getId();
        this.dateRegistered = String.valueOf(new Date());
        this.nameBook = nameBook;
        setAuthor(author);
        this.statusBook = false;
    }

    public void setNameOther(int countOfPages, String comments) {
        this.countOfPages = countOfPages;
        this.comments = comments;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    private void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    public boolean isStatusBook() {
        return statusBook;
    }

    public void setStatusBook(boolean statusBook) {
        this.statusBook = statusBook;
    }

    public String getComments() {
        return comments;
    }

    private void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        System.out.printf("[Номер %s] Книга {%s - %s} - %s. %n Дата регистрации: %s %n кол-во страниц : %s %n    комментарий :%s %n ---------------------------------- %n",
                this.idBook, this.nameBook, getAuthor(), (this.statusBook ? "выдан" : "в наличии"), this.dateRegistered, this.countOfPages, this.comments);

        return "";
    }

    public Books() {
        super();
        this.idBook = 0;
        this.dateRegistered = String.valueOf(new Date());
    }
}
