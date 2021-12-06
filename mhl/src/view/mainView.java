package view;

import Utils.Utility;
import domain.bill;
import domain.eat_table;
import domain.menu;
import service.billService;
import service.employeeService;
import service.menuService;
import service.tableService;

import java.util.Date;
import java.util.List;

public class mainView {
    private tableService TService = new tableService();
    private employeeService EService = new employeeService();
    private menuService MService = new menuService();
    private billService BService = new billService();

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

    public boolean check(String username, String password) {
        return EService.check(username, password);
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
                    List<eat_table> tables = TService.show();
                    for (eat_table e :
                            tables) {
                        System.out.println(e);
                    }
                    break;
                case "2":
                    System.out.println("请输入你要预定的餐桌");
                    int i1 = Utility.readInt();
                    if (i1 < TService.getTableNums() && TService.getState(i1) == 0) {
                        System.out.println("请输入您的姓名");
                        String name = Utility.readString(20);
                        System.out.println("请输入您的电话号码");
                        String tel = Utility.readString(11);
                        TService.book(name, tel, i1);
                    }
                    break;
                case "3":
                    List<menu> menus = MService.show();
                    for (menu m :
                            menus) {
                        System.out.println(m);
                    }
                    break;
                case "4":
                    System.out.println("请输入你要点菜的餐桌");
                    int table_id = Utility.readInt();
                    if (table_id <= TService.getTableNums()) {
                        System.out.println("请输入你要点的菜的菜号");
                        int foodId = Utility.readInt();
                        if (MService.check(foodId)) {
                            String foodName = MService.getName(foodId);
                            System.out.println("请输入你要点的份数");
                            int nums = Utility.readInt();
                            int price = nums * MService.getPrice(foodId);
                            TService.consume(price, table_id);
                            TService.occupy(table_id);
                            BService.insert(foodName + (nums + "份"), price, table_id);
                            System.out.println("点餐成功!");
                        } else {
                            System.out.println("你输入的菜号不正确");
                        }
                    } else {
                        System.out.println("你输入的餐桌号不正确");
                    }
                    break;
                case "5":
                    System.out.println("5.查看账单");
                    List<bill> bills = BService.show();
                    for (bill b :
                            bills) {
                        System.out.println(b);

                    }
                    break;
                case "6":
                    System.out.println("请输入您要结账的餐桌号：");
                    int id = Utility.readInt();
                    if (id <= TService.getTableNums() && TService.getState(id) == 2) {
                        System.out.println("您要支付的金额是：");
                        int consume = TService.getConsume(id);
                        System.out.println(consume);
                        System.out.println("请输入你的付款方式：");
                        System.out.println("1.支付宝");
                        System.out.println("2.微信");
                        System.out.println("3.现金");
                        System.out.println("4.刷卡");
                        String key = Utility.readString(1);
                        String content = "";
                        switch (key) {
                            case "1":
                                content = "支付宝支付" + consume;
                                break;
                            case "2":
                                content = "微信支付" + consume;
                                break;
                            case "3":
                                content = "现金支付" + consume;
                                break;
                            case "4":
                                content = "刷卡支付" + consume;
                                break;
                        }
                        BService.insert(content, consume, id);
                        TService.settlement(id);
                        System.out.println("支付成功");
                    }
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
