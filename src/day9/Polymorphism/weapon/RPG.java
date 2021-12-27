package day9.Polymorphism.weapon;

import day9.Polymorphism.Weapon;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:09
 */

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
