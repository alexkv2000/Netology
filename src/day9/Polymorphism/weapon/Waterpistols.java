package day9.Polymorphism.weapon;

import day9.Polymorphism.Weapon;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:10
 */
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
