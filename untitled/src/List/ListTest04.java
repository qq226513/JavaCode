package List;

import java.util.ArrayList;
import java.util.List;

public class ListTest04 {
    public static void main(String[] args) {
        car car1 = new car("宝马", 10000000, "张珊");
        car car2 = new car("奔驰", 20000000, "张珊");
        car car3 = new car("奥迪", 9000000, "张珊");
        List<car> list = new ArrayList();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                car carT = list.get(j);
                car carQ = list.get(j+1);
                if (carT.price > carQ.price){
                    list.set(j,carQ);
                    list.set(j+1,carT);
                }
            }
        }
        for (car c:
             list) {
            System.out.println(c);
        }
    }
}

class car {
    String brand;
    int price;
    String owner;

    public car(String brand, int price, String owner) {
        this.brand = brand;
        this.price = price;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", owner='" + owner + '\'' +
                '}';
    }
}
