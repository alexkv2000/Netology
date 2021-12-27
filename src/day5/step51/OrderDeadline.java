package day5.step51;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-21 12:50
 */
public class OrderDeadline {
    public static void separate(String sep, int countSep) {
        System.out.println(sep.repeat(countSep));
    }

    protected static void optionTwo(String order) {
        System.out.println("второй вариант при условии: первое значение - всегда начало задачи, второе значение - конец.");
        separate("-", 50);
        //System.out.println(order.toCharArray());

        int[] n = new int[2];
        int i = 0;
        for (String ss : (order.split(" "))) {
            if (ss.matches("[-+]?\\d+")) {
                n[i++] = Integer.parseInt(ss);
            }
        }
        System.out.println("Задача начнется в " + n[0] + "ч.");
        System.out.println("     завершится в " + n[1] + "ч.");
        if (((n[1] - n[0]) > 0) && n[0] <= 24 && n[1] <= 24 ) {
            System.out.println("На задачу потребуется: " + (n[1] - n[0]) + "ч.");
        } else {
            System.out.println("Формат введенных данных неверный");
        }
    }

    protected static void optionOne(String order) {
        int startPos = selectNumberFromString(order, "начинается в");
        int endTime = selectNumberFromString(order, "заканчивается в");

        if (((endTime - startPos) > 0) && endTime <=24 && startPos <= 24) {
            System.out.println("На задачу потребуется: " + (endTime - startPos) + " ч.");
        } else {
            System.out.println("Формат введенных данных неверный");
        }
    }

    private static int selectNumberFromString(String order, String substring) {
        int startPos = order.indexOf(substring);
        int lenSub = substring.length();

        String startTimeString = order.substring(startPos + lenSub, startPos + (lenSub + 3)).trim();
        int executionTime = Integer.parseInt(startTimeString); // преобразование строки в целое
        return executionTime;
    }
}
