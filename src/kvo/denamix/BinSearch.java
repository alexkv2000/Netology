package kvo.denamix;

public class BinSearch {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    static char[][] field = new char[][]{
            {'Щ', '.', '.', '*', '*', '.', '.', '.', '.', '.'},
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
    public static int left_x = 0;
    public static int left_y = 0;
    public static int up_x = 0;
    public static int up_y = 0;
    public static int startX = 10;
    public static int startY = 10;

    public static void main(String[] args) {

        char[][] path = new char[10][10];
        find_path(field, startX, startY, path);
    }

    private static char where_from(char[][] field, int x, int y, char[][] memory) {

        if (memory[x][y] != '\u0000') {
            return memory[x][y];
        }
        if (x > 0) {
            left_x = x - 1;
            left_y = y;
            if (left_x == 0 && left_y == 0) {
                memory[x][y] = 'L';
                return 'L';
            }
            if (field[left_x][left_y] != '*') {
                if (where_from(field, left_x, left_y, memory) != 'N') {
                    memory[x][y] = 'L';
                    return 'L';
                }
            }
        }
        if (y > 0) {
            up_x = x;
            up_y = y - 1;
            if (up_x == 0 && up_y == 0) {
                memory[x][y] = 'U';
                return 'U';
            }
            if (field[up_x][up_y] != '*') {
                if (where_from(field, up_x, up_y, memory) != 'N') {
                    memory[x][y] = 'U';
                    return 'U';
                }
            }
        }
        memory[x][y] = 'N';
        return 'N';
    }

    private static void find_path(char[][] field, int x0, int y0, char[][] path) {
        int x = x0 - 1;
        int y = y0 - 1;
        char direction;
        while (x >= 0 & y >= 0) { // это не (0; 0)
            direction = where_from(field, x, y, path);
            if (direction == 'N') {
                System.out.println("нет пути");
                break;
            } else if (direction == 'U') {
                path[x][y] = '+'; //"да"
                y -= 1;
            } else if (direction == 'L') {
                path[x][y] = '+'; //"да"
                x -= 1;
            }
        }
        for (y = 0; y < field.length; y++) {
            for (x = 0; x < field.length; x++) {
                if (x == x0 && y == y0) {
                    System.out.printf(" %2s", 'Щ');
                } else if (x == startX - 1 && y == startY - 1) {
                    System.out.printf(" %2s", 'Ч');
                } else if (path[y][x] == '+') {
                    System.out.printf("  %s", ANSI_GREEN + path[y][x] + ANSI_RESET);
                } else {
                    System.out.printf(" %2s", field[y][x]);
                }
            }
            System.out.println();
        }
    }
}