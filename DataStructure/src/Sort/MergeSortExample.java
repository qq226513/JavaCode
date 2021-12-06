package Sort;

import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author 一台
 */
public class MergeSortExample {
    private static Comparable[] temp;

    public static void main(String[] args) {
        Phone[] Apple = {new Phone(1), new Phone(4),
                new Phone(5), new Phone(6), new Phone(2),
                new Phone(3), new Phone(7)};
        mergeSort(Apple);
        System.out.println(Arrays.toString(Apple));

    }

    public static void mergeSort(Comparable[] arr) {
        temp = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);

    }

    public static void sort(Comparable[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(Comparable[] arr, int left, int mid, int right) {

        //左指针
        int i = left;
        //右指针
        int j = mid + 1;
        //先将arr数组复制到temp
        for (int k = left; k <= right; k++) {
            temp[k] = arr[k];
        }

        //再通过比较大小来讲temp的值赋给arr
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                //此时代表左边完了
                arr[k] = temp[j++];
            } else if (j > right) {
                //此时代表右边完了
                arr[k] = temp[i++];
            } else if (less(temp[j], temp[i])) {
                //如果temp[j]更小，就将temp[j]添加到arr，并且j++
                arr[k] = temp[j++];
            } else {
                //如果temp[i]更小，就将temp[i]添加到arr，并且i++
                arr[k] = temp[i++];
            }


        }

    }


    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

}

class Phone implements Comparable<Phone> {
    int price;

    @Override
    public int compareTo(Phone o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price < o.price) {
            return -1;
        } else {
            return 0;
        }
    }

    public Phone(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "price=" + price +
                '}';
    }
}