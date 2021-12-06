package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest01 {
    public static void main(String[] args) {
        int[] arr = {12, 343, 5536, -23, 4};
//        bubble01(arr);
//        System.out.println(Arrays.toString(arr));
        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //这里返回的值影响了排序的方式
                int i1 = (Integer) o1;//arr[j]
                int i2 = (Integer) o2;//arr[j+1]
                //arr[j+1] - arr[j] > 0,就交换，即大在前就交换，即从大到小
                return i2 - i1;
            }
        });
        Book[] books = new Book[5];
        for (int i = 0; i < 5; i++) {
            books[i] = new Book("第"+(i+1)+"本书",i+1);
        }
        books[3] = new Book("s上",200);
        books[4] = new Book("上",200);
//        bubble03(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book b1 = (Book)o1;
//                Book b2 = (Book)o2;
//                return b1.price-b2.price;
//
//            }
//        });
        bubble03(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;
                return b1.name.length() - b2.name.length();
            }
        });
        System.out.println(Arrays.toString(books));
        System.out.println(Arrays.toString(arr));

    }

    //冒泡排序
    public static void bubble01(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //传入匿名内部类的冒泡排序
    public static void bubble02(int[] arr, Comparator c) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void bubble03(Book[] books, Comparator c) {
        Book temp = null;
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j], books[j + 1]) > 0) {
                    temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
        }
    }
}

class Book{
    String name;
    int price;
    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}