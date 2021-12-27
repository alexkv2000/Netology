package day5.step51;
/**
 * @author KAU
 * @project Netology
 * @create 2021-12-21 12:50
 */
import java.util.Scanner;
import static day5.step51.OrderDeadline.*;

public class step51 {
    public static void main(String[] args) throws Exception {
        //TODO: найти в этом тексте время (часы) после выражения "начинается в" и "заканчивается в",
        //TODO: рассчитать разницу между ними, и, если результат вычисления будет отрицательным или равным нулю,
        //TODO: — завершить выполнение программы и вывести сообщение: "Формат введенных данных неверный"
        //String Str = "Добавить картинку на главный экран приветствия, задача начинается в 15 и заканчивается в 19";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите задачу:");
        String order = scanner.nextLine();

        separate("#", 50);
        optionOne(order);
        separate("#", 50);
        optionTwo(order);
    }
}
