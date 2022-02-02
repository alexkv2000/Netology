package day9.polymorphism.weapon;

import day9.polymorphism.Weapon;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:09
 */

public class Rpg implements Weapon {
    String name;

    public Rpg() {
        name = "РПГ";
    }

    @Override
    public void shot() {
        System.out.printf("Стреляем из %s - %s %n", name, "Бум");
    }
}
