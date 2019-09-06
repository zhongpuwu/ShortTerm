package app;

import java.util.LinkedList;
import java.util.Scanner;

class TheCar {
    int id;
    int times = 0; // 记录有效时长
    boolean instop = false; // 记录车的位置信息true意味着在停车场false意味着在便道
    int in;
    int out;

    TheCar(int id, int in, int out) {
        this.id = id;
        this.in = in;
        this.out = out;
    }
}

public class Stop {
    static LinkedList<TheCar> x = new LinkedList<TheCar>();// 表示停车场
    static LinkedList<TheCar> y = new LinkedList<TheCar>();// 表示便道
    static LinkedList<TheCar> z = new LinkedList<TheCar>();// 表示外部的待服务的区域
    static Scanner scan = new Scanner(System.in);

    // 规定停车场的长度为 7
    // 规定车辆在停车场中和便道上的移动都是瞬时的
    // 结束了所有输入后才可以进行停车场模拟
    static void In(TheCar tc) {
        if (!isfull(x)) {
            x.add(tc);
            System.out.println("车牌为" + tc.id + "的汽车停入停车场");
        } else {
            y.add(tc);
            System.out.println("车牌为" + tc.id + "的汽车停入便道");
        }
    }

    static void Out(TheCar tc) {
        int deep = x.indexOf(tc);
        while (deep < x.size()) {
            TheCar tc1 = x.pop();
            tc1.instop = false;
            y.add(tc1);
        }
        System.out.println("车牌为" + tc.id + "的汽车离开 有效停车时间为" + tc.times);
        x.pop();
    }

    static void Mov() {
        while (!isfull(x) && !y.isEmpty()) {
            TheCar tc = y.removeFirst();
            tc.instop = true;
            x.add(tc);
            System.out.println("车牌为" + tc.id + "驶入停车场");
        }
        if (!x.isEmpty())
            for (TheCar tc : x) {
                tc.times++;
            }
    }

    static boolean isfull(LinkedList<TheCar> x) {
        if (x.size() >= 7)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.print("请输入需要模拟的车的总数：");
        int n = scan.nextInt();
        int id, in, out;
        for (int i = 0; i < n; i++) {
            id = scan.nextInt();
            in = scan.nextInt();
            out = scan.nextInt();
            z.add(new TheCar(id, in, out));
        }
        for (int i = 0; i < 30; i++) {
            System.out.println("第" + i + "时刻:");
            if (!z.isEmpty())
                for (TheCar tc : z) {
                    if (tc.in == i) {
                        In(tc);
                        z.remove(tc);
                    }
                }
            if (!x.isEmpty())
                for (TheCar tc : x) {
                    if (tc.out == i) {
                        Out(tc);
                    }
                }
            if (!y.isEmpty())
                for (TheCar tc : y) {
                    if (tc.out == i) {
                        System.out.println("车牌为" + tc.id + "的车直接开走了！");
                    }
                }
            if (!isfull(x))
                Mov();
        }
        System.out.println("服务结束");
    }
}
