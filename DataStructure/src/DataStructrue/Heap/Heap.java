package DataStructrue.Heap;

import DataStructrue.Tree.BinaryTree;
import DataStructrue.Tree.OrigamiTest;

public class Heap<T extends Comparable<T>> {
    //存储堆中的元素
    T[] items;
    //记录堆中的元素个数
    int N;

    public Heap(int capacity) {
        //由于0节点置空，所以需要容量+1
        items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    //比较方法
    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    //交换方法
    public void exchange(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //往堆中插入元素
    public void insert(T item) {
        items[++N] = item;
        swim(N);
    }

    //上浮方法
    public void swim(int k) {
        //找到一个更大的父节点就停止
        while (k > 1 && less(k / 2, k)) {
            //与节点进行比较，如果当前节点大于父节点则进行交换
            exchange(k / 2, k);
            //更新当前节点的位置
            k = k / 2;
        }

    }

    //删除堆中最大的元素，并返回
    public T delMax() {
        T max = items[1];
        //与堆中最后一个元素交换
        exchange(1, N);
        //删除堆中最后一个元素
        items[N--] = null;
        //让第一个元素下沉
        sink(1);
        return max;
    }

    //下沉方法
    public void sink(int k) {
        while (2 * k < N) {//在堆的底层时停止
            //与子节点中较大的那一个进行交换
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (less(j, k)) break;
            exchange(k, j);
            //更新当前节点的位置
            k = j;

        }

    }

    public void show() {
        int size = 0;
        System.out.print("[");
        while (size < N && items[++size] != null) {
            System.out.print(items[size] + " ");
        }
        System.out.println("]");
    }

}
