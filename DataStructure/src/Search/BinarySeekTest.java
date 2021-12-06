package Search;

import java.util.ArrayList;

public class BinarySeekTest {
    //二分查找：找数组的中间，每次都折半
    //优势：比顺序查找的数据量小很多
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1000, 1234};
        binarySeek03(arr, 0, arr.length - 1, 1);


    }

    public static void binarySeek(int[] arr, int left, int right, int key) {
        int findVal = key;
        int mid = (left + right) / 2;
        int i = left;
        int j = right;
        if (key > arr[mid]) {
            while (arr[j] != findVal) {
                if (j < mid) {
                    System.out.println("找不到");
                    return;
                }
                j--;
            }
            System.out.println(findVal + "位置在" + j);
        } else if (key < arr[mid]) {
            while (arr[i] != findVal) {
                if (i > mid) {
                    System.out.println("找不到");
                    return;
                }
                i++;
            }
            System.out.println(findVal + "位置在" + i);
        }
    }

    public static int binarySeek02(int[] arr, int left, int right, int key) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (key > midVal) {
            return binarySeek02(arr, mid + 1, right, key);
        } else if (key < midVal) {
            return binarySeek02(arr, left, mid - 1, key);
        } else {
            return mid;
        }
    }

    public static ArrayList<Integer> binarySeek03(int[] arr, int left, int right, int key) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (key > midVal) {
            return binarySeek03(arr, mid + 1, right, key);
        } else if (key < midVal) {
            return binarySeek03(arr, left, mid - 1, key);
        } else {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(mid);
            int index1 = mid - 1;
            while (index1 > 0 && arr[index1] == midVal) {
                integers.add(index1);
                index1--;
            }
            int index2 = mid + 1;
            while (index2 < right && arr[index2] == midVal) {
                integers.add(index2);
                index2++;
            }
            System.out.println(integers);
            return integers;
        }
    }
}
