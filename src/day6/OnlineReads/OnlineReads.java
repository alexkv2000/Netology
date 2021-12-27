package day6.OnlineReads;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-22 11:26
 */
public class OnlineReads {


    public static void main(String[] args) throws Exception {
        Books books = new Books();
        books.setNameBook("Управление подчненными", "Фридман");
        books.setNameOther(300, "Книга для руководителей");

        Books books2 = new Books();
        books2.setNameBook("Как выработать уверенность в себе и влиять на людей ..", "Карнеги Д.");
        books2.setNameOther(650, "Книга для руководителей");

        Books books3 = new Books();
        books3.setNameBook("Пикник на обочине", "Стругацких Аркадий и Борис");
        books3.setNameOther(500, "Фантастика");
        books.toString();
        books2.toString();
        books3.toString();

        Books books4 = new Books();
        books4.setNameBook("Мессия Дюны", "Фрэнк Герберт");
        books4.setNameOther(470, "Фантастика");
        books4.toString();

        System.out.println(" ==================================");
        int totalOnline;
        User user1 = new User("Иван","Иванов","ivan@mail.ru");
        User user2 = new User("Петр","Петров","petr@mail.ru");
        User user3 = new User("Алексей","Алексеев","alex@mail.ru");
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n",User.getTotalOnline());
        user1.close();
        user2.close();
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n",User.getTotalOnline());
        user1.connect();
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n",User.getTotalOnline());
        user1.toString();
        user2.toString();
        user3.toString();
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n",User.getTotalOnline());

        System.out.printf("%s %s читает книгу : %s %n", user1.getName(), user1.getSurname(), user1.bookReadUserON(books4));
        user1.connect();
        System.out.println(user1.toString());
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n",User.getTotalOnline());
        user2.connect();
        System.out.printf("Кол-во подключений в онлайн-читалке : { %d } %n",User.getTotalOnline());
    }

}
