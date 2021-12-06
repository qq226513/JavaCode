package Sort;

import java.util.logging.XMLFormatter;
//插入排序
/*
1.插入排序的思路是：初始将数组分为有序表（1）和无序表（n-1）两个表，而后将无序表中的第一个元素在有序表中寻找一个正确的位置，
然后将其插入到有序表的正确位置中
 */
public class InsertSortExample {
    public static void main(String[] args) {
        Watch watch = new Watch(100);
        Watch watch1 = new Watch(329);
        Watch watch2 = new Watch(1999);
        Watch watch3 = new Watch(499);
        Watch[] watchShop =new Watch[4];
        watchShop[0] = watch;
        watchShop[1] = watch1;
        watchShop[2] = watch2;
        watchShop[3] = watch3;
         if (isSorted(watchShop)){
             System.out.println("序列有序");
         }else {
             sort(watchShop);
             show(watchShop);
         }
    }
    public static void sort(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j],arr[j-1] ) ; j--) {
                exchange(arr,j,j-1);
            }

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
        for (Comparable comparable:
             arr) {
            System.out.println(comparable);
        }
    }
    public static boolean isSorted(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i],arr[i-1])){
                return false;
            }
        }
        return true;
    }
}
class Watch implements Comparable<Watch>{
    int value;

    public Watch(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Watch watch) {
        if (this.value > watch.value){
            return 1;
        }else if (this.value < watch.value){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Watch{" +
                "value=" + value +
                '}';
    }
}