package Demo;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;

//回文单链表
public class PalindromeLinkedListDemo {
    public static void main(String[] args) {
        PalindromeLinkedList pl = new PalindromeLinkedList();
        Node3 node1 = new Node3(1);
        Node3 node2 = new Node3(2);
        Node3 node3 = new Node3(3);
        Node3 node4 = new Node3(4);
        Node3 node5 = new Node3(5);
        Node3 node6 = new Node3(6);
        Node3 node7 = new Node3(7);
        Node3 node8 = new Node3(8);
        pl.add(node1);
//        node1.next = node1;
        pl.add(node2);
        pl.add(node3);
        pl.add(node4);
        pl.add(node5);
//        pl.add(node6);
//        pl.add(node7);
//        pl.add(node8);
//        node8.next = node8;
//        node4.next = node2;
//        pl.list(pl.first);
        System.out.println(pl.judge(pl.first));


    }
}

class Node3 {
    int val;
    Node3 next;

    public Node3(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node3{" +
                "val=" + val +
                '}';
    }
}

class PalindromeLinkedList {
    Node3 first = new Node3(-1);
    int num = 0;
    public void add(Node3 node) {
       if (num == 0){
           first = node;
       }else {
           Node3 temp = first;
           while (temp.next != null) {
               temp = temp.next;
           }
           temp.next = node;
       }
       num++;
    }

    public void list(Node3 first){
        Node3 cur = first;
        do {
            System.out.println(cur);
            cur = cur.next;
        }while (cur != null);

    }

    public boolean judge(Node3 first){
        if (first.next == null){
            return false;
        }
        Node3 quick = first.next;
        Node3 slow = first;

        while (quick != slow){
            if (quick == null||quick.next == null){
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}