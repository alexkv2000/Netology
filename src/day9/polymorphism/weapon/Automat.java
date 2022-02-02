package day9.polymorphism.weapon;

import day9.polymorphism.Weapon;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:07
 */

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
