package Demo;

import java.io.StringReader;

public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList cl = new CircleSingleLinkedList();
        cl.joseph(1, 2, 25);


    }
}

class Node2 {
    int val;
    Node2 next;

    @Override
    public String toString() {
        return "Node2{" +
                "val=" + val +
                '}';
    }

    public Node2(int val) {
        this.val = val;
    }
}

class CircleSingleLinkedList {
    Node2 first = new Node2(-1);

    public void addPerson(int num) {
        if (num < 1) {
            System.out.println("人数少了");
            return;
        }
        Node2 cur = first;
        for (int i = 1; i <= num; i++) {
            Node2 p = new Node2(i);
            if (i == 1) {
                first = p;
                p.next = p;
                cur = first;
            } else {
                cur.next = p;
                p.next = first;
                cur = cur.next;
            }
        }
    }

    public void list() {
        Node2 cur = first;
        do {
            System.out.println(cur);
            cur = cur.next;
        } while (cur != first);
    }

    public void joseph(int k, int m, int n) {
        if (k < 1 || m < 0 || k > n || n < 0) {
            return;
        }
        addPerson(n);
        Node2 helper = first;
        while (helper.next != first) {
            helper = helper.next;
        }
        for (int i = 0; i < k - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        while (true) {
            if (helper == first) {
                System.out.println("最后的赢家" + first);
                return;
            }
            for (int i = 0; i < m - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println("出圈者是"+first);
            first = first.next;
            helper.next = first;
        }
    }
}