package day9.Polymorphism.weapon;

import day9.Polymorphism.Weapon;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:09
 */
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
