package day5.step51;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-22 12:50
 */
public class GenerateNumBooks {
    protected static int id;

    public static int getId() {
        id +=1;
        return id;
    }

    public GenerateNumBooks() {
        id = 0;
    }
}
