package Test;

import DataStructrue.Tree.BinaryTree;

import javax.swing.text.StyledEditorKit;
import java.util.Queue;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        //添加测试
        tree.put(5, "张三");
        tree.put(2, "张四");
        tree.put(3, "张我");
        tree.put(4, "张了");
        tree.put(8, "张哦");
        tree.put(6, "是否");
        tree.put(7, "张热");

//        //查询测试
//        System.out.println(tree.get(5));
//        System.out.println("===========");
//
//
//        //删除测试
//        tree.delete(7);
//        tree.show(tree.root);
        //查找父节点测试
       // System.out.println(tree.searchFatherNode(tree.root,8));
        //删除测试
//        tree.deleteNode(tree.root,6);
//        tree.show(tree.root);
        //层序遍历测试
//        Queue<Integer> integers = tree.SequenceT();
//        for (Integer i:
//                integers
//             ) {
//            System.out.println(tree.get(i));
//        }
        //最大深度测试
        System.out.println(tree.MaxDepth(tree.root));
    }
}
