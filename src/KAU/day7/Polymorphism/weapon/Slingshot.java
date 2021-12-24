package KAU.day7.Polymorphism.weapon;

import KAU.day7.Polymorphism.Weapon;

public class Slingshot implements Weapon {
    String name;

    public Slingshot() {
        name = "Рогатка ядерная";
    }

    @Override
    public void shot() {
        System.out.printf("Стреляем из %s - %s %n",name,"Шмяк");
    }
}
