package Sort;

import java.util.Arrays;

public class ShellSortTest {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 1, 2, 3};
        int num = arr.length / 2;
        //将元素分组输出
        for (int m = 0; m < 2; m++) {
            for (int i = m; i < arr.length; i += 2) {
                //将元素进行插入排序
                for (int j = i; j > m; j -= 2) {
                    if (arr[j] < arr[j - 2]) {
                        int temp = arr[j - 2];
                        arr[j - 2] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        int[] numbs = {111, 8, 9, 7, 6, 2, 1, 5, 4, 3, 10};
        int h = numbs.length / 2;
        while (h >= 1) {
            for (int m = 0; m < h; m++) {
                for (int i = m; i < numbs.length; i += h) {
                    for (int j = i; j > m; j -= h) {
                        if (numbs[j] < numbs[j - h]) {
                            int temp = numbs[j - h];
                            numbs[j - h] = numbs[j];
                            numbs[j] = temp;
                        }
                    }
                }
            }
            h /= 2;
        }
//        for (int m = 0; m < 5; m++) {
//            for (int i = m; i < numbs.length; i += 5) {
//                for (int j = i; j > m; j -= 5) {
//                    if (numbs[j] < numbs[j - 5]) {
//                        int temp = numbs[j - 5];
//                        numbs[j - 5] = numbs[j];
//                        numbs[j] = temp;
//                    }
//                }
//            }
//        }
//        for (int m = 0; m < 2; m++) {
//            for (int i = m; i < numbs.length; i += 2) {
//                for (int j = i; j > m; j -= 2) {
//                    if (numbs[j] < numbs[j - 2]) {
//                        int temp = numbs[j - 2];
//                        numbs[j - 2] = numbs[j];
//                        numbs[j] = temp;
//                    }
//                }
//            }
//        }
//        for (int m = 0; m < 1; m++) {
//            for (int i = m; i < arr.length; i += 1) {
//                for (int j = i; j > m; j--) {
//                    if (numbs[j] < numbs[j - 1]) {
//                        int temp = numbs[j - 1];
//                        numbs[j - 1] = numbs[j];
//                        numbs[j] = temp;
//                    }
//                }
//            }
//        }
        System.out.println(Arrays.toString(numbs));

    }
}
