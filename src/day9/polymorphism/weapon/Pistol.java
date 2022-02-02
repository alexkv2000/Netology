package day9.polymorphism.weapon;

import day9.polymorphism.Weapon;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:08
 */

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