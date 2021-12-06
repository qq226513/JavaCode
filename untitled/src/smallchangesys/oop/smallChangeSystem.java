package smallchangesys.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallChangeSystem {
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String details = "";
    double income = 0;
    double outcome = 0;
    double balance = 0;
    String str = "";
    Date date = null;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm");

    public void showDetails(){//显示清单
        System.out.println(details);
    }

    public void income(){//收益
        System.out.println("进入收益入账");
        System.out.print("请输入你的收益金额：");
        date = new Date();
        income = scanner.nextDouble();
        if (income <= 0 | income >= 10000000){
            System.out.println("你输入的金额有误");
            return;
        }
        balance += income;
        details += "\n收益入账"+"\t+"+"income"+"\t"+simpleDateFormat.format(date)+"\t"+"余额\t"+balance;
    }

    public void outcome(){//消费
        System.out.println(" 请输入你的消费金额：");
        date = new Date();
        outcome = scanner.nextDouble();
        if (outcome<= 0){
            System.out.println("你输入的金额有误");
            return;
        }
        balance -= outcome;
        System.out.println("请输入你的消费备注：");
        str = scanner.next();
        details+= "\n"+str+"\t-"+income+"\t"+simpleDateFormat.format(date)+"\t"+"余额\t"+balance;
    }

    public void exit(){
        System.out.println("你确定要退出吗？（请输入y/n）：");

        while (true) {//单独来判断接收的是否为y/n
            str = scanner.next();
            if (str.equals("y") | str.equals("n")){
                break;
            }else {
                System.out.println("你输入的指令有误，请重新输入：");
            }
        }
        if (str.equals("y")){
            System.out.println("已退出!");
            loop = false;
        }
    }

}
