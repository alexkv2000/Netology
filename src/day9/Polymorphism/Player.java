package day9.Polymorphism;

import day9.Polymorphism.weapon.*;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:06
 */

public class Player {

    // TODO: игра-шутер (Half-Life 3).
    // TODO: У игрока должна быть возможность использовать разные виды оружия,
    // TODO: в будущем в игру могут быть добавлены новые. Необходимо спроектировать иерархию классов,
    // TODO: а также систему слотов для оружия у игрока.
    // TODO:
    // Указываем тип данных Weapon, который будет храниться в "слотах игрока"
    private final Weapon[] weaponSlots; //оружие

    public Player() {
        // Снаряжаем нашего игрока
        weaponSlots = new Weapon[]{
                new Automat(),
                new Pistol(),
                new RPG(),
                new Slingshot(),
                new Waterpistols()
        };
    }

    public int getSlotsCount() {
        // length - позволяет узнать, сколько всего слотов с оружием у игрока
        return weaponSlots.length;
    }

    public void shotWithWeapon(int slot) {
        // TODO проверить на выход за границы
        // если значение slot некорректно, то
        // выйти из метода написав об этом в консоль
        if(slot<weaponSlots.length){
            // Получаем оружие из выбранного слота
            Weapon weapon = weaponSlots[slot];
            // Огонь!
            weapon.shot();
        } else {
            System.out.println("Слот не корректен.");
        }

    }

}
