package DataStructrue;

public class CircleQueue {
    public static void main(String[] args) {
        circleArray circleArray = new circleArray(5);
        circleArray.addQueue(10);
        circleArray.addQueue(20);
        circleArray.addQueue(30);
        circleArray.addQueue(40);
        circleArray.getQueue();
        circleArray.addQueue(50);
        circleArray.show();
    }
}
class circleArray{
    private int maxSize;
    private int front;//初始化值为0，指向数组的第一个元素
    private int rear;//初始值为0，指向数组的最后一个元素的后一位
    private int[] arr;

    public circleArray(int MaxSize) {
        this.maxSize = MaxSize;
        arr = new int[maxSize];
    }//数组初始化

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
      if (isFull()){
          return;
      }
      arr[rear] = n;
      rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if (isEmpty()){
            return -10000000;
        }
        int temp = arr[front];
        front = (front+1) % maxSize;
        return temp;
    }

    public int maxNum(){
        return(rear + maxSize - front) % maxSize;
    }

    public void show(){
        if (isEmpty()){
            return;
        }
        for (int i = front; i < front + maxNum(); i++) {
            System.out.println(arr[i % maxSize]);
        }
    }
}
