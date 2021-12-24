package KAU.day7.Polymorphism.weapon;

import KAU.day7.Polymorphism.Weapon;

public class Automat implements Weapon {
    String name;

    public Automat() {
        name = "Автомат";
    }

    @Override
    public void shot() {
        System.out.printf("Стреляем из %s - %s %n",name,"Тра-та-та");
    }
}
