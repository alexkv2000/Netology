package day13.SudentsDirectory;

<<<<<<< HEAD
import org.jetbrains.annotations.NotNull;

import java.util.*;
=======
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
>>>>>>> origin/master

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
<<<<<<< HEAD
        HashSet<Student> hashSet = new HashSet<>();
        System.out.println("Введите информацию о студенте: 'ФИО, номер группы, номер студенческого билета'");
        String student = scanner.nextLine();
        HashSet<Student> stdIi = setNewStudent(student, hashSet);

        while (true) {
            System.out.println("Введите информацию о студенте (для завершения работы программы введите 'end')");
            student = scanner.nextLine();
            if ((student.toLowerCase().equals("end") || (student.toLowerCase().equals("утв")))) {
                System.out.println("\nСписок студентов");
                listStudents(hashSet);
                break;
            } else {
                HashSet<Student> stdIi2 = setNewStudent(student, hashSet);
            }
        }
    }

    @NotNull
    private static HashSet<Student> setNewStudent(String student, HashSet<Student> hashSet) throws Exception {
        //String stdIi = "Иванов Петр Николаевич, 1243-Б, 31231343";
        //String studentTt = "Петрова Татьяна Михайловна, 1243-Б, 43221343";
        String[] std = student.split(",");
        if (getHasID(std[2], hashSet)) {
            hashSet.add((Student) new Student().addStudent(std[0], std[1], std[2]));
            return hashSet;
        }
        return hashSet;
    }

    private static boolean getHasID(String id, HashSet<Student> hashSet) {
        for (Object li : hashSet) {
            if (String.valueOf(li).contains(id)) {
                System.out.printf("Ошибка! Контакт уже есть в системе: \n" + li + "\n\n");
                return false;
            }
        }
        return true;
=======

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
>>>>>>> origin/master
    }

    private static void listStudents(HashSet<Student> hashSet) {
        Iterator i = hashSet.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
