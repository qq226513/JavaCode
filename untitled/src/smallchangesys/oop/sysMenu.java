package smallchangesys.oop;

import java.util.Date;

public class sysMenu {
    public void Menu(){
        smallChangeSystem smallChangeSystem = new smallChangeSystem();
        do {
            System.out.println("\n=================零钱通菜单=================");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");
            System.out.print("请选择（1-4）：");
            int num = smallChangeSystem.scanner.nextInt();
            switch (num){
                case 1:
                   smallChangeSystem.showDetails();
                    break;
                case 2:
                   smallChangeSystem.income();
                    break;
                case 3:
                    smallChangeSystem.outcome();
                    break;
                case 4:
                    smallChangeSystem.exit();
                    break;
                default:
                    System.out.print("你输入的内容有误，请重新输入：");
            }
        }while (smallChangeSystem.loop);
    }
}
