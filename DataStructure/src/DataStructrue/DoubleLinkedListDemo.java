package DataStructrue;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        DoubleLinkedList d = new DoubleLinkedList();
        DoubleLinkedList d2 = new DoubleLinkedList();
        d2.add(n8);
        d2.add(n7);
        d2.add(n6);
        d2.add(n5);
        d2.del(6);
        DoubleLinkedList.list(d.head);
        System.out.println("-----------------");
        DoubleLinkedList.list(d2.head);
    }
}

class DoubleLinkedList {
    ListNode head = new ListNode(0);

    public void add(ListNode node){
        ListNode temp = head;
        while (temp.next != null){
            if (temp.next.val>node.val){
                node.next = temp.next;
                node.pre = temp;
                temp.next.pre = node;
                temp.next = node;
                return;
            }
            temp =temp.next;
        }
        temp.next= node;
        node.pre = temp;

    }
    public void del(int val) {
        ListNode temp = head;
        boolean flag = false;
        while (temp != null) {
            if (temp.val == val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag && temp.next == null) {
            temp.pre.next =null;
        }else if (flag) {
            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;
        }else {
            System.out.println("没有这个节点");
        }
    }

    public static void list(ListNode head) {
        ListNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            System.out.println(temp.val+"node.next = "+temp.next);
            System.out.println(temp.val+"node.pre = "+temp.pre);
            temp = temp.next;
        }
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode pre;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}