package app;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.*;

class Student {
    String id = "0000"; // 学号
    String name = "XXX"; // 姓名
    Double agrade = -1.00; // a学科成绩
    Double bgrade = -1.00; // b学科成绩
    Double cgrade = -1.00; // c学科成绩
    boolean x = false; // 是否有效

    Student(String id, String name, double a, double b, double c) {
        this.id = id;
        this.name = name;
        this.agrade = a;
        this.bgrade = b;
        this.cgrade = c;
    }

    public Student() {
    }
}

public class LinkedGradeManager {
    static Scanner scan = new Scanner(System.in);
    static LinkedList<Student> Grades = new LinkedList<Student>(); // 给LinkedList加个泛型

    static void SearchId() { // 按学号查
        scan.nextLine();
        System.out.print("\n请输入完整或部分学号：");
        String str = scan.nextLine();
        System.out.println("\n读取成功:……\n");
        str = ".*" + str + ".*"; // 构造正则表达式
        int n = 0;
        System.out.println(" 序号 | 学号 | 姓名 | a成绩 | b成绩 | c成绩 | 是否有效");
        for (Student i : Grades) {
            if (Pattern.matches(str, i.id)) { // 正则表达式匹配相同字段
                System.out.printf("%d:%s %s %.1f %.1f %.1f %s\n", n, i.id, i.name, i.agrade, i.bgrade, i.cgrade,
                        i.x == true ? "有效" : "无效");
                n++;
            }
        }
        System.out.println("\n查询结束========================================================<\n");
    }

    static void SearchName() { // 按姓名查
        scan.nextLine();
        System.out.print("\n请输入完整或部分姓名：");
        String str = scan.nextLine();
        System.out.println("\n读取成功:……\n");
        str = ".*" + str + ".*"; // 构造正则表达式
        int n = 0;
        System.out.println(" 序号 | 学号 | 姓名 | a成绩 | b成绩 | c成绩 | 是否有效");
        for (Student i : Grades) {
            if (Pattern.matches(str, i.name)) { // 正则表达式匹配相同字段
                System.out.printf("%d:%s %s %.1f %.1f %.1f %s\n", n, i.id, i.name, i.agrade, i.bgrade, i.cgrade,
                        i.x ? "有效" : "无效");
                n++;
            }
        }
        System.out.println("\n查询结束========================================================<\n");
    }

    static void SearchAll() { // 查询所有
        System.out.println("\n读取成功,平均成绩计算成功:……\n");
        int n = 0, m = 0;
        double asum = 0, bsum = 0, csum = 0, sum = 0;
        System.out.println(" 序号 | 学号 | 姓名 | a成绩 | b成绩 | c成绩 | 是否有效");
        for (Student i : Grades) {
            if (i.x) {
                asum += i.agrade;
                bsum += i.bgrade;
                csum += i.cgrade;
                m++;
            }
            System.out.printf("%d:%s %s %.1f %.1f %.1f %s\n", n, i.id, i.name, i.agrade, i.bgrade, i.cgrade,
                    i.x ? "有效" : "无效");
            n++;
        }
        sum = asum + bsum + csum;
        if (m != 0)
            System.out.printf("\n共%d条记录 有效记录%d条 其中a平均分:%f b平均分:%f c平均分:%f 总平均分:%f\n", n, m, asum / m, bsum / m,
                    csum / m, sum / m);
        else
            System.out.printf("\n共有%d条记录 有效记录有%d条\n", n, m);
        System.out.println("\n查询成功========================================================<\n");
        return;
    }

    static HashMap<Integer, String> SearchAllMap() { // 查询所有并返回结果集
        System.out.println("\n读取成功……\n");
        HashMap<Integer, String> TheMap = new HashMap<Integer, String>();
        int n = 0;
        System.out.println(" 序号 | 学号 | 姓名 | a成绩 | b成绩 | c成绩 | 是否有效");
        for (Student i : Grades) {
            TheMap.put(n, i.id);
            System.out.printf("%d:%s %s %.1f %.1f %.1f %s\n", n, i.id, i.name, i.agrade, i.bgrade, i.cgrade,
                    i.x ? "有效" : "无效");
            n++;
        }
        System.out.println("\n查询结束\n");
        return TheMap;
    }

