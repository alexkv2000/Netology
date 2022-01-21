package day14.Candidate;

import java.util.Scanner;
import java.util.TreeSet;

import static day14.TreeMap.AnsiColor.ANSI_RESET;
import static day14.TreeMap.AnsiColor.ANSI_SCARLET;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Candidate> treeSet = new TreeSet<>(new namecomp());
        TreeSet<Candidate> treeSetReversed = new TreeSet<>(new namecomp().reversed());

        addCandidat("Maksim Maksimovich Maksimov", "Men", "38", 4, 3, treeSet);
        addCandidat("Maksim Maksimovich Maksimov", "Men", "38", 4, 3, treeSet);
        addCandidat("Sergey Sergeevich Sergeev", "Men", "45", 3, 5, treeSet);
        addCandidat("Ury Urevich Urev", "Men", "22", 5, 1, treeSet);
        addCandidat("Ivan Ivanovich Ivanov", "Men", "22", 5, 2, treeSet);
        addCandidat("Fedor Igorevich Ivanovich", "Men", "38", 5, 5, treeSet);
        addCandidat("Alexey Igorevich Igorev", "Men", "38", 5, 5, treeSet);
        addCandidat("Igor Urevich Igorev", "Men", "38", 2, 3, treeSet);
        addCandidat("Eugene Igorevich Eugenevich", "Men", "38", 5, 4, treeSet);
        addCandidat("Igor Sergeevich Igorev", "Men", "38", 2, 5, treeSet);
        addCandidat("Igor Igorevich Igorev", "Men", "38", 2, 4, treeSet);
        addCandidat("Alexey Alexeevich Alexeev", "Men", "37", 5, 5, treeSet);
        addCandidat("Alena Alexeevna Nikisha", "Woman", "27", 4, 5, treeSet);
        addCandidat("Elena Eugenevna Dubkova", "Woman", "25", 5, 5, treeSet);
        addCandidat("Venera Maksimovna Esenina", "Woman", "29", 5, 4, treeSet);
        addCandidat("Nataliya Vyacheslavovna Nam", "Woman", "32", 4, 3, treeSet);

        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("Сортировать по Relevance (1) rating (2) Exit (0): ");
                String menuChoice = scanner.nextLine();
                switch (Integer.valueOf(menuChoice)) {
                    case 0: {
                        flag = true;
                        break;
                    }
                    case 1: {
                        System.out.println("             ФИО            , Резюме , Собеседование");
                        showTerminal(treeSet);
                        break;
                    }
                    case 2: {
                        System.out.println("             ФИО            , Резюме , Собеседование");
                        treeSetReversed.clear();
                        treeSetReversed.addAll(treeSet);
                        showTerminal(treeSetReversed);
                        break;
                    }
                    default: {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                System.out.println(ANSI_SCARLET + "Данные не корректные" + ANSI_RESET);
            }

        }
    }

    private static void showTerminal(TreeSet<Candidate> treeSet) {
        System.out.println(treeSet);
    }

    private static void addCandidat(String fio, String sex, String age, int relevance, int rating, TreeSet<Candidate> treeSet) {
        treeSet.add(new Candidate(fio, sex, age, relevance, rating));
    }
}

