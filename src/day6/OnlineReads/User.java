package day6.OnlineReads;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-22 15:52
 */
public class User extends Books {
    protected String email;
    protected String name;
    protected String surname;
    protected boolean online; // статус Online || OFFLine пользователя
    public String read; // какую книгу читает пользователь

    static public int totalOnline = 0; // кол-во пользователей OnLine

    public String bookReadUserON(Books book) {
        if (!book.isStatusBook()) {
            bookRead(User.class, book); //меняем статус и запоминам кто взял книгу в Books
            read = book.getNameBook();
            return read;
        }
        return null;
    }

    public String bookReadUserOFF(User user, Books book) {
        if (book.isStatusBook()) {
            bookRead(User.class, book); //меняем статус и запоминам кто отдал книгу в Books
            read = "";
        }
        return null;
    }

    @Override
    public String toString() {
        System.out.printf("%-12s %-12s {%-1s} - статус %8s ", name, surname, email, online ? "OnLine" : "OFFLine");
        System.out.printf("%s %n", (read.length() > 0) ? ("читает: " + read) : "");
        return "";
    }

    public User(String name, String surname, String email) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.online = true;
        this.read = "";
        totalOnline += 1;
    }

    public static int getTotalOnline() {
        return totalOnline;
    }

    private static void setTotalOnline() {
        User.totalOnline += 1;
    }

    private void disconnect() {
        if (online) {
            online = false;
            User.totalOnline -= 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { //смена e-mail
        this.email = email;
    }

    public void close() {
        disconnect();
        System.out.printf("%s %s вышел из читалки...%n", name, surname);
    }

    public void connect() {
        if (!online) {
            online = true;
            this.totalOnline += 1;
            System.out.printf("%s %s вошел в OnLine читалку...%n", name, surname);
        }
    }
}
