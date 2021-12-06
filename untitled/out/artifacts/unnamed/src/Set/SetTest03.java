package Set;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

public class SetTest03 {
    public static void main(String[] args) {
        LinkedHashSet<car> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(new car(100000,"长安","查三"));
        linkedHashSet.add(new car(1000000,"长安","查三"));
        linkedHashSet.add(new car(100009,"长安","查三"));
        linkedHashSet.add(new car(102000,"长安","查三"));
        for (car c:
             linkedHashSet) {
            System.out.println(c);
        }

    }
}
class car{
    int price;
    String brand;
    String owner;

    @Override
    public String toString() {
        return "car{" +
                "price=" + price +
                ", brand='" + brand + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        car car = (car) o;
        return price == car.price &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, brand, owner);
    }

    public car(int price, String brand, String owner) {
        this.price = price;
        this.brand = brand;
        this.owner = owner;
    }
}
