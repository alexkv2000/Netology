package kvo.denamix.trees;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52};
        int[] arr = new int[array.length];
        mark(array, 0, array.length - 1, 0, arr);
        build(array);
    }

    static int[] mark(int[] arr, int left, int right, int level, int[] levels) {
        if (arr.length == 0 || arr.length == 1) {
            return levels;
        }
        int middle;
        if (left == right) {
            levels[left] = level;
            return levels; // ?
        }

        if (left > right) {
            return levels;
        } else {
            middle = (left + right) / 2;
        }

        levels[middle] = level;
        mark(arr, left, middle - 1, level + 1, levels);
        mark(arr, middle + 1, right, level + 1, levels);

        return levels;
    }

    static void build(int[] arr) {
        int[] levels = new int[arr.length];

        mark(arr, 0, arr.length - 1, 0, levels);
        int maxLevel = maxLevel(levels) + 1;
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

    private static int maxLevel(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
