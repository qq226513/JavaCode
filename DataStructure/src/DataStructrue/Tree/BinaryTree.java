package DataStructrue.Tree;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.lang.ref.PhantomReference;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    public Node root;
    private int N;

    public class Node {
        Node left;
        Node right;
        Key key;
        Value value;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public Node(Node left, Node right, Key key, Value value) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //向指定的树插入新的节点
    public Node put(Node node, Key key, Value value) {
        //如果当前节点为空，就返回一个新的节点
        if (node == null) {
            N++;
            return new Node(null, null, key, value);
        }

        //如果当前节点不为空
        //做比较
        int cmp = key.compareTo(node.key);

        if (cmp > 0) {//如果当前节点的key 小于 传入的key
            //找右子树
            node.right = put(node.right, key, value);
        } else if (cmp < 0) {//如果当前节点的key 大于 传入的key
            //找左子树
            node.left = put(node.left, key, value);
        } else {//如果当前节点的key 等于 传入的key
            //更新当前节点的value
            node.value = value;
        }
        return node;
    }

    public Node get(Key key) {
        return get(root, key);
    }

    public Node get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp > 0 && node.right != null) {
            return get(node.right, key);
        }
        if (cmp < 0 && node.left != null) {
            return get(node.left, key);
        }
        return null;
    }

    //清空key对应的value值
    public void delete(Key key) {
        delete(root, key);
    }

    public Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            delete(node.right, key);
        } else if (cmp < 0) {
            delete(node.left, key);
        } else {
            if (node.left == null && node.right == null) {
                return deleteLeaf(root, node.key);
            }
            if (node.right == null) {
                node = node.left;
                return node.left;
            }
            if (node.left == null) {
                node = node.right;
                return node.right;
            }

            //找当前节点右子树的最左节点
            Node minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //将该节点删除
            Node temp = node.right;
            while (true) {
                if (temp.left == minNode) {
                    temp.left = null;
                    break;
                }
                temp = temp.left;
            }
            //将node节点与minNode节点替换
            minNode.left = node.left;
            minNode.right = node.right;
            node = minNode;

        }
        return node;
    }

    public Node deleteLeaf(Node node, Key key) {
        Node dNode = get(key);
        return dL(node, dNode);
    }

    public Node dL(Node node, Node dNode) {
        Node cur = null;
        Node cur2 = null;
        if (node.left != null) {
            dL(node.left, dNode);
        }
        if (node.right != null) {
            dL(node.right, dNode);
        }
        if (node.left == dNode) {
            node.left = null;
            cur = node;
        }
        if (node.right == dNode) {
            node.right = null;
            cur = node;
        }
        return cur;
    }

    public void show(Node node) {
        if (node.left != null) {
            show(node.left);
        }
        if (node.right != null) {
            show(node.right);
        }
        System.out.println(node);
    }

    //通过键值去找到父节点
    public Node searchFatherNode(Node node, Key key) {
        if (node == null) {
            return null;
        }
        //如果当前节点的左或右节点就是key对应的节点，则直接返回node
        if (node.left == get(key) || node.right == get(key)) {
            return node;
        }

        int i = key.compareTo(node.key);
        if (i > 0) {
            return searchFatherNode(node.right, key);
        } else if (i < 0) {
            return searchFatherNode(node.left, key);
        }
        return null;
    }

    //通过值删除节点
    public void deleteNode(Node node, Key key) {
        if (node == null && get(key) == root) {
            return;
        }
        //找到父节点
        Node FatherNode = searchFatherNode(node, key);
        Node dNode = get(key);
        //分情况删除
        //1.待删除节点是叶子节点
        if (dNode.right == null && dNode.left == null) {
            if (FatherNode.left == dNode) {
                FatherNode.left = null;
            } else {
                FatherNode.right = null;
            }
            return;
        }
        //2.待删除节点只有左或者右节点
        if (dNode.left == null) {
            FatherNode.left = null;
            FatherNode.left = dNode.right;
            dNode.right = null;
            return;
        }
        if (dNode.right == null) {
            FatherNode.right = null;
            FatherNode.right = dNode.left;
            dNode.left = null;
            return;
        }

        //3.待删除节点左右都存在
        //找到待删除节点的右子树的最左节点并删除
        Node temp = dNode.right;
        while (temp.left.left != null) {
            temp = temp.left;
        }
        Node minNode = temp.left;
        temp.left = null;
        //将其与待删除节点交换
        minNode.left = dNode.left;
        minNode.right = dNode.right;
        dNode = minNode;
    }


    //前中后序遍历

    //层序遍历
    public Queue<Key> SequenceT() {
        Queue<Key> keys = new LinkedList<>();
        Queue<Node> nodes = new LinkedList<>();
        //将根节点默认存储进nodes
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            Node poll = nodes.poll();
            keys.offer(poll.key);
            if (poll.left != null) {
                nodes.offer(poll.left);
            }
            if (poll.right != null) {
                nodes.offer(poll.right);
            }
        }
        return keys;
    }


    public int MaxDepth(Node node) {
        int maxL = 0;
        int maxR = 0;
        int max = 0;
        if (node.left != null) {
            maxL = MaxDepth(node.left);
        }
        if (node.right != null) {
            maxR = MaxDepth(node.right);
        }
        max = Math.max(maxL + 1, maxR + 1);
        return max;

    }


}
