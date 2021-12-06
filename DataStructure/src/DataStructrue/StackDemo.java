package DataStructrue;

import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
        System.out.println("请输入栈的最大值：");
        Scanner sc = new Scanner(System.in);
        stack s = new stack(sc.nextInt());
        boolean loop = true;
        do {
            System.out.println("======操作如下======");
            System.out.println("1.入栈");
            System.out.println("2.出栈");
            System.out.println("3.遍历");
            System.out.println("4.结束");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("请输入要入栈的值");
                    s.pop(sc.nextInt());
                    break;
                case 2:
                    System.out.print("出栈的值为：");
                    System.out.println(s.push());
                    break;
                case 3:
                    System.out.println("遍历的结果为：");
                    s.list();
                    break;
                case 4:
                    loop = false;
                    System.out.println("系统结束");
            }
        } while (loop);
    }
}

class stack {
    int maxSize;
    int[] arr;
    int top = -1;

    public stack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
    }

    public void pop(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        arr[++top] = value;
    }

    public int push() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return arr[top--];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
