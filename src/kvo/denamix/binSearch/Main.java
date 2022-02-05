package kvo.denamix.binSearch;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    static final char CHARSTART = 'Ч';
    static final char CHARFINISH = 'Щ';
    static final char CHARSPINE = '*';
    static final char COMEB = 'N';
    static final char STEP = '+';

    static final Cell finish = new Cell(0, 0);
    static Cell start;
    public static void main(String[] args) {

        char[][] template = new char[][]{
                {'.', '.', '.', '*', '*', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '*', '.', '*', '*', '.', '.'},
                {'.', '.', '.', '*', '.', '*', '.', '.', '.', '*'},
                {'.', '*', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '*', '.', '.', '.'},
                {'.', '.', '*', '.', '.', '*', '.', '.', '.', '.'},
                {'.', '.', '.', '*', '.', '.', '*', '*', '*', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '*', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '*', '.', '.'},
                {'.', '.', '.', '.', '.', '*', '*', '.', '.', '.'}
        };
        char[][] pathArray = new char[template.length][template.length];
        start = new Cell(template.length, template.length);
        Cell xy = new Cell(start.getXp() - 1, start.getYp() - 1);

        pathArray[xy.getXp()][xy.getYp()] = CHARSTART;
        while (xy.getXp() != finish.getXp() || xy.getYp() != finish.getYp()) {
            if (stepLeftPossible(new Cell(xy.getXp(), xy.getYp()), template, pathArray)) { // лево свободно
                move(new Cell(xy.getXp(), xy.getYp() - 1), pathArray); // добавляем координаты в paintArray[][]
                xy.setYp(xy.getYp() - 1);
            } else if (stepUpPossible(new Cell(xy.getXp(), xy.getYp()), template, pathArray)) { //вврех свободно
                move(new Cell(xy.getXp() - 1, xy.getYp()), pathArray);
                xy.setXp(xy.getXp() - 1);
            } else {
                pathArray[xy.getXp()][xy.getYp()] = COMEB;
                Cell cell = cameBack(new Cell(xy.getXp(), xy.getYp()), pathArray); //ищем STEP = 'P' и переводим координаты на него
                if (cell != null) {
                    xy.setXp(cell.getXp());
                    xy.setYp(cell.getYp());
                } else {
                    System.out.println("путь не найден");
                    break;
                }
            }
        }
        consoleArray(template, pathArray, false);
        System.out.println();
        consoleArray(template, pathArray, true);
    }

    private static boolean stepUpPossible(Cell cell, char[][] template, char[][] paintArray) {
        return (cell.getXp() - 1 >= 0 && template[cell.getXp() - 1][cell.getYp()] != CHARSPINE) &&
                (paintArray[cell.getXp() - 1][cell.getYp()] != COMEB);
    }

    private static boolean stepLeftPossible(Cell cell, char[][] template, char[][] paintArray) {
        return (cell.getYp() - 1 >= 0 && template[cell.getXp()][cell.getYp() - 1] != CHARSPINE) &&
                (paintArray[cell.getXp()][cell.getYp() - 1] != COMEB);
    }

    private static void move(Cell cell, char[][] paintArray) { // добавляем координаты в paintArray[][]
        paintArray[cell.getXp()][cell.getYp()] = Main.STEP;
    }

    private static Cell cameBack(Cell cell, char[][] paintArray) { //из указанной координаты ищем STEP = 'P' / CHARSTART = 'S'
        if ((cell.getXp() + 1 < paintArray.length && paintArray[cell.getXp() + 1][cell.getYp()] == Main.STEP)
                || (cell.getXp() + 1 < paintArray.length && paintArray[cell.getXp() + 1][cell.getYp()] == CHARSTART)) {
            cell.setXp(cell.getXp() + 1);
        } else if ((cell.getYp() + 1 < paintArray.length && paintArray[cell.getXp()][cell.getYp() + 1] == Main.STEP)
                || (cell.getYp() + 1 < paintArray.length && paintArray[cell.getXp()][cell.getYp() + 1] == CHARSTART)) {
            cell.setYp(cell.getYp() + 1);
        } else {
            return null;
        }
        return new Cell(cell.getXp(), cell.getYp());
    }

    private static void consoleArray(char[][] mapArray, char[][] pathArray, boolean onlyPath) {
        pathArray[finish.getXp()][finish.getYp()] = mapArray[finish.getXp()][finish.getYp()] = CHARFINISH;
        pathArray[start.getXp()-1][start.getYp()-1] = mapArray[start.getXp()-1][start.getYp()-1] = CHARSTART;
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray.length; j++) {
                if (onlyPath) {
                    System.out.print(pathArray[i][j] == STEP
                            || pathArray[i][j] == CHARSTART
                            || pathArray[i][j] == CHARFINISH ? ANSI_GREEN + pathArray[i][j] + ANSI_RESET + " " : mapArray[i][j] + " ");
                } else {
                    System.out.print((pathArray[i][j] == STEP
                            || pathArray[i][j] == COMEB
                            || pathArray[i][j] == CHARSTART
                            || pathArray[i][j] == CHARFINISH) ? ANSI_GREEN + pathArray[i][j] + ANSI_RESET + " " : mapArray[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static class Cell {
        int xp;
        int yp;

        public Cell(int xp, int yp) {
            this.xp = xp;
            this.yp = yp;
        }

        public int getXp() {
            return xp;
        }

        public int getYp() {
            return yp;
        }

        public void setXp(int xp) {
            this.xp = xp;
        }

        public void setYp(int yp) {
            this.yp = yp;
        }
    }
}
