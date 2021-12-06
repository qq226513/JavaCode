package View;

import DAO.BasicDAO;
import DAO.empDAO;
import Service.EmployeeService;
import Service.MenuService;
import Service.billService;
import Service.tableService;
import Utils.JDBCUtilsByDruid;
import Utils.Utility;
import domain.Menu;
import domain.bill;
import domain.person;
import domain.table;
import org.apache.commons.dbutils.QueryRunner;

import javax.sound.sampled.AudioFileFormat;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Login {
    EmployeeService EService = new EmployeeService();
    tableService TService = new tableService();
    MenuService MService = new MenuService();
    billService BService = new billService();
    int choice;

    public void home() {
        if (firstMenu()) {
            secondMenu();
        }
    }

    public boolean firstMenu() {
        System.out.println("欢迎来到满汉楼系统!");
        boolean loop = false;
        do {
            System.out.println("输入1登录");
            System.out.println("输入2退出");
            String choice = Utility.readString(1);
            //登录
            switch (choice) {
                case "1":
                    login();
                    loop = false;
                    break;
                case "2":
                    System.out.println("已退出");
                    return false;
                default:
                    System.out.println("你的输入有误，请重新输入");
                    loop = true;

            }
        } while (loop);
        return true;
    }


    //进行登录
    public void login() {
        boolean flag = false;
        String username = "";
        String password = "";
        do {
            System.out.println("请输入用户名：");
            username = Utility.readString(50);
            System.out.println("请输入密码：");
            password = Utility.readString(20);
            if (check(username, password)) {
                System.out.println("登录成功");
                flag = false;
            } else {
                System.out.println("您输入的用户名或密码无效，请重新输入");
                flag = true;
            }
        } while (flag);
    }

    //进行用户名和密码的校验
    public boolean check(String emp_id, String password) {
        try {
            return EService.check(emp_id, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void secondMenu() {
        boolean loop = true;
        do {
            System.out.println("=====满汉楼二级菜单=====");
            System.out.println("1.显示餐桌状态");
            System.out.println("2.预定餐桌");
            System.out.println("3.显示所有菜单");
            System.out.println("4.点餐服务");
            System.out.println("5.查看账单");
            System.out.println("6.结账");
            System.out.println("0.退出满汉楼系统");
            System.out.println("请输入你要的操作");
            String i = Utility.readString(1);
            switch (i) {
                case "1":
                    System.out.println("1.显示餐桌状态");
                    List<table> tables = TService.show();
                    for (table t :
                            tables) {
                        System.out.println(t);
                    }
                    break;
                case "2":
                    System.out.println("请输入您要预定的餐桌号：");
                    choice = Utility.readInt();
                    if (choice > TService.getNum()) {
                        System.out.println("你输入的餐桌号不存在");
                        break;
                    } else if (TService.getState(choice) != 0) {
                        System.out.println("你输入的餐桌号已被预定，请重新选择");
                        break;
                    }
                    System.out.println("确定要预定吗？请输入Y或N");
                    String s = Utility.readString(1);
                    if (!"Y".equals(s)) {
                        break;
                    }
                    System.out.println("请输入您的名字和电话号码");
                    String s1 = Utility.readString(20);
                    String s2 = Utility.readString(11);
                    person person = new person(s1, s2);
                    TService.book(choice, person);
                    break;
                case "3":
                    List<Menu> menus = MService.show();
                    for (Menu m :
                            menus) {
                        System.out.println(m);
                    }
                    break;
                case "4":
                    int consume = 0;
                    System.out.println("请输入要点餐的桌号");
                    choice = Utility.readInt();
                    if (choice > TService.getNum()) {
                        System.out.println("你输入的餐桌号不存在");
                        break;
                    }
                    System.out.println("请输入要点的菜的id");
                    int id = Utility.readInt();
                    String name = MService.getName(id);
                    int price = MService.getPrice(id);
                    System.out.println("请问要点几份");
                    int nums = Utility.readInt();
                    price = price * nums;
                    System.out.println("请问如何支付");
                    System.out.println("1.支付宝");
                    System.out.println("2.微信");
                    System.out.println("3.现金");
                    System.out.println("4.刷卡");
                    System.out.println("如果不属于以上选项，则认为吃霸王餐");
                    String s3 = Utility.readString(1);
                    String s4 = "";
                    switch (s3) {
                        case "1":
                            s4 = "支付宝";
                            break;
                        case "2":
                            s4 = "微信";
                            break;
                        case "3":
                            s4 = "现金";
                            break;
                        case "4":
                            s4 = "刷卡";
                            break;
                        default:
                            s4 = "未付账";
                    }
                    //更改账单
                    bill bill = new bill(null, choice, (choice + price) * 998, id, nums, new Date(), price, s4);
                    consume += price;
                    BService.updateBill(bill);
                    //改变桌子的状态
                    TService.changeState(choice,2);
                    TService.setConsume(choice,consume);
                    break;
                case "5":
                    System.out.println("5.查看账单");
                    break;
                case "6":
                    System.out.println("6.结账");
                    break;
                case "0":
                    loop = false;
                    System.out.println("已退出！");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
        } while (loop);

    }
}
