package kvo.denamix.trees;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52};
        int[] levels = new int[array.length];
        build(array);
    }

    static void mark(int left, int right, int level, int[] levels) {
/*        if (arr.length == 0 || arr.length == 1) {
            return;
        }*/
        int middle;
        if (left == right) {
            levels[left] = level;
            return;
        }

        if (left > right) {
            return;
        } else {
            middle = (left + right) / 2;
        }
//        middle = (left + right) / 2;
        levels[middle] = level;
        mark(left, middle - 1, level + 1, levels);
        mark(middle + 1, right, level + 1, levels);

    }

    static void build(int[] arr) {
        int[] levels = new int[arr.length];

        mark(0, arr.length - 1, 0, levels);
        int maxLevel = levels[levels.length - 1] + 1;
        for (int level = 0; level < maxLevel; level++) {
            for (int i = 0; i < arr.length; i++) {
                if (levels[i] == level) {
                    System.out.print(arr[i]);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
