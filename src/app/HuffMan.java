package app;

import java.util.LinkedList;
import java.util.Stack;

class Node {
    int id;
    Node left = null;
    Node right = null;
    String in = "-1"; // 方便记录编码
    Node last = null;

    Node(int id) {
        this.id = id;
    }
}

public class HuffMan {
    static Node find(LinkedList<Node> Nodes) {
        Node n = Nodes.getFirst();
        for (Node i : Nodes) {
            if (i.id < n.id)
                n = i;
        }
        return n;
    }

    static String Getcode(Node p) {
        String str = new String();
        Stack<String> s = new Stack<String>();
        str += p.id + "的编码是";
        while (p.last != null) {
            s.push(p.in);
            p = p.last;
        }
        for (String i : s) {
            str += i;
        }
        return str;
    }

    public static void main(String[] args) {
        LinkedList<Node> Nodes = new LinkedList<Node>();
        int[] A = { 2, 3, 5, 8, 13, 15, 18 }; // 为了省事直接提供一个有序数组
        for (int i : A) {
            Nodes.add(new Node(i));
        }
        while (true) {
            if (Nodes.size() == 1)
                break;
            Node no1 = find(Nodes);
            Nodes.remove(no1);
            Node no2 = find(Nodes);
            Nodes.remove(no2);
            Node no0 = new Node(no1.id + no2.id);
            no0.left = no1;
            no1.in = "0";
            no0.right = no2;
            no2.in = "1";
            Nodes.add(no0);
            no1.last = no0;
            no2.last = no0;
        }

        // 哈夫曼树已经构造好 接下来是获得每一个元素的编码
        
        LinkedList<Node> ll = new LinkedList<Node>();
        ll.push(Nodes.getFirst());
        Node p = null;
        while (!ll.isEmpty()) {
            p = ll.pop();
            if (p != null) {
                System.out.println((p.last == null) ? "" : Getcode(p));
                ll.push(p.right);
                ll.push(p.left);
            }
        }
    }
}