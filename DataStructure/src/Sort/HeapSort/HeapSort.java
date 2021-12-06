package Sort.HeapSort;

import DataStructrue.Heap.Heap;

import javax.swing.*;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class HeapSort {
    public static void main(String[] args) {
        Integer[] arr = {61, 7, 8, 1, 2, 3, 4, 51};
        sort(arr);


    }

    public static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    public static void exchange(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static Comparable[] createHeap(Object[] arr) {
        Comparable[] heaps = new Comparable[arr.length + 1];
        for (int i = 1; i < arr.length + 1; i++) {
            heaps[i] = (Comparable) arr[i - 1];
            swim(heaps, i);
        }
        return heaps;
    }

    public static Comparable[] CreateHeap(Object[] arr){
        Comparable[] heaps = new Comparable[arr.length + 1];
        //将数组元素原封不动的拷贝到堆中
        for (int i = 1; i < heaps.length; i++) {
            heaps[i] = (Comparable) arr[i - 1];
        }
        //对堆的一半处做下沉处理
        for (int i = heaps.length/2; i < heaps.length; i++) {
            sink(heaps,i,heaps.length-1);
        }
        return heaps;
    }
    public static void swim(Comparable[] heaps, int k) {
        while (k > 1 && less(heaps, k / 2, k)) {
            exchange(heaps, k, k / 2);
            k = k / 2;
        }
    }

    public static void sort(Object[] arr) {
        Comparable[] heaps = CreateHeap(arr);
        sort(heaps,1,heaps.length-1);

    }
    public static void sort(Comparable[] heaps,int start,int end){
        if (start == end){
            return;
        }
        exchange(heaps,start,end);
        sink(heaps,start,end-1);
        sort(heaps,start,--end);
    }



    public static void sink(Comparable[] heaps, int k,int N) {
        while (2 * k < N) {
            int j = 2 * k;
            if (j < N  && less(heaps, j, j + 1)) j++;
            if (!less(heaps, k, j)) break;
            exchange(heaps, j, k);
            k = j;
        }
    }

}