    static HashMap<Integer, String> SearchIdMap() { // 按学号查
        scan.nextLine();
        HashMap<Integer, String> TheMap = new HashMap<Integer, String>();
        System.out.print("\n请输入完整或部分学号：");
        String str = scan.nextLine();
        System.out.println("\n读取成功:……\n");
        str = ".*" + str + ".*"; // 构造正则表达式
        int n = 0;
        System.out.println(" 序号 | 学号 | 姓名 | a成绩 | b成绩 | c成绩 | 是否有效");
        for (Student i : Grades) {
            if (Pattern.matches(str, i.id)) { // 正则表达式匹配相同字段
                TheMap.put(n, i.id);
                System.out.printf("%d:%s %s %.1f %.1f %.1f %s\n", n, i.id, i.name, i.agrade, i.bgrade, i.cgrade,
                        i.x == true ? "有效" : "无效");
                n++;
            }
        }
        System.out.println("\n查询结束\n");
        return TheMap;
    }

    static HashMap<Integer, String> SearchNameMap() { // 按姓名查
        scan.nextLine();
        HashMap<Integer, String> TheMap = new HashMap<Integer, String>();
        System.out.print("\n请输入完整或部分姓名：");
        String str = scan.nextLine();
        System.out.println("\n读取成功:……\n");
        str = ".*" + str + ".*"; // 构造正则表达式
        int n = 0;
        System.out.println(" 序号 | 学号 | 姓名 | a成绩 | b成绩 | c成绩 | 是否有效");
        for (Student i : Grades) {
            if (Pattern.matches(str, i.name)) { // 正则表达式匹配相同字段
                TheMap.put(n, i.id);
                System.out.printf("%d:%s %s %.1f %.1f %.1f %s\n", n, i.id, i.name, i.agrade, i.bgrade, i.cgrade,
                        i.x ? "有效" : "无效");
                n++;
            }
        }
        System.out.println("\n查询结束\n");
        return TheMap;
    }

    static void Search() {
        if (Grades.size() == 0) {
            System.out.println("\n数据为空，请输入数据!\n");
            return;
        }
        System.out.println("请输入您的需求\n");
        System.out.print("1.查询所有\n2.按学号查\n3.按姓名查\n\n请选择：");
        int sc = scan.nextInt();
        switch (sc) {
        case 1:
            System.out.println("\n查询中……");
            SearchAll();
            break;
        case 2:
            SearchId();
            break;
        case 3:
            SearchName();
            break;
        }
    }

    static void Change() {
        if (Grades.size() == 0) {
            System.out.println("\n数据为空，请输入数据!\n");
            return;
        }
        System.out.println("需要先进行查询请输入您的需求\n");
        System.out.print("1.查询所有\n2.按学号查\n3.按姓名查\n4.返回上一菜单\n\n请选择：");
        HashMap<Integer, String> TheMap = new HashMap<Integer, String>();
        int sc = scan.nextInt();
        switch (sc) {
        case 1:
            System.out.println("\n查询中……");
            TheMap = SearchAllMap();
            break;
        case 2:
            TheMap = SearchIdMap();
            break;
        case 3:
            TheMap = SearchNameMap();
            break;
        case 4:
            return;
        }
        System.out.print("请输入需要更改的序号:");
        int n = scan.nextInt();
        String id = TheMap.get(n);
        for (Student i : Grades) {
            if (id.equals(i.id)) {
                System.out.println("\n目标数据如下:");
                System.out.printf("%s %s %.1f %.1f %.1f %s\n", i.id, i.name, i.agrade, i.bgrade, i.cgrade,
                        i.x ? "有效" : "无效");
                scan.nextLine();
                System.out.println("\n请输入修改后的信息:");
                for (;;) {
                    Student a = new Student();
                    String str = scan.nextLine();
                    String[] strs = str.split(" ");
                    if (strs.length != 5) {
                        System.out.println("\n数据非法重新输入:");
                        a = null;
                        continue;
                    }
                    a.id = strs[0];
                    a.name = strs[1];
                    try {
                        a.agrade = Double.valueOf(strs[2]);
                        a.bgrade = Double.valueOf(strs[3]);
                        a.cgrade = Double.valueOf(strs[4]);
                    } catch (Exception e) {
                        System.out.println("\n数据非法重新输入:");
                        a = null;
                        continue;
                    }
                    if (a.id.length() != 4) {
                        System.out.println("\n学号非法重新输入:");
                        a = null;
                        continue;
                    }
                    if (pd(a.agrade) && pd(a.bgrade) && pd(a.cgrade)) {
                        a.x = true;
                        Grades.add(a);
                        System.out.println("\n修改成功，数据有效!");
                        break;
                    } else {
                        Grades.add(a);
                        System.out.println("\n修改成功，但数据有待完善!");
                        break;
                    }
                }
                Grades.remove(i);
                break;
            }
        }
    }

