package KAU.day7.Polymorphism.weapon;

import KAU.day7.Polymorphism.Weapon;

public class Pistol implements Weapon {
    String name;

    public Pistol() {
        name = "Пистолет";
    }

    @Override
    public void shot() {
        System.out.printf("Стреляем из %s - %s %n",name,"Бах-Бах");
    }
}
