package Map;

import java.util.*;

@SuppressWarnings("DuplicatedCode")
public class MapTest02 {
    public static void main(String[] args) {
        Map map = new HashMap();
        Book book1 = new Book(100, "百年孤独", "男人");
        Book book2 = new Book(150, "红楼梦", "男人");
        Book book3 = new Book(20, "变色龙", "男人");
        map.put(book1.getName(), book1.getPrice());
        map.put(book2.getName(), book2.getPrice());
        map.put(book3.getName(), book3.getPrice());
        Set set = map.keySet();
        for (Object obk :
                set) {
            System.out.println(obk + " " + map.get(obk));
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next+" "+map.get(next));
        }
        Set set1 = map.entrySet();
        for (Object obj :
                set1) {
            Map.Entry obj1 = (Map.Entry) obj;
            System.out.println(obj1.getKey()+" "+obj1.getValue());
        }
    }
}

class Book {
    int price;
    String name;
    String brand;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(brand, book.brand);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand);
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public Book(int price, String name, String brand) {
        this.price = price;
        this.name = name;
        this.brand = brand;
    }
}