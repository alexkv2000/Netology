package day10.Librarry;

import day10.Librarry.user.UserAdministrator;
import day10.Librarry.user.UserLibrarian;
import day10.Librarry.user.UserProvaider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author KAU
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Book[] books = {
                new Book("Унесенные ветром", "Маргарет Митчелл", 450, new SimpleDateFormat("dd.MM.yyyy").parse("28.12.2016")),
                new Book("Сердца трех", "Джек Лондон", 850, new SimpleDateFormat("dd.MM.yyyy").parse("10.04.2004")),
                new Book("Понедельник начинается с субботы", "Братья Стругацкие", 738, null),
                new Book("Унесенные ветром", "Маргарет Митчелл", 450, new SimpleDateFormat("dd.MM.yyyy").parse("01.12.2020"))
        };
        //userExample();
        //provaiderExample();
        //LibrariExample();
        AdminExample(books);
    }

    private static void AdminExample(Book[] books) throws ParseException {
        UserAdministrator userAdministrator = new UserAdministrator("Admin", books[2], new Date(), 8, false);
        User userPetr = new User("Petr Petrivich", books[0], new SimpleDateFormat("dd.MM.yyyy").parse("10.04.2021"), 4, true);

        userAdministrator.giveOutBook(userPetr, books[1], 7); //проверка на задолженность при выдачи книги. не выдавать.

        showTakenBook(userAdministrator);
        showTakenBook(userPetr);

        System.out.println("проверка на задолженность");
        userAdministrator.notification(userPetr);
        userAdministrator.notification(userAdministrator);
        System.out.println();

        System.out.println("проверка после возврата книги");
        userAdministrator.returnBook(books[2]);
        userAdministrator.notification(userAdministrator);

        System.out.println("поиск по названию или автору книги");
        userAdministrator.findBook("Унесенные ветром", books);
        userAdministrator.findBook("Братья Стругацкие", books);
        userAdministrator.findBook("Джек Лондон", books);

    }


    private static void LibrariExample() throws ParseException {
        Book bookUV = new Book("Унесенные ветром", "Маргарет Митчелл", 450, new SimpleDateFormat("dd.MM.yyyy").parse("28.12.2016"));
        Book bookHT = new Book("Сердца трех", "Джек Лондон", 850, new SimpleDateFormat("dd.MM.yyyy").parse("10.04.2004"));
        Book bookS = new Book("Понедельник начинается с субботы", "Братья Стругацкие", 738, null);
        bookUV.toString();
        bookHT.toString();
        bookS.toString();//если нет регистрации по статус OTHER
        System.out.println();
        User userPetr = new User("Petr Petrivich", bookUV, new Date(), 30, false);

        System.out.println("Новый заказ делает Библиотекарь");

        Librarian librarian = new UserLibrarian("Alexey Alexeevich777", bookHT, new Date(), 7, false);
        librarian.orderNewBook(bookS); //сделан заказ новой книги Стругацких
        librarian.toString(); //статус книги у библиотекаря - ORDER
        bookS.toString(); //статус книги с библиотеке не меняется
        System.out.println();


        System.out.println("Новый пользователь Библиотекарь");
        User userLib = new UserLibrarian("Alexey Alexeevich", bookHT, new Date(), 7, false);
        System.out.println("берет книгу на 7 дней");
        showTakenBook(userLib);

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
        userProvaider.takeBook(bookUV, 12);
        System.out.println(userProvaider); //книга выдана giveOut = "true"
        userProvaider.takeBook(bookUV, 12); //книга уже выдана
        userProvaider.returnBook(bookUV);
        System.out.println(userProvaider);
    }

    private static void userExample() {
        //System.out.println(addSDay("2021-12-28", 5));

        Book bookUV = new Book("Унесенные ветром", "Маргарет Митчелл", 450, new Date(160833600000L));
        User userAlexey = new User();
        User userPetr = new User("Petr Petrivich", bookUV, new Date(), 30, true);
        User userIvan = new User();
        userIvan.setFio("Ivan Ivanov");

        showTakenBook(userPetr);
        userIvan.takeBook(bookUV, 30);//ошибка при повторной выдачи
        showTakenBook(userIvan);

        userPetr.returnBook(bookUV);//возврат книги
        showTakenBook(userPetr);

        System.out.println(bookUV);
        bookUV.setRescarded();//списание книги

        userIvan.takeBook(bookUV, 30);
        showTakenBook(userIvan);

        System.out.println(bookUV);
        System.out.println(bookUV);

    }


    private static void showTakenBook(User user) {
        System.out.printf("Книгу {%s - %s} взял - %s \n", (user.book != null ? user.book.name : "No Name"), (user.book != null ? user.book.author : "No autor"), user.fio);
        System.out.println("=========================");
    }
}
