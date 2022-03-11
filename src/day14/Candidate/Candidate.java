package day14.Candidate;

public class Candidate {
    String fio;
    String sex;
    String age;
    int relevance;
    int rating;

    public Candidate(String fio, String sex, String age, int relevance, int rating) {
        this.fio = fio;
        this.sex = sex;
        this.age = age;
        this.relevance = relevance;
        this.rating = rating;
    }

    public int getRelevance() {
        return relevance;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("\n%-28s, %5s ,%7s, %7s", fio, sex, relevance, rating);
    }
}
