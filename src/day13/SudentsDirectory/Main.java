package day13.SudentsDirectory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        HashSet<Student> hashSet = new HashSet<>();
        System.out.println("Введите информацию о студенте: 'ФИО, номер группы, номер студенческого билета'");
        // String student = scanner.nextLine();
        String studentIvan = "Иванов Петр Николаевич, 1243-Б, 31231343";
        String[] stdIvan = studentIvan.split(",");
        Student studentI = new Student();
        Student std1 = (Student) studentI.addStudent(stdIvan[0], stdIvan[1], stdIvan[2]);
        hashSet.add(std1);
        System.out.println(std1);

        System.out.println("Введите информацию о студенте (для завершения работы программы введите 'end'");
        String studentTanya = "Петрова Татьяна Михайловна, 1243-Б, 43221343";
        String[] stdTanya = studentTanya.split(",");
        Student studentT = new Student();
        Student std2 = (Student) studentT.addStudent(stdTanya[0], stdTanya[1], stdTanya[2]);
        hashSet.add(std2);
        System.out.println(std2);

        System.out.println("\nСписок студентов");
        listStudents(hashSet);
    }

    private static void listStudents(HashSet<Student> hashSet) {
        Iterator i = hashSet.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
