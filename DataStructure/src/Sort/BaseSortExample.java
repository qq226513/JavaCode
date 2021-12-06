package Sort;

import java.util.Arrays;

public class BaseSortExample {
    public static void main(String[] args) {
        int[] arr = {31, 14, 134, 542, 426, 188};
        sort(arr);
    }

    public static void sort(int[] arr) {
        int N = 9;
        int L = arr.length;
        int max = arr[0];//数组中最大的数
        int maxPlace = 0;//最大的数的位数
        int[] temp = new int[arr.length];//临时数组
        int[] place;//位数数组
        //获取max
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //获取maxPlace
        maxPlace = (max + "").length();
        //外循环，外循环次数 = maxPlace
        //n用于控制获取位数
        for (int i = 0, n = 1; i < maxPlace; i++, n *= 10) {

            //初始化位数数组
            place = new int[arr.length];
            //获取位数，并存入place
            for (int j = 0; j < arr.length; j++) {
                place[j] = arr[j] / n % 10;
            }
            int index = 0;//添加元素时temp的下标
            //创建桶 ,即0~9的数组
            System.out.println("place"+Arrays.toString(place));
            for (int j = 0; j <= N; j++) {
                //桶的下标
                int num = 0;
                //桶
                int[] a = new int[arr.length];
                //根据place数组为桶赋值
                for (int k = 0; k < place.length; k++) {
                    //place[k] 对应 arr[k]
                    if (j == place[k]) {
                        a[num++] = arr[k];
                    }
                }
                //将桶中元素顺序加入temp数组中
                for (int k = 0; k < a.length; k++) {
                    if (a[k] == 0){
                        break;
                    }
                    temp[index++] = a[k];
                }
            }
            //将temp的值拷贝到arr中
            for (int j = 0; j < arr.length; j++) {
                arr[j] = temp[j];

            }
            System.out.println("temp"+Arrays.toString(temp));
        }


        }

    }

