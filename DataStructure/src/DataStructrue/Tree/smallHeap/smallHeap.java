package DataStructrue.Tree.smallHeap;

public class smallHeap<T extends Comparable<T>> {
    T[] items;
    int N;

    public smallHeap(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
    }

    public void swim(int k) {
        //如果当前节点比父节点小，则上移
        while (k > 1 && less(k, k / 2)) {
            exchange(k, k / 2);
            //更新当前位置
            k = k / 2;
        }
    }
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
    public void sink(int k) {
        while (2 * k > items.length) {
            int j = 2 * k;
            if (j < N && !less(k, j + 1)) j++;
            if (less(k,j))break;
            exchange(k,j);
            k = j;
        }
    }

    public void insert(T t){
        items[++N] = t;
        swim(N);
    }
    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    public void exchange(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}
