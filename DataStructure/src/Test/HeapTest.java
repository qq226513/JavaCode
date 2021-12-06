package Test;

import DataStructrue.Heap.Heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap<Integer> Heaps = new Heap<>(10);
        Heaps.insert(1);
        Heaps.insert(1);
        Heaps.insert(2);
        Heaps.insert(3);
        Heaps.insert(4);
        Heaps.insert(5);
        Heaps.insert(6);
        Heaps.insert(7);
        Heaps.insert(8);
        Integer result = null;
        while ((result = Heaps.delMax()) != null){
            System.out.print(result+" ");
        }
//       Heaps.show();
//        System.out.println(Heaps.N);



    }
}
