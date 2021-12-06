package Sort;

import java.util.Arrays;

public class InsertSortTest2 {
    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 3, 9, 4, 2, 1};
        int h = arr.length / 2;
        while (h >= 1){
            for (int i = 0; i < h; i++) {
                for (int j = i; j < arr.length; j+=h) {
                    int index = j;
                    int temp = arr[index];
                    while (index >= h && temp < arr[index - h]) {
                        index -= h;
                        arr[index + h] = arr[index];
                    }
                    arr[index] = temp;

                }
            }
            h /= 2;
        }
        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < arr.length / 2; i++) {
//            for (int j = i; j < arr.length; j += 4) {
//                int index = j;
//                int temp = arr[index];
//                while (index >= 4 && temp < arr[index - 4]) {
//                    index -= 4;
//                    arr[index + 4] = arr[index];
//                }
//                arr[index] = temp;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < arr.length / 2 / 2; i++) {
//            for (int j = i; j < arr.length; j += 2) {
//                int index = j;
//                int temp = arr[index];
//                while (index >= 2 && temp < arr[index - 2]) {
//                    index -= 2;
//                    arr[index + 2] = arr[index];
//                }
//                arr[index] = temp;
//            }
//        }
//        for (int i = 0; i < arr.length / 2 / 2 /2; i++) {
//            for (int j = i; j < arr.length; j++) {
//                int index = j;
//                int temp = arr[index];
//                while (index >= 1 && temp < arr[index - 1]) {
//                    index--;
//                    arr[index + 1] = arr[index];
//                }
//                arr[index] = temp;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }
}
