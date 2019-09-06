package app;

public class PrimKruskal {

    static int MAX = 65535;

    static int[][] map = new int[][] { { MAX, 7, MAX, 5, MAX, MAX, MAX }, { 7, MAX, 8, 9, 7, MAX, MAX },
            { MAX, 8, MAX, MAX, 5, MAX, MAX }, { 5, 9, MAX, MAX, 15, 6, MAX }, { MAX, 7, 5, 15, MAX, 8, 9 },
            { MAX, MAX, MAX, 6, 8, MAX, 11 }, { MAX, MAX, MAX, MAX, 9, 11, MAX } };

    static int[] bcj = new int[] { 0, 0, 0, 0, 0, 0, 0 };

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

    static void Prime(int[][] map) {
        int n = 7;
        char[] c = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[] lowcost = new int[n];
        int[] mst = new int[n];
        int minid = 0, sum = 0;

        for (int i = 1; i < n; i++) {
            lowcost[i] = map[0][i];
            mst[i] = 0; // 存储标记
        }

        for (int i = 1; i < n; i++) {
            int min = MAX;
            for (int j = 1; j < n; j++) {
                if (lowcost[j] < min && lowcost[j] != 0) {
                    min = lowcost[j];
                    minid = j;
                }
            }
            System.out.println(c[mst[minid]] + "-->" + c[minid] + ":" + min);
            sum += min;
            lowcost[minid] = 0;
            for (int j = 1; j < n; j++) {
                if (map[minid][j] < lowcost[j]) {
                    lowcost[j] = map[minid][j];
                    mst[j] = minid;
                }
            }
        }

        System.out.println("sum:" + sum);
    }

    public static void Kruskal(int[][] arcs) {
        // 顶点个数
        int num = arcs.length;
        // 存放对应顶点所在连通图标识
        int[] group = new int[num];
        int sum = 0, n1 = 0, n2 = 0;
        boolean finished = false;
        int groupNum = 1;

        while (!finished) {
            int min = Integer.MAX_VALUE;
            // 找出所有边中最小值
            for (int i = 0; i < num; i++) {
                for (int j = i + 1; j < num; j++) {
                    if (arcs[i][j] > 0 && arcs[i][j] < min) {
                        // 如果group相同，则表示处理过，不相同或都为0都表示没处理过
                        if (group[i] != group[j] || (group[i] == 0 && group[j] == 0)) {
                            min = arcs[i][j];
                            n1 = i;
                            n2 = j;
                        }
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                continue;
            }
            System.out.println(n1 + " ---> " + n2 + " " + min);
            sum += min;
            // 找到了最小值，设置连通标记
            if (group[n1] == 0 && group[n2] == 0) {
                group[n1] = groupNum;
                group[n2] = groupNum;
                groupNum++;
            } else if (group[n1] > 0 && group[n2] > 0) {
                int tmp = group[n2];
                for (int m = 0; m < group.length; m++) {
                    if (group[m] == tmp) {
                        group[m] = group[n1];
                    }
                }
            } else {
                if (group[n1] == 0) {
                    group[n1] = group[n2];
                } else {
                    group[n2] = group[n1];
                }
            }
            for (int i = 0; i < group.length; i++) {
                if (group[i] != group[0]) {
                    finished = false;
                    break;
                } else {
                    finished = true;
                }
            }
            if (finished) {
                break;
            }
        }
        System.out.println(" sum:" + sum);
    }

    public static void main(String[] args) {
        Prime(map);
        System.out.println();
        Kruskal(map);
    }
}