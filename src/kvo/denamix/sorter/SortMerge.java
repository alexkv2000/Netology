package kvo.denamix.sorter;

public class SortMerge {
    // answer : [51, 45, 31, 31, 30, 24, 22, 20, 18, 17].
    public static void main(String[] args) {
        int[][] regional_teams = new int[][]{
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };
        //choice national team
        int[] national_Team = nationalTeam(regional_teams);
        //print on the console
        for (int j : national_Team) {
            System.out.print(j + " ");
        }
    }

    private static int[] merge(int[] left_sorted, int[] right_sorted) {
        int[] merge_sort = new int[left_sorted.length]; //array limit length
        int indexLeft = 0;  //counter array merge_sort
        int iCLeft = 0;     //index First array
        int iCRight = 0;    //index Second array

        while (indexLeft < merge_sort.length) {
            if (left_sorted[iCLeft] > right_sorted[iCRight]) {
                merge_sort[indexLeft++] = left_sorted[iCLeft++];
            } else {
                merge_sort[indexLeft++] = right_sorted[iCRight++];
            }
        }
        return merge_sort;
    }

    public static int[] nationalTeam(int[][] regional_teams) {
        int[] temp_regional = regional_teams[0]; // берем первую команду для слияния
        for (int i = 1; i < regional_teams.length; i++) { // берем вторую и далее
            temp_regional = merge(temp_regional, regional_teams[i]);
        }
        return temp_regional;
    }
}
