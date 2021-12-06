package Sort;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {4,6,5,2,1,3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right){
            return;
        }
        int base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {

            //从右边找比基准数小的
            while (arr[j] >= base && i < j) {
                j--;
            }
            //从左边找比基准数大的
            while (arr[i] <= base && i < j) {
                i++;
            }
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;
        if (i > left) {
            quickSort(arr, left, i - 1);
        }
        if (j < right) {
            quickSort(arr, j + 1, right);
        }

    }


}
