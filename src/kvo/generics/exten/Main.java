package kvo.generics.exten;

import kvo.generics.exten.fruits.*;

public class Main {
    public static void main(String a[]) {
        Box<String, Banana> bananaBox = new Box<>("banana", new Banana());
        bananaBox.getObj().printClass();

        Box<String, Apple> appleBox = new Box<>("apple", new Apple());
        appleBox.getObj().printClass();

        Box<String, Fruit> fruitBox = new Box<>("fruit", new Fruit());
        fruitBox.getObj().printClass();

        Box<String, Cabbage> cabbageBox = new Box<>("cabbage", new Cabbage());
        cabbageBox.getObj().printClass();
    }
}
