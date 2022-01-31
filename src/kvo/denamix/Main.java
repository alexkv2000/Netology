package kvo.denamix;

public class Main {
    static final char STEP = 'P';
    static final char CHARTRUE = 'X';
    static final char COMEB = 'N';
    static final char CHARSPINE = '*';

    public static void main(String[] args) {

        char[][] template = new char[][]{
                {'-', '-', '-', '-'},
                {'*', '*', '-', '-'},
                {'-', '-', '*', '-'},
                {'-', '-', '-', '-'}
        };
        char[][] paintArray = new char[4][4];
        int finishX = 0;
        int finishY = 0;
        int startX = template.length;
        int startY = template.length;
        int x = startX - 1;
        int y = startY - 1;
        paintArray[x][y] = STEP;
        while (x > finishX || y > finishY) {

            if (stepLeftPossible(x, y, template, paintArray)) { // лево свободно
                move(x, y - 1, paintArray, STEP); // добавляем координаты в paintArray[][]
                y--;
            } else if (stepUpPossible(x, y, template, paintArray)) { //вврех свободно
                move(x - 1, y, paintArray, STEP);
                x--;
            } else {
                paintArray[x][y] = COMEB;
                Cell cell = cameBack(x, y, paintArray, STEP); //ищем STEP = 'P' и переводим координаты на него
                x = cell.getXp();
                y = cell.getYp();
            }

            consoleArray(paintArray);
            System.out.println();
        }
        consoleArray(template);
    }

    private static boolean stepUpPossible(int x, int y, char[][] template, char[][] paintArray) {
        //TODO Проверить на paintArray на 'N' по координатам x y
        return (x - 1 >= 0 && template[x - 1][y] != CHARSPINE) && (paintArray[x - 1][y] != COMEB);
    }

    private static boolean stepLeftPossible(int x, int y, char[][] template, char[][] paintArray) {
        //TODO Проверить на paintArray на 'N' по координатам x y
        return (y - 1 >= 0 && template[x][y - 1] != CHARSPINE) && (paintArray[x][y - 1] != COMEB);
    }

    private static void move(int x, int y, char[][] paintArray, char ch) { // добавляем координаты в paintArray[][]
        paintArray[x][y] = ch;
    }

    private static Cell cameBack(int x, int y, char[][] paintArray, char ch) { //ищем STEP = 'P' и возвращаем координаты
        if (x + 1 <= paintArray.length && paintArray[x + 1][y] == ch) {
            x++;
        } else if (y + 1 <= paintArray.length && paintArray[x][y + 1] == ch) {
            y++;
        }
        return new Cell(x, y);
    }

    private static void consoleArray(char[][] template) {
        for (char[] element : template) {
            for (char el : element) {
                System.out.print(el + " ");
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

        public void setXp(char xp) {
            this.xp = xp;
        }

        public int getYp() {
            return yp;
        }

        public void setYp(char yp) {
            this.yp = yp;
        }

    }
}
