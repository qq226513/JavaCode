package Set;

import java.util.HashSet;

/**
 * @author 一台
 */
public class SetTest {
    public static void main(String[] args) {
        Node[] table = new Node[16];
        Node john = new Node("John");
        table[2] = john;
        Node jack = new Node("Jack");
        john.next = jack;
        HashSet set = new HashSet();
        set.add("fa");

    }
}
class Node{
    Object item;
    Node next;
    public Node(Object value) {
        this.item= value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + item +
                '}';
    }
}
