package day6.OnlineReads;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-22 15:52
 */
public class User {
    protected String email;
    protected String name;
    protected String surname;
    protected boolean online;
    public Books read;

    static public int totalOnline = 0;

    public String bookReadUserON(Books book) {
        if (!book.isStatusBook()) {
            book.bookRead(this, book); //меняем статус и запоминам кто взял книгу в Books
            this.read = book;
            return read.getNameBook();
        }
        return null;
    }

    public String bookReadUserOFF(User user, Books book) {
        if (book.isStatusBook()) {
            book.bookRead(user, book); //меняем статус и запоминам кто отдал книгу в Books
            this.read = null;
        }
        return null;
    }

    @Override
    public String toString() {
        System.out.printf("%-12s %-12s {%-1s} - статус %8s ", name, surname, email, online ? "OnLine" : "OFFLine");
        System.out.printf("%s \n", this.read != null ? this.read.getNameBook() : "");
        return "";
    }

    public User(String name, String surname, String email) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.online = true;
        this.read = null;
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

    public String getRead() {
        String str = "";
        if (this.read != null) {
            str = read.getNameBook();
        }
        return str;
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
