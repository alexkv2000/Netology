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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("\n%-28s, %7s, %7s", fio, relevance, rating);
    }
}
