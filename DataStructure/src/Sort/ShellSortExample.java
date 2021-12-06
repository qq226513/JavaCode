package Sort;

import java.util.Arrays;

public class ShellSortExample {
    public static void main(String[] args) {
        Shoes s1 = new Shoes(5);
        Shoes s2 = new Shoes(2);
        Shoes s3 = new Shoes(1);
        Shoes s4 = new Shoes(3);
        Shoes s5 = new Shoes(4);
        Shoes[] factory = new Shoes[5];
        factory[0] = s1;
        factory[1] = s5;
        factory[2] = s4;
        factory[3] = s2;
        factory[4] = s3;
        sort(factory);
        show(factory);

    }

    public static void sort(Comparable[] arr) {
        int N = arr.length;
        int h = N / 2;
        while (h >= 1) {
            for (int m = 0; m < h; m++) {
                for (int i = m; i < N; i+=h) {
                    for (int j = i; j > m && less(arr[j], arr[j - h]); j-=h) {
                        exchange(arr, j, j - h);
                    }
                }
            }
            h /= 2;
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void show(Comparable[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}

class Shoes implements Comparable<Shoes> {
    int value;

    @Override
    public String toString() {
        return "Shoes{" +
                "value=" + value +
                '}';
    }

    public Shoes(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Shoes o) {
        if (this.value > o.value) {
            return 1;
        } else if (this.value < o.value) {
            return -1;
        }
        return 0;
    }
}
