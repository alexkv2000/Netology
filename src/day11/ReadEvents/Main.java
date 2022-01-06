package day11.ReadEvents;

public class Main extends RuntimeException {
    public static void main(String[] args) {
        for (Event event : getMovies()) {
            validEvent(event);
        }
        for (Event event : getTheatres()) {
            validEvent(event);
        }
        System.out.println("Все события корректны");
    }

    public static Movie[] getMovies() {
        return new Movie[]{
                new Movie("Начало1", 2010, 6),
                new Movie("Начало2", 2011, 12),
                new Movie("Начало3", 2012, 16),
                new Movie("Начало4", 2013, 16),
                new Movie("Начало5", 2014, 6)
        };
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("Анна Каренина1", 2010, 6),
                new Theatre("Анна Каренина2", 2012, 6),
                new Theatre("Анна Каренина3", 2015, 12),
                new Theatre("Анна Каренина4", 2017, 16)
        };
    }

    public static void validEvent(Event event) {
        if ((event.releaseYear == 0) || (event.title.equals(null)) || (event.age == 0)) {
            throw new RuntimeException("Не корректные данные " + event);
        }
    }
}
