package KAU.day7.Polymorphism.weapon;

import KAU.day7.Polymorphism.Weapon;

public class RPG implements Weapon {
    String name;

    public RPG() {
        name = "РПГ";
    }

    @Override
    public void shot() {
        System.out.printf("Стреляем из %s - %s %n",name,"Бум");
    }
}
