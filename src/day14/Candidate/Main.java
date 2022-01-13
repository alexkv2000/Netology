package day14.Candidate;

import java.util.SortedSet;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {
        SortedSet<Candidate> treeSet = new TreeSet<>(new namecomp());
        Candidate candidate = new Candidate("Alexey Alexeevich Alexeev", "Men", "27", 4, 5);
        treeSet.add(candidate);
        candidate = new Candidate("Maksim Maksimovich Maksimov", "Men", "38", 4, 3);
        treeSet.add(candidate);
        candidate = new Candidate("Sergey Sergeevich Sergeev", "Men", "45", 3, 5);
        treeSet.add(candidate);
        candidate = new Candidate("Ury Urevich Urev", "Men", "22", 5, 1);
        treeSet.add(candidate);
        candidate = new Candidate("Ivan Ivanovich Ivanov", "Men", "22", 5, 2);
        treeSet.add(candidate);
        candidate = new Candidate("Igor Igorevich Igorev", "Men", "38", 5, 5);
        treeSet.add(candidate);
        //TODO сделать сортировку
        System.out.println("             ФИО            , Резюме , Собеседование");
        System.out.println(treeSet);

    }
}

