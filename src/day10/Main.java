package day10;

import java.util.Date;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 23:38
 */
public class Main {
    public static void main(String[] args) {
        //userExample();

        //создаем поставщика
        provaiderExample();


    }

    private static void provaiderExample() {
        Book bookUV = new Book("Унесенные ветром", "Маргарет Митчелл", 450, null);
        UserProvaider userProvaider = new UserProvaider(bookUV);
        System.out.println(userProvaider);

        //книги поставщика "оплачено"
        userProvaider.setPayDelivery(bookUV);
        System.out.println(userProvaider);

        // доставка книги: статус - RECEIVED и delivery = true
        userProvaider.providerBook(bookUV);
        System.out.println(userProvaider);
    }

    private static void userExample() {
        //System.out.println(addSDay("2021-12-28", 5));

        Book bookUV = new Book("Унесенные ветром", "Маргарет Митчелл", 450, new Date(160833600000L));

        User userAlexey = new User("Alexey Alexeevich");
        Book bookStrugackih = userAlexey.orderNewBook(new Book("Понедельник начинается с субботы", "Братья Стругацкие", 637, new Date()), userAlexey);
        System.out.println(bookStrugackih.toString());

        User userPetr = new User("Petr Petrivich", bookUV, new Date(), 30, true);
        User userIvan = new User("Ivan Ivanovich");
        showTakenBook(userPetr, bookUV);

        userIvan.takeBook(bookUV, 30);
        System.out.println(userIvan.toString());
        showTakenBook(userIvan, bookUV);

        userIvan.returnBook(bookUV);
        showTakenBook(userIvan, bookUV);
        ShowStatusBook(bookUV);

        bookUV.setRescarded();
        userIvan.takeBook(bookUV, 30);
        System.out.println(userIvan.toString());
        System.out.println(bookUV.toString());
        System.out.println(bookStrugackih.toString());
        ShowStatusBook(bookUV);
        showTakenBook(userAlexey, bookStrugackih);

        userAlexey.takeBook(bookStrugackih, 20);
        System.out.println("======================");
        bookStrugackih.setStatus(Book.statusBook.RECEIVED);
        System.out.println(userAlexey.toString());
        System.out.println(bookStrugackih.toString());

        userAlexey.takeBook(bookStrugackih, 20);
        bookStrugackih.setUserOut(userAlexey);
        System.out.println(userAlexey.toString());
        System.out.println(bookStrugackih.toString());
    }

    private static void ShowStatusBook(Book book) {
        String str;
            str = "Book{" +
                    "name='" + book.name + '\'' +
                    ", author='" + book.author + '\'' +
                    ", countPage=" + book.countPage +
                    ", status=" + book.status +
                    ", dateRegistered=" + book.dateRegistered +
                    ", giveOut=" + book.giveOut +
                    '}';
        System.out.println(str);
    }

    private static void showTakenBook(User user, Book book) {
        System.out.printf("Книгу {%s - %s} взял - %s \n", book.name, book.author, user.getFio());
        System.out.println("=========================");
    }
}