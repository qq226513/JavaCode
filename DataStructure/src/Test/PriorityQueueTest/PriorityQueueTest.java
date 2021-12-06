package Test.PriorityQueueTest;

import DataStructrue.PriorityQueue.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>(10);
        pq.insert("d");
        pq.insert("e");
        pq.insert("f");
        pq.insert("g");
        pq.insert("h");
        pq.insert("a");
        pq.insert("b");
        pq.insert("c");
        for (int i = 0; i < 9; i++) {
            System.out.println(pq.delMax());

        }

    }
}
