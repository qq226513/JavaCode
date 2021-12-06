package List;

import java.util.*;

public class HomeWork02 {
    public static void main(String[] args) {
        Map map = new HashMap();
        sal sal1 = new sal(10000, "张三");
        sal sal2 = new sal(10000, "李四");
        map.put(sal1.getName(), sal1.getMoney());
        map.put(sal2.getName(), sal2.getMoney());
        Set set = map.keySet();
        for (Object obj :
                set) {
            System.out.println(obj + " " + map.get(obj));
        }
        Collection values = map.values();
        for (Object obj :
                values) {
            System.out.println(obj);
        }
    }
}

class sal {
    int money;
    String name;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public sal(int money, String name) {
        this.money = money;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        sal sal = (sal) o;
        return money == sal.money &&
                Objects.equals(name, sal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, name);
    }

    @Override
    public String toString() {
        return "sal{" +
                "money=" + money +
                ", name='" + name + '\'' +
                '}';
    }
}
