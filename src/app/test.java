package app;

import java.util.LinkedList;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        LinkedList<Integer> al=new LinkedList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            al.add(rand.nextInt(100));
            System.out.printf("%3d", al.get(i));
        }
        int n=al.size()/2;
        int i=0;
        int x=al.get(0+n);
        al.add(i,al.get(i+n));
        al.remove(i+1);
        al.add(i+n,x);
        al.remove(i+n+1);

        System.out.println(al);
    }
}