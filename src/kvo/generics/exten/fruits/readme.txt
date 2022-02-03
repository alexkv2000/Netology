ошибка происходит в
class Cabbage {
    public void printClass() {
        System.out.println("I am Cabbage");
    }
}

из за того что класс Cabbage не наследуется от Fruit
public class Cabbage extends Fruit {}

после наследования класс бует работать, но лучше указать явное переопределение класса (Fruit).
@Override

итог:
class Cabbage extends Fruit {
    @Override
    public void printClass() {
        System.out.println("I am Cabbage");
    }
}