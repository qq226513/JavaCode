package Sort;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Arrays;

/**
 * @author 一台
 */
public class BaseSortTest {


    public static void main(String[] args) {
        int[] arr = {3, 13, 134, 542, 426, 188};
        baseSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();
        int N = 10;
        int[] onesPlace = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            onesPlace[i] = arr[i] % 10;
        }
        //i代表着个位为i的桶
        int index = 0;
        int[] temp = new int[arr.length];
        for (int i = 0; i <= N; i++) {
            int num = 0;
            int[] a = new int[5];
            //遍历装着个位的数组，如果相等，就将其放入对应的桶中
            for (int j = 0; j < onesPlace.length; j++) {
                if (i == onesPlace[j]) {
                    a[num++] = arr[j];
                }
            }
            //将每个桶内的数据都放入原数组中
            for (int j = 0; j < a.length; j++) {
                if (a[j] == 0) {
                    break;
                }
                temp[index++] = a[j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
        //关于十位
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 10) {
                onesPlace[i] = 0;
            }
            onesPlace[i] = arr[i] / 10 % 10;
        }
        int index2 = 0;
        for (int i = 0; i <= N; i++) {
            int num = 0;
            int[] a = new int[5];
            for (int j = 0; j < onesPlace.length; j++) {
                if (i == onesPlace[j]) {
                    a[num++] = arr[j];
                }
            }
            for (int j = 0; j < a.length; j++) {
                if (a[j] == 0) {
                    break;
                }
                temp[index2++] = a[j];
            }
        }
        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < arr.length; i++) {

            onesPlace[i] = arr[i] / 10 / 10 % 10;
        }
        int index3 = 0;
        for (int i = 0; i <= N; i++) {
            int num = 0;
            int[] a = new int[5];
            for (int j = 0; j < onesPlace.length; j++) {
                if (i == onesPlace[j]) {
                    a[num++] = arr[j];
                }
            }
            for (int j = 0; j < a.length; j++) {
                if (a[j] == 0) {
                    break;
                }
                temp[index3++] = a[j];
            }
        }

    }

    public static void baseSort(int[] arr) {
        int N = 10;
        int L = arr.length;
        int max = arr[0];
        int maxPlace = 0;
        int[] temp = new int[arr.length];
        //找到数组中的最大值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //判断最大值有几位数
        while (max != 0) {
            max /= 10;
            maxPlace++;
        }
        //最大几位数就循环几次
        for (int i = 0, n = 1; i < maxPlace; i++, n *= 10) {
            int[] place = new int[N];
            //获取对应的位数并加入place数组
            for (int j = 0; j < arr.length; j++) {
                place[i] = arr[i] / n % 10;
            }
            int index = 0;//记录下标
            for (int j = 0; j < N; j++) {
                //桶数组的下标
                int num = 0;
                //创建桶
                int[] a = new int[5];
                //为桶中元素赋值
                for (int k = 0; k < place.length; k++) {
                    if (j == place[k]){
                        a[num++] = arr[k];
                    }
                }
                for (int m = 0; m < a.length; m++) {
                    if (a[m] == 0) {
                        break;
                    }
                    temp[index++] = a[m];
                }
            }
            for (int j = 0; j < arr.length; j++) {
                arr[j] = temp[j];

            }
        }


    }
}
