package day6.OnlineReads;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-22 13:07
 */
public class Author {
    public String author;

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Author(String author) {
        this.author = author;
    }
    public Author() {
    }
    //TODO: не понял как переопределить toString() есл он уже переопределен в классе Books
    public String showAuthor() {
        System.out.printf("Автор {" + this.author + "} %n --------------------------- %n");
        return " ";
    }

    @Override
    public String toString() {
        System.out.printf("Автор {" + this.author + "} %n --------------------------- %n");
        return " ";
    }
}
