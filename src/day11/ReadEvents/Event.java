package day11.ReadEvents;

public abstract class Event {
    String title;//название
    int releaseYear; //год выпуска
    int age; //ограничение по возрасту

    @Override
    public String toString() {
        return "событие {" +
                "Название='" + title + '\'' +
                ", год выпуска='" + releaseYear + '\'' +
                ", ограничение возраста=" + age +
                '}';
    }
}
