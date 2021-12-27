package day9.Polymorphism;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:05
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        // Как настоящие программисты мы имеем в виду, что исчисление начинается с 0
        int slot;
        while (true) {
            System.out.format("У игрока %d слотов с оружием,"
                    + " введите номер, чтобы выстрелить,"
                    + " -1 чтобы выйти%n", player.getSlotsCount());

            try {
                slot = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Вводите нолько цыфры! Повторите еще раз.");
                break;
            }
            if ((slot == -1)) {
                System.out.println("Game over!");
                break;
            }
            System.out.println("Слот " + slot);
            player.shotWithWeapon(slot);
        }
    }
}
