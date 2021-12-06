package DataStructrue.PriorityQueue;

import DataStructrue.Tree.BinaryTree;

import java.util.Queue;

//索引优先队列
public class IndexMinPQ<T extends Comparable<T>> {
    T[] items;//保存元素
    int[] pq;//保存下标
    int[] qp;//保存逆序下标
    int N;//保存元素个数

    public IndexMinPQ(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
        pq = new int[capacity + 1];
        qp = new int[capacity + 1];
        for (int i = 0; i < capacity + 1; i++) {
            pq[i] = -1;
            qp[i] = -1;
        }

    }

    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    public void insert(int k, T item) {
        N++;
        pq[N] = k;
        qp[k] = N;
        items[k] = item;
        swim(N);
    }

    public void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                exchange(k / 2, k);
            }
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (2 * k < items.length - 1) {
            int j = 2 * k;
            if (j < N && less(k, 2 * k + 1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    public void delete(int k) {
        exchange(k,pq[N]);
        items[pq[N--]] = null;
        swim(k);
        sink(k);
        qp[k] = -1;
    }

    public T min() {
        return items[pq[1]];
    }

    public int minIndex() {
        return pq[1];
    }

    public int delMin(){
        //将第一个元素与最后一个元素交换位置，并将元素个数减少
        int min = pq[1];
        exchange(min,N--);
        //将第一个元素下沉以恢复堆
        sink(N);
        //最后一个元素置空
        items[pq[N+1]] = null;
        //qp最后一个元素置空
        qp[pq[N+1]] = -1;
        return min;

    }

    public boolean isEmpty() {

        return true;
    }

    public int size() {
        return N;
    }

    public void exchange(int i, int j) {

    }
}
