package Demo;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        String a = "hell";
        String b = "ad";
        String c = a+b;
        Node node1 = new Node(1);
        Node node11 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node33 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        SingleLinkedList s = new SingleLinkedList();
        SingleLinkedList s2 = new SingleLinkedList();
        s.add(node1);
        s.add(node3);
        s.add(node6);
        s.add(node8);
        node8.next = node3;
        System.out.println(s.findCircle(s.head));


    }
}

class Node {
    int val;
    Node next;

    @Override
    public String toString() {
        return "val = " + val;
    }

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class SingleLinkedList {
    Node head = new Node();

    public void add(Node node) {
        Node temp = head;
        if (temp.next != null) {
            while (temp.next != null) {
                temp = temp.next;
            }
        }
        temp.next = node;
    }

    public void del(int n) {
        Node temp = head;
        if (n <= 0 || n >= getLength()) {
        }
        while (temp != null) {
            if (temp.next.val == n) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void findReciprocalK(int k) {
        if (k <= 0 || k > getLength()) {
            System.out.println("输入的数据有误");
            return;
        }
        Node first = head.next;
        Node second = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        System.out.println(second);
    }

    public void ReversePrint() {
        Stack<Node> stack = new Stack<>();
        Node temp = head.next;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }


    public void change(int beforeNum, int afterNum) {
        if (find(beforeNum)) {
            Node temp = head;
            while (temp != null) {
                if (temp.val == beforeNum) {
                    break;
                }
                temp = temp.next;
            }
            temp.val = afterNum;
        } else {
            System.out.println("没有找到");
        }

    }

    public boolean find(int n) {
        Node temp = head;
        while (temp != null) {
            if (temp.val == n) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int getLength() {
        Node temp = head.next;
        int num = 0;
        while (temp != null) {
            temp = temp.next;
            num++;
        }
        return num;
    }

    public static void list(Node head) {
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static void merge(Node h1, Node h2) {
        if (h1.next == null || h2.next == null) {
            System.out.println(h1);
        }
        if (h1.next == null && h2.next == null) {
            System.out.println("两个链表都为空");
        }
        Node prev = h1;
        Node temp1 = h1.next;
        Node temp2 = h2.next;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                prev.next = temp1;
                temp1 = temp1.next;
            } else {
                prev.next = temp2;
                temp2 = temp2.next;
            }
            prev = prev.next;
        }
        prev.next = temp1 == null ? temp2 : temp1;

    }

    public boolean Reverse(Node head) {
        if (head.next.next == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = head.next;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        Node temp2 = head.next;
        int num = 0;
        while (temp2 != null) {
            if (temp2.val == stack.pop().val) {
                num++;
            }
            temp2 = temp2.next;
        }
        if (num == getLength()) {
            return true;
        }
        return false;
    }

    public boolean Reverse2(Node node) {
        int[] arr = new int[getLength()];
        Node temp = head.next;
        int i = 0;
        while (temp != null) {
            arr[i] = temp.val;
            i++;
            temp = temp.next;
        }
        int front = 0;
        int rear = arr.length - 1;
        while (front < rear) {
            if (arr[front] != arr[rear]) {
                return false;
            }
            front++;
            rear--;
        }
        return true;
    }
    public boolean findCircle(Node head){
        Node temp = head;
        int num = 4;
        while (num > 0 ){
            num--;
            temp = temp.next;
        }
        Node temp2 = head;
        for (int i = 0; i < 4; i++) {
            if (temp.next == temp2) {
                System.out.println(i-1);
                return true;
            }
            temp2 = temp2.next;

        }
        return false;
    }

}