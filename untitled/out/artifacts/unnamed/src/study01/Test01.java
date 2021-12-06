package study01;

import study01.Mananger;
import study01.Worker;

public class Test01 {
    public static void main(String[] args) {
        Mananger mananger = new Mananger("张三", 600, 31, 1.2);

        Worker worker = new Worker("李四", 200, 31, 1.0);
        double managerMoney = mananger.printSalary();
        double workerMoney = worker.printSalary();
        System.out.println("managerMoney = " + managerMoney + " workerMoney = " + workerMoney);
        System.out.println(~-5);
        System.out.println(~2);
        System.out.println(2 & 3);
        System.out.println(2 | 3);
        System.out.println(~-5);
        System.out.println(13 & 7);
        System.out.println(5 | 4);
        System.out.println(-3 ^ 3);
    }
}
