package app;

import java.util.LinkedList;

class Nodea {
    int id;
    Nodea left = null;
    Nodea right = null;
    Nodea last = null;

    Nodea(int id) {
        this.id = id;
    }

    void insert(Nodea n,boolean x){
        n.last=this;
        if(x) this.left=n;
        else this.right=n;
    }
}

public class Cengci {
    public static void main(String[] args) {
        // 我的测试二叉树
        Nodea b = new Nodea(64);
        b.insert(new Nodea(28), true);
        b.left.insert(new Nodea(13), true);
        b.left.insert(new Nodea(15), false);
        b.insert(new Nodea(36), false);
        b.right.insert(new Nodea(18), true);
        b.right.insert(new Nodea(18), true);
        b.right.right.insert(new Nodea(8), true);
        b.right.right.insert(new Nodea(10), false);
        b.right.right.right.insert(new Nodea(5), true);
        b.right.right.right.insert(new Nodea(5), false);
        b.right.right.right.right.insert(new Nodea(2), true);
        b.right.right.right.right.insert(new Nodea(3), false);
    }
}