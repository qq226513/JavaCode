package Sort;


//关于选择排序的注意
//1.选择排序之所以叫选择排序，是因为本质是从剩余的元素中选择最小的一个与最开始的元素交换
//2.选择排序只交换n次，就可以获得需要的序列，所以时间复杂度为O(n);
public class SelectSortExample {
    public static void main(String[] args) {
        Car[] factory = new Car[10];
        for (int i = 0; i < 10; i++) {
            if (i%3 == 0){
                factory[i] = new Car((i*10000)-42324);
            }else
            factory[i] = new Car((i+1)*100);
        }
        if (!isSorted(factory)){
            sort(factory);
            show(factory);
        }else {
            System.out.println("序列是有序的");
        }
    }
    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {//需要交换n次
            int min = i;//假定最小的就是第一个
            for (int j = i+1; j < arr.length; j++) {//从剩余的元素中选择最小的元素更新min
                if (less(arr[j],arr[min])){
                    min = j;
                }
            }
            exchange(arr,i,min);//将min与第一个元素进行交换
        }
    }
    public static void exchange(Comparable[] arr,int i,int j){
        Comparable temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static boolean less(Comparable<Comparable> v, Comparable w){//从小到大
        return v.compareTo(w) < 0;
    }
    public static void show(Comparable[] arr){
        for (Comparable comparable:arr
             ) {
            System.out.println(comparable.toString());
        }
    }
    public static boolean isSorted(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (!less(arr[i],arr[i+1])){
                return false;
            }
        }
        return true;
    }
}
class Car implements Comparable<Car>{
    int value;

    public Car(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Car{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Car car) {
        if (this.value > car.value){
            return 1;
        }else if (this.value < car.value){
            return -1;
        }
        return 0;
    }
}