package Sort;

import sun.security.x509.CertificateX509Key;

import java.util.Arrays;

public class QuickSortExample {
    public static void main(String[] args) {
        Integer[] arr ={5,4,6,1,3,2};
        sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(Comparable[] arr, int left, int right) {
        Comparable base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (more(arr[j], base) && i < j){
                j--;
            }
            while (less(arr[i], base) && i < j) {
                i++;
            }

            exchange(arr,i,j);
        }
        exchange(arr,left,i);
        if (i > left){
            sort(arr,left,i-1);
        }
        if (j<right){
            sort(arr,j+1,right);
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }
    public static boolean more(Comparable v, Comparable w) {
        return v.compareTo(w) >= 0;
    }
    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
