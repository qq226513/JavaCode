package DataStructrue.PriorityQueue;

import javax.imageio.stream.IIOByteBuffer;

public class PriorityQueue<T extends Comparable<T>> {
    int N;
    T[] items;

    public PriorityQueue(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
    }

    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exchange(int i, int j) {
        T t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

    public void insert(T cmp) {
        //如果数组中没有元素则直接加入
        if (N == 0) {
            items[++N] = cmp;
            return;
        }
        //与当前数组的最大值进行比较
        //如果大于或等于则直接插入最末尾
        if (!less(cmp, items[N])) {
            items[++N] = cmp;
        } else if (less(cmp, items[1])) {//如果比最小的元素小则插入第一个
            if (N >= 0) System.arraycopy(items, 1, items, 2, N);
            items[1] = cmp;
            N++;
        } else {//否则就找到应在的位置
            for (int i = 2; i < N; i++) {
                if (less(cmp,items[i])){
                    if (N - 1 >= 0) System.arraycopy(items, 2, items, 3, N - 1);
                    items[i] = cmp;
                    break;
                }

            }
            N++;
        }
    }

    public T delMax() {
        if (N == 0) {
            return null;
        }
        T max = items[N];
        items[N--] = null;
        return max;
    }
}
