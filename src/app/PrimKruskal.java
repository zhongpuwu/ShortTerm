package app;

public class PrimKruskal {

    static int[][] map = new int[][] { { 0, 7, 0, 5, 0, 0, 0 }, { 7, 0, 8, 9, 7, 0, 0 }, { 0, 8, 0, 0, 5, 0, 0 },
            { 5, 9, 0, 0, 15, 6, 0 }, { 0, 7, 5, 15, 0, 8, 9 }, { 0, 0, 0, 6, 8, 0, 11 }, { 0, 0, 0, 0, 9, 11, 0 } };

    static int[] bcj = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };

    static boolean pdFull(int[][] map) {
        for (int[] i : map) {
            int flag = 1;
            for (int j : i) {
                if (j != 0)
                    flag = 0;
            }
            if (flag == 1)
                return false;
        }
        return true;
    }

    static int[] Prime(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            int min = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != 0)
                    min = j;
            }
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != 0 && map[i][min] > map[i][j])
                    min = j;
            }
            bcj[i] = min;
        }
        return bcj;
    }

    public static void main(String[] args) {
        Prime(map);
        for (int i : bcj) {
            System.out.println(i);
        }
    }
}