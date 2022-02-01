package day14.Menu;

public class Menu {
    String numeric;
    String menuItem;
    String command;

    public Menu(String num, String item, String command) {
        numeric = num;
        menuItem = item;
        this.command = command;

    }

    public String getNumeric() {
        return numeric;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public String getCommand() {
        return command;
    }
}
