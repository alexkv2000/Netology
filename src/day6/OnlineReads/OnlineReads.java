package day6.OnlineReads;

import java.util.ArrayList;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-22 11:26
 */
public class OnlineReads {


    public static void main(String[] args) throws Exception {
        ArrayList<Books> booksArrayList = new ArrayList<>();

        booksArrayList.add(new Books("Управление подчненными", new Author("Фридман"), 300, "Книга для руководителей"));
        booksArrayList.add(new Books("Как выработать уверенность в себе и влиять на людей ..", new Author("Карнеги Д."), 650, "Книга для руководителей"));
        booksArrayList.add(new Books("Пикник на обочине", new Author("Стругацких Аркадий и Борис"), 500, "Фантастика"));
        booksArrayList.add(new Books("Мессия Дюны", new Author("Фрэнк Герберт"), 470, "Фантастика"));
        for (Books book : booksArrayList) {
            book.toString();
        }

        User user1 = new User("Иван", "Иванов", "ivan@mail.ru");
        User user2 = new User("Петр", "Петров", "petr@mail.ru");
        User user3 = new User("Алексей", "Алексеев", "alex@mail.ru");
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n", User.getTotalOnline());
        user1.close();
        user2.close();
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n", User.getTotalOnline());
        user1.connect();
        System.out.println("------------------------------");
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n", User.getTotalOnline());
        user1.toString();
        user2.toString();
        user3.toString();
        System.out.println("------------------------------");

        String giveBook = user1.bookReadUserON(booksArrayList.get(3));
        System.out.printf("%s %s читает книгу : %s %n", user1.getName(), user1.getSurname(), giveBook);
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n", User.getTotalOnline());
        user1.connect();
        user2.connect();
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n", User.getTotalOnline());
        //--------
        System.out.printf("%s читает - %s%n", user1.name + " " + user1.surname, user1.getRead());
        System.out.printf("%s читает - %s%n", user2.name + " " + user2.surname, user2.getRead());
        System.out.printf("%s читает - %s%n", user3.name + " " + user3.surname, user3.getRead());
    }

}
