package DataStructrue.Tree.HuffmanTree;

import DataStructrue.Tree.smallHeap.smallHeap;
import jdk.nashorn.internal.runtime.RewriteException;

import java.util.Arrays;

public class HuffmanTree {
    public static void main(String[] args) {
        smallHeap sH = new smallHeap(10);
        sH.insert(1);
        sH.insert(2);
        sH.insert(6);
        sH.insert(4);
        sH.insert(7);
        sH.insert(3);
        Integer result = 0;
        while ((result = (Integer) sH.delMax())!=null){
            System.out.println(result);
        }
    }
    public static void createHuffmanTree(int[] arr) {
        //创建一个数组，长度为2length - 1
        int[] arrNew = new int[2*arr.length - 1];
        Arrays.fill(arrNew, 0);
        int first = arr[0];
        int second = arr[1];
        int root = first + second;
        arrNew[0] = root;
        arrNew[1] = first;
        arrNew[2] = second;
        arr[0] = -1;
        arr[1] = root;
        Arrays.sort(arr);

    }
}
