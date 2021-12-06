package smallchangesys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class mainMenu {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String details = "";
        double income = 0;
        double outcome = 0;
        double balance = 0;
        String str = "";
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm");
        do {
           System.out.println("\n=================零钱通菜单=================");
           System.out.println("\t\t\t1 零钱通明细");
           System.out.println("\t\t\t2 收益入账");
           System.out.println("\t\t\t3 消费");
           System.out.println("\t\t\t4 退出");
           System.out.print("请选择（1-4）：");
           int num = scanner.nextInt();
           switch (num){
               case 1:
                   System.out.println("----------零钱通明细----------");
                   System.out.println(details);
                   break;
               case 2:
                   System.out.println("进入收益入账");
                   System.out.print("请输入你的收益金额：");
                   date = new Date();
                   income = scanner.nextInt();
                   if (income <= 0 | income >= 10000000){
                       System.out.println("你输入的金额有误");
                       break;
                   }
                   balance += income;
                   details += "\n\t收益入账\t+"+income+"\t"+simpleDateFormat.format(date)+"\t"+"余额\t"+balance;
                   break;
               case 3:
                   System.out.println(" 请输入你的消费金额：");
                   date = new Date();
                   outcome = scanner.nextInt();
                   if (outcome<= 0){
                       System.out.println("你输入的金额有误");
                       break;
                   }
                   balance -= outcome;
                   System.out.println("请输入你的消费备注：");
                    str = scanner.next();
                   details+= "\n\t"+str+"\t-"+income+"\t"+simpleDateFormat.format(date)+"\t"+"余额\t"+balance;
                   break;
               case 4:
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
                   break;
               default:
                   System.out.print("你输入的内容有误，请重新输入：");
           }
       }while (loop);
    }

}
