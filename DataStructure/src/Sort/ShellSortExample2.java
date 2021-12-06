package Sort;

import java.util.Arrays;

public class ShellSortExample2 {
    public static void main(String[] args) {
        Integer[] arr = {7,3,5,4,1,2,6};
        sort(arr);
        show(arr);
    }
    public static void sort(Comparable[] arr){
        int N = arr.length;
        int h = arr.length / 2;
        while (h >= 1){
            for (int i = 0; i < h; i++) {
                for (int j = i; j < arr.length; j++) {
                    int index = j;
                    Comparable temp = arr[index];
                    while (index >= h && less(temp,arr[index - h])){
                        index-=h;
                        arr[index + h] = arr[index];
                    }
                    arr[index] = temp;
                }
            }
            h /= 2;
        }
    }
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }
    public static void exchange(Comparable[] arr,int i,int j){
        Comparable temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void show(Comparable[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
