package DataStructrue.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class OrigamiTest {
    public static void main(String[] args) {
        OrigamiTest origamiTest = new OrigamiTest();
        origamiTest.printTree(origamiTest.getTree(3));

    }

    public Node getTree(int N) {
        String down = "down";
        String up = "up";
        //产生头结点
        Node root = null;


        //通过N来获得节点
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                root = new Node(down, null, null);
                continue;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    node.left = new Node(down, null, null);
                    node.right = new Node(up, null, null);
                }
            }
        }

        return root;

    }

    public void printTree(Node node){
        if (node == null){
            return;
        }
        if (node.left != null){
            printTree(node.left);
        }
        System.out.println(node);
        if (node.right != null){
            printTree(node.right);
        }
    }
    class Node<String> {
        public String item;
        public Node left;
        public Node right;

        public Node(String item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        @Override
        public java.lang.String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }
}
