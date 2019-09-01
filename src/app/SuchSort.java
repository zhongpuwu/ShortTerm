package app;

import java.util.ArrayList;
import java.util.Random;

public class SuchSort {
    static ArrayList<Integer> al = new ArrayList<Integer>();

    static String GetString(ArrayList<Integer> al) {
        String str = new String();
        for (int i = 0; i < al.size(); i++) {
            str += String.format("%3d", al.get(i));
        }
        return str;
    } // 将队列转化成字符串

    static String BubbleSort(ArrayList<Integer> al) {
        for (int i = 0; i < al.size() - 1; i++) {
            for (int j = 0; j < al.size() - i - 1; j++) {
                if (al.get(j) > al.get(j + 1)) {
                    al.add(j, al.get(j + 1));
                    al.remove(j + 2);
                }
            }
        }
        return GetString(al);
    } // 冒泡排序

    static String SelectionSort(ArrayList<Integer> al) {
        int min = 0;
        for (int i = 0; i < al.size() - 1; i++) {
            min = i;
            int j = i + 1;
            for (; j < al.size(); j++) {
                if (al.get(j) < al.get(min)) {
                    min = j;
                }
            }
            al.add(i, al.get(min));
            al.remove(min + 1);
        }
        return GetString(al);
    } // 选择排序

    static String InsertionSort(ArrayList<Integer> al) {
        ArrayList<Integer> al2 = new ArrayList<Integer>();
        int flag;
        al2.add(al.get(0));
        for (int i = 1; i < al.size(); i++) {
            flag = 1;
            for (int j = 0; j < al2.size(); j++) {
                if (al2.get(j) >= al.get(i)) {
                    al2.add(j, al.get(i));
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                al2.add(al.get(i));
        }
        return GetString(al2);
    } // 插入排序

    static String QuickSort(ArrayList<Integer> al, int m, int n) {
        int x, y;
        if (m <= n)
            return GetString(al);
        else {
            x = (m + n) / 2;
            y = al.get(m);
            if (al.get(m) > al.get(x)) {
                al.add(m, al.get(x));
                al.remove(m + 1);
                al.add(n, y);
                al.remove(n + 1);
            }
            if (al.get(x) > al.get(n)) {
                al.add(m, al.get(x));
                al.remove(m + 1);
                al.add(n, y);
                al.remove(n + 1);
            }
            if (al.get(m) > al.get(x)) {
                al.add(m, al.get(x));
                al.remove(m + 1);
                al.add(n, y);
                al.remove(n + 1);
            }
            QuickSort(al, m, x);
            QuickSort(al, x, n);
            return GetString(al);
        }
    } // 快速排序

    static String ShellSort(ArrayList<Integer> al) {
        int n = al.size() / 2;
        int x;
        while (n >= 1) {
            for (int i = 0; i < al.size() - n; i++) {
                if (al.get(i) >= al.get(i + n)) {
                    x=al.get(i);
                    al.add(i,al.get(i+n));
                    al.remove(i+1);
                    al.add(i+n,x);
                    al.remove(i+n+1);
                }
            }
            System.out.println(GetString(al));
            n/=2;
        }
        return GetString(al);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            al.add(rand.nextInt(100));
            System.out.printf("%3d", al.get(i));
        }
        System.out.println();
        // 首先构造一个随机的ArrayList队列
        System.out.println(BubbleSort(al));
        System.out.println(SelectionSort(al));
        System.out.println(InsertionSort(al));
        System.out.println(QuickSort(al, 0, al.size() - 1));
        System.out.println(ShellSort(al));
    }
}