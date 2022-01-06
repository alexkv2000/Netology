package day11.Exception;

import day11.Exception.DefException.AccessDeniedException;
import day11.Exception.DefException.UserNotFoundException;

import java.util.Scanner;

public class Main {

    private final static int AGE = 18;
    private static final String ANSI_RED = "\u001B[41m"; // подцветка разницы доход - расход - красный фон
    private static final String ANSI_RESET = "\u001B[0m"; // конец подцветки - черный фон

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль ");
        String password = scanner.nextLine();

        User validUser = null;
        //Проверить логин и пароль
        try {
            validUser = getUserByLoginAndPassword(login, password);
        } catch (UserNotFoundException e) {
            System.out.println(ANSI_RED + "#Login or password is " + e.getMessage() + "#" + ANSI_RESET + "\n");
        }
        if (validUser != null) {
            try {
                //Вызвать методы валидации пользователя
                validateUser(validUser);
            } catch (AccessDeniedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static User[] getUsers() {
        User user1 = new User("Jhon1", "pass1", 17, "jhon1@gmail.com");
        User user2 = new User("Jhon2", "pass2", 18, "jhon2@gmail.com");
        User user3 = new User("Jhon3", "pass3", 19, "jhon3@gmail.com");
        User user4 = new User("Jhon4", "pass4", 20, "jhon4@gmail.com");
        User user5 = new User("Jhon5", "pass5", 13, "jhon5@gmail.com");
        return new User[]{user1, user2, user3, user4, user5};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if ((user.login.equals(login)) && (user.password.equals(password))) {
                return user;
            }
        }
        throw new UserNotFoundException("not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.age < AGE) {
            throw new AccessDeniedException(ANSI_RED + "#The user is under " + AGE + " years old#" + ANSI_RESET + "\n");
        } else {
            System.out.println("Доступ предоставлен");
        }
    }

}
