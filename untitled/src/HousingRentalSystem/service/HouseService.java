package HousingRentalSystem.service;

import HousingRentalSystem.house.House;

import java.util.Scanner;

public class HouseService {

    private House[] Houses;//用于保存对象的数组
    private int num = 1;//对象个数
    private int idCounter = 1;//id计数器

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public HouseService(int size){
        Houses = new House[size];
        Houses[0] = new House(1,"张三",119,"海淀区",89999,true);
        
    }

    public House[] list(){//返回所有House对象
        return Houses;
    }

    public Boolean add(House house){//添加新对象
        if (num >= Houses.length){//对象数组已满，此时应数组扩容
            House[] newHouses = new House[Houses.length+10];
            for (int i = 0; i < Houses.length; i++) {
                newHouses[i] = Houses[i];
            }
            newHouses[Houses.length] = house;
            Houses = newHouses;

        }
        //将对象添加到当前数组的最后
        Houses[num++] = house;
        //将对象的id+1
        house.setNo(++idCounter);
        return true;


    }

    public boolean del(int id){

        //获取当前id所对应的House对象//让要删除对象指向空
        Houses[id-1] = null;
        if (id == num){//如果是数组最后一位，直接退出
            num--;
            return true;
        }
        for (int i = id; i < Houses.length-1; i++) {
            //所有对象往前挪
            Houses[i] = Houses[i+1];
        }
        num--;
        return true;
    }

    public House findHouse(int id){
        return Houses[id-1];
    }

    public void change(int id,String name,int tel,String address,int rent,boolean state){
        findHouse(id).setOwner(name);
        findHouse(id).setTelNumber(tel);
        findHouse(id).setRent(rent);
        findHouse(id).setState(state);
        findHouse(id).setAddress(address);
    }
}