    static void Delete() {
        if (Grades.size() == 0) {
            System.out.println("\n数据为空，请输入数据!\n");
            return;
        }
        System.out.println("需要先进行查询请输入您的需求\n");
        System.out.print("1.查询所有\n2.按学号查\n3.按姓名查\n4.返回上一菜单\n\n请选择：");
        HashMap<Integer, String> TheMap = new HashMap<Integer, String>();
        int sc = scan.nextInt();
        switch (sc) {
        case 1:
            System.out.println("\n查询中……");
            TheMap = SearchAllMap();
            break;
        case 2:
            TheMap = SearchIdMap();
            break;
        case 3:
            TheMap = SearchNameMap();
            break;
        case 4:
            return;
        }
        System.out.print("请输入需要删除的序号:");
        int n = scan.nextInt();
        String id = TheMap.get(n);
        Grades.removeIf(Student -> Student.id.equals(id)); // lambda表达式
        // 第二种写法
        /*
         * Grades.removeIf(new Predicate<Student>() { public boolean test(Student stu) {
         * return stu.id.equals(id); // 返回满足条件的id } });
         */
    }

    static boolean pd(double a) {
        if (a <= 100.00 && a >= 0.00)
            return true;
        else
            return false;
    }// 判断是否是有效成绩

    static void Insert() {
        while (true) {
            System.out.println("输入0返回菜单");
            System.out.print("请输入插入的人数:");
            int n = scan.nextInt();
            if (n == 0)
                break;
            else {
                System.out.println("\n请按行输入学生信息：\n");
                scan.nextLine();
                labe2: for (int i = 0; i < n; i++) {
                    Student a = new Student();
                    String str = scan.nextLine();
                    String[] strs = str.split(" ");
                    if (strs.length != 5) {
                        System.out.println("数据非法重新输入:");
                        i--;
                        a = null;
                        continue;
                    }
                    a.id = strs[0];
                    a.name = strs[1];
                    try {
                        a.agrade = Double.valueOf(strs[2]);
                        a.bgrade = Double.valueOf(strs[3]);
                        a.cgrade = Double.valueOf(strs[4]);
                    } catch (Exception e) {
                        System.out.println("数据非法重新输入:");
                        i--;
                        a = null;
                        continue;
                    }
                    if (a.id.length() != 4) {
                        System.out.println("学号非法重新输入:");
                        i--;
                        a = null;
                        continue;
                    }
                    for (Student j : Grades) {
                        if (j.id.equals(a.id)) {
                            System.out.println("学号重复重新输入:");
                            i--;
                            a = null;
                            continue labe2;
                        }
                    }
                    if (pd(a.agrade) && pd(a.bgrade) && pd(a.cgrade)) {
                        a.x = true;
                        Grades.add(a);
                        System.out.println("插入成功，数据有效!");
                    } else {
                        Grades.add(a);
                        System.out.println("插入成功，但数据有待完善!");
                    }
                    a = null;
                }
                System.out.println("\n输入结束!========================================================<\n");
            }
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println("欢迎使用WCF的成绩管理系统\n");
        labe1: while (true) {
            System.out.println("请选择您的需求\n");
            System.out.print("1.成绩查询\n2.成绩修改\n3.成绩删除\n4.添加成绩\n5.结束程序\n\n请选择：");
            int sc = scan.nextInt();
            switch (sc) {
            case 1:
                System.out.println("查询成绩========================================================>\n");
                Search();
                break;

            case 2:
                System.out.println("成绩修改========================================================>\n");
                Change();
                break;

            case 3:
                System.out.println("成绩删除========================================================>\n");
                Delete();
                break;

            case 4:
                System.out.println("添加成绩========================================================>\n");
                Insert();
                break;

            case 5:
                scan.close();
                System.out.println("\n程序结束啦！");
                break labe1;
            }
        }
    }
}