package day13.SudentsDirectory;

import org.jetbrains.annotations.NotNull;

import java.util.*;

import static day13.SudentsDirectory.ConsolColor.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        HashSet<Student> hashSet = new HashSet<>();
        eConsole("Введите информацию о студенте: 'ФИО, номер группы, номер студенческого билета'", ANSI_RESET);

        try {
            String student = scanner.nextLine();
            setNewStudent(student, hashSet);
        } catch (Exception e) {
            eConsole("Данные введены некорректно.", ANSI_SCARLET);
        }


        while (true) {
            try {
                System.out.println("Введите информацию о студенте (для завершения работы программы введите 'end')");
                String student = scanner.nextLine();
                if ((student.toLowerCase().equals("утв") || (student.toLowerCase().equals("end")))) {
                    System.out.println("\nСписок студентов:");
                    listStudents(hashSet);
                    break;
                } else {
                    setNewStudent(student, hashSet);
                }
            } catch (Exception e) {
                eConsole("Данные введены некорректно.", ANSI_SCARLET);
            }
        }

    }

    private static void eConsole(String eMessage, String color) {
        System.out.println(color + eMessage + ANSI_RESET);
    }

    @NotNull
    private static HashSet<Student> setNewStudent(String student, HashSet<Student> hashSet) throws Exception {
        //"Иванов Петр Николаевич, 1243-Б, 31231343";
        //"Петрова Татьяна Михайловна, 1243-Б, 43221343";
        String[] std = student.split(",");
        if (containsHasID(std[2], hashSet)) {
            hashSet.add((Student) new Student().addStudent(std[0], std[1], std[2]));
            return hashSet;
        }
        return hashSet;
    }

    private static boolean containsHasID(String studentId, HashSet<Student> hashSet) {
        for (Object li : hashSet) {
            if (String.valueOf(li).contains(studentId)) {
                System.out.print(ANSI_SCARLET + "Ошибка! Контакт уже есть в системе: \n" + li + ANSI_RESET + "\n\n");
                return false;
            }
        }
        return true;
    }

    private static void listStudents(HashSet<Student> hashSet) {
        Iterator<Student> i = hashSet.iterator();
        int num = 1;
        while (i.hasNext()) {
            System.out.println(num++ + ".)" + i.next());
        }
    }
}