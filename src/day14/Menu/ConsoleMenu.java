package day14.Menu;

import java.util.ArrayList;

public class ConsoleMenu {
    public ArrayList<Menu> nameMenu = new ArrayList<>();
    int count = 0;

    public ConsoleMenu() {
    }

    public void setNameMenu(Menu menu) {
        this.nameMenu.add(menu);
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public void listNameMenu() {
        for (Menu str : nameMenu) {
            System.out.println(str.numeric + str.menuItem);
        }
    }

    public int getMenuNumber(int number) {
        String str = nameMenu.get(number).numeric.replaceAll("\\D+", "");
        return Integer.parseInt(str);
    }

    public String getMenuCommand(int number) {
        String str = nameMenu.get(number).command.strip();
        return str;
    }

    @Override
    public String toString() {
        return nameMenu + "";
    }
}
