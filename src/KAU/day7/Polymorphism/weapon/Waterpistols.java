package KAU.day7.Polymorphism.weapon;

import KAU.day7.Polymorphism.Weapon;

public class Waterpistols implements Weapon {
    String name;

    public Waterpistols() {
        name = "Водяной пистолет";
    }

    @Override
    public void shot() {
        System.out.printf("Стреляем из %s - %s %n",name,"Псс-Псс");
    }
}
