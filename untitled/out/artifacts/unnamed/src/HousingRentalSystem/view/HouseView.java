package HousingRentalSystem.view;

import HousingRentalSystem.house.House;
import HousingRentalSystem.service.HouseService;

import java.util.Scanner;

public class HouseView {
    boolean loop = true;
    HouseService service = new HouseService(1);
    Scanner scanner = new Scanner(System.in);
    String str = "";
    int num = 0;
    public void listHouse(){
        System.out.println("---------------房屋列表--------------");
        System.out.println("       编号       房主       电话       地址       租金       状态");
        for (int i = 0 ; i< service.list().length; i++){
            if (service.list()[i] == null){
                break;
            }
            System.out.println("       "+service.list()[i].getNo()
            +"       "+service.list()[i].getOwner()
            +"       "+service.list()[i].getTelNumber()
            +"       "+service.list()[i].getAddress()
            +"       "+service.list()[i].getRent()
            +"       "+service.list()[i].isState());
        }
    }

    public void addHouse(){
        System.out.println("---------------添加房屋--------------");
        System.out.println("姓名：");
        String name = scanner.next();
        System.out.println("电话：");
        int tel = scanner.nextInt();
        System.out.println("地址：");
        String address = scanner.next();
        System.out.println("月租：");
        int rent = scanner.nextInt();
        System.out.println("状态：(请输入true/false)");
        boolean state = scanner.nextBoolean();
        House house = new House(0,name,tel,address,rent,state);
        if (service.add(house)){
            System.out.println("添加成功！");
        }else{
            System.out.println("房源已满，添加失败！");
        }

    }

    public void delHouse(){//通过输入编号来删除房源
        System.out.println("---------------删除房屋--------------");
        System.out.println("请输入带删除房屋的编号（-1退出）：");
        num = scanner.nextInt();//输入的是id，所以比数组下标多1
        if (num == -1){//如果输入-1就退出
            return;
        }
        if (num == 0){
            System.out.println("数组已空，无法删除。");
            return;
        }

        if (num < 0||num > service.getIdCounter()){//如果比当前最大的id都大，或者id小于等于0，就不存在
            System.out.println("你输入的id不存在。");
            return;
        }
        if(service.del(num)){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }


    }

    public void changeInf(){
        System.out.println("---------------修改房屋信息--------------");
        System.out.println("请输入带修改房屋的编号（-1退出）：");
        num = scanner.nextInt();//输入的是id，所以比数组下标多1
        if (num == -1){//如果输入-1就退出
            return;
        }
        if (num <= 0||num > service.getIdCounter()){//如果比当前最大的id都大，或者id小于等于0，就不存在
            System.out.println("你输入的id不存在。");
            return;
        }
        System.out.println("姓名：");
        String name = scanner.next();
        System.out.println("电话：");
        int tel = scanner.nextInt();
        System.out.println("地址：");
        String address = scanner.next();
        System.out.println("月租：");
        int rent = scanner.nextInt();
        System.out.println("状态：(请输入true/false)");
        boolean state = scanner.nextBoolean();

        service.change(num,name,tel,address,rent,state);
    }

    public void findHouse(){
        System.out.println("---------------房屋查找--------------");
        System.out.println("请输入带查找房屋的编号（-1退出）：");
        num = scanner.nextInt();//输入的是id，所以比数组下标多1
        if (num == -1){//如果输入-1就退出
            return;
        }
        if (num <= 0||num > service.getIdCounter()){//如果比当前最大的id都大，或者id小于等于0，就不存在
            System.out.println("你输入的id不存在。");
            return;
        }
        System.out.println(service.findHouse(num).toString());
    }
    public void mainMenu(){
        do {
            System.out.println("---------------房屋出租系统--------------");
            System.out.println("1 新增房屋");
            System.out.println("2 查找房屋");
            System.out.println("3 删除房屋");
            System.out.println("4 修改房屋信息");
            System.out.println("5 房屋列表");
            System.out.println("6 退出");
            System.out.println("请选择（1-6）：");
            num = scanner.nextInt();
            switch (num){
                case 1:
                    System.out.println("新增房源");
                    addHouse();
                    break;
                case 2:
                    System.out.println("查找房屋");
                    break;
                case 3:
                    System.out.println("删除房源");
                    delHouse();
                    break;
                case 4:
                    System.out.println("4 修改房屋信息");
                    changeInf();
                    break;
                case 5:
                    System.out.println("5 房屋列表");
                    listHouse();
                    break;
                case 6:
                    System.out.println("6 退出");
                    loop = false;
                    break;

            }
        }while (loop);
    }
}
