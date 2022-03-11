package day14.Candidate;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) throws IOException {
        final String ANSI_SCARLET = "\u001b[31m";
        final String ANSI_RESET = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);
        TreeSet<Candidate> treeSet = new TreeSet<>(new namecomp());
        TreeSet<Candidate> treeSetReversed = new TreeSet<>(new namecomp().reversed());
        FileInputStream fileInputStream = new FileInputStream("src//day14//Candidate//listCandidate.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 600);
        StringBuilder sTemp = new StringBuilder();

        while (bufferedInputStream.available() > 0) {
            int charForStreem = bufferedInputStream.read();

            if (charForStreem == '\n' || bufferedInputStream.available() == 0) {
                String[] paramCandidate = sTemp.toString().split(",");

                String sAge = paramCandidate[2].replaceAll(" ", "");
                int iRelevance = Integer.parseInt(paramCandidate[3].replaceAll(" ", ""));
                int iRating = Integer.parseInt(paramCandidate[4].replaceAll(" ", ""));
                addCandidat(paramCandidate[0], paramCandidate[1], sAge, iRelevance, iRating, treeSet, treeSetReversed);
                sTemp = new StringBuilder();
            } else if (charForStreem != '\r') {
                sTemp.append((char) charForStreem);
            }
        }
        bufferedInputStream.close();
        fileInputStream.close();

//        addCandidat("Maksim Maksimovich Maksimov", "Men", "38", 4, 3, treeSet);
//        addCandidat("Maksim Maksimovich Maksimov", "Men", "38", 4, 3, treeSet);
//        addCandidat("Sergey Sergeevich Sergeev", "Men", "45", 3, 5, treeSet);
//        addCandidat("Ury Urevich Urev", "Men", "22", 5, 1, treeSet);
//        addCandidat("Ivan Ivanovich Ivanov", "Men", "22", 5, 2, treeSet);
//        addCandidat("Fedor Igorevich Ivanovich", "Men", "38", 5, 5, treeSet);
//        addCandidat("Alexey Igorevich Igorev", "Men", "38", 5, 5, treeSet);
//        addCandidat("Igor Urevich Igorev", "Men", "38", 2, 3, treeSet);
//        addCandidat("Eugene Igorevich Eugenevich", "Men", "38", 5, 4, treeSet);
//        addCandidat("Igor Sergeevich Igorev", "Men", "38", 2, 5, treeSet);
//        addCandidat("Igor Igorevich Igorev", "Men", "38", 2, 4, treeSet);
//        addCandidat("Alexey Alexeevich Alexeev", "Men", "37", 5, 5, treeSet);
//        addCandidat("Alena Alexeevna Nikisha", "Woman", "27", 4, 5, treeSet);
//        addCandidat("Elena Eugenevna Dubkova", "Woman", "25", 5, 5, treeSet);
//        addCandidat("Venera Maksimovna Esenina", "Woman", "29", 5, 4, treeSet);
//        addCandidat("Nataliya Vyacheslavovna Nam", "Woman", "32", 4, 3, treeSet);

        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("Сортировать по Relevance & rating (1) revers (2) Exit (0): ");
                String menuChoice = scanner.nextLine();
                switch (Integer.parseInt(menuChoice)) {
                    case 0: {
                        flag = true;
                        System.out.println("Завершение работы");
                        break;
                    }
                    case 1: {
                        System.out.println("             ФИО            ,  Пол , Резюме , Собеседование");
                        showTerminal(treeSet);
                        break;
                    }
                    case 2: {
                        System.out.println("             ФИО            ,  Пол , Резюме , Собеседование");
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

    private static void addCandidat(String fio, String sex, String age, int relevance, int rating, TreeSet<Candidate> treeSet, TreeSet<Candidate> treeSetReversed) {
        treeSet.add(new Candidate(fio, sex, age, relevance, rating));
        treeSetReversed.add(new Candidate(fio, sex, age, relevance, rating));
    }
}

