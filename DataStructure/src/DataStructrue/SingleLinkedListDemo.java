package DataStructrue;

import java.util.Scanner;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(2, "李四");
        Node node3 = new Node(3, "王五");
        Node node4 = new Node(4, "六六");
        Node node5 = new Node(5, "三六");
        Node node6 = new Node(6, "ss");
        Node node7 = new Node(7, "cdss");
        Node node8 = new Node(8, "s2s");
        Node node9 = new Node(9, "cd3ss");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node4);
        singleLinkedList.add(node6);
        singleLinkedList.delReciprocalK(singleLinkedList.head, 4);


    }

}

class Node {
    int no;
    String name;//节点信息
    Node nextNode;//指向下一节点

    public Node() {
    }

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public Node(int no, Node nextNode) {
        this.no = no;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name +
                '}';
    }
}

class SingleLinkedList {

    Node head = new Node();//头结点
    Scanner sc = new Scanner(System.in);
    String str = "";


    public void add(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.nextNode == null) {
                break;
            }
            if (temp.nextNode.no > node.no) {
                break;
            } else if (temp.nextNode.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.nextNode;
        }
        if (flag) {
            System.out.println("已存在");
        } else {
            node.nextNode = temp.nextNode;
            temp.nextNode = node;
        }
    }

    public void del(Node node) {
        Node temp = head.nextNode;
        boolean flag = false;
        while (temp != null) {
            if (temp.nextNode == null) {
                break;
            }
            if (temp.nextNode == node) {
                flag = true;
                break;
            }
            temp = temp.nextNode;
        }
        if (flag) {
            temp.nextNode = temp.nextNode.nextNode;

        } else {
            System.out.println("没有这个节点");
        }
    }

    public Node removeNthFromEnd(Node head,int n){
        int num = 0;
        Node temp = head.nextNode;
        while (temp != null){
            num++;
            temp = temp.nextNode;
        }
        System.out.println("num = "+num);
        temp = head;
        for (int i = 1; i < num - n + 1; i++) {
                temp = temp.nextNode;
        }
        temp.nextNode =temp.nextNode.nextNode;
        temp.nextNode.nextNode = null;
        return head;
    }
    public void list() {
        if (isEmpty()) {
            System.out.println("遍历失败，链表为空");
            return;
        }
        Node temp = head.nextNode;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.nextNode;
        }
    }

    public boolean isEmpty() {
        return head.nextNode == null;
    }


    public void change(Node node) {
        if (isEmpty()) {
            System.out.println("遍历失败，链表为空");
            return;
        }
        Node temp = head.nextNode;
        while (temp != null) {
            if (temp == node) {
                System.out.println("请选择你要修改的内容(编号no或名字name或全部all)");
                str = sc.next();
                switch (str) {
                    case "no":
                        System.out.println("请输入你要修改的值");
                        node.no = sc.nextInt();
                        break;
                    case "name":
                        System.out.println("请输入你要修改的值");
                        node.name = sc.next();
                        break;
                    case "all":
                        System.out.println("请输入你要修改的名字：");
                        node.name = sc.next();
                        System.out.println("请输入你要修改的编号：");
                        node.no = sc.nextInt();
                        break;
                }
                break;
            }
            temp = temp.nextNode;
        }
    }

    public int findNum() {
        int num = 0;
        Node temp = head.nextNode;
        while (temp != null) {
            temp = temp.nextNode;
            num++;
        }
        return num;

    }


    public void findReciprocalK(int k) {
        int num = findNum();
        if (k <= 0 | k > num) {
            System.out.println("错误");
        }
        Node temp = head;
        for (int i = 1; i <= num - k + 1; i++) {
            temp = temp.nextNode;
        }
        System.out.println(temp);
    }

    public void delReciprocalK(Node head,int k){
        if (k <= 0){
            return;
        }
        Node first = head.nextNode;
        Node second = head;
        for (int i = 0; i < k; i++) {
            first = first.nextNode;
        }
        while (first != null){
            first = first.nextNode;
            second = second.nextNode;
        }
        second.nextNode = second.nextNode.nextNode;
        list();
    }


    public void Reverse() {
        if (isEmpty() || head.nextNode.nextNode == null) {
            System.out.println("无需反转");
            return;
        }
        Node reverseHead = new Node();
        Node temp = head.nextNode;
        Node next = null;
        while (temp != null) {
            next = temp.nextNode;
            temp.nextNode = reverseHead.nextNode;
            reverseHead.nextNode = temp;
            temp = next;

        }
        head.nextNode = reverseHead.nextNode;
    }



    public void ReversePrint(Node headNode) {
        Stack<Node> stack = new Stack<Node>();
        Node temp = headNode.nextNode;
        while (temp != null) {
            stack.push(temp);
            temp = temp.nextNode;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}