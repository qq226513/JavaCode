package List;

import java.util.LinkedList;

public class ListTest05 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("西欧奥华", 1);
        Cat cat2 = new Cat("西奥华", 1);
        Cat cat3 = new Cat("欧奥华", 1);
        LinkedList<Cat> linkedList = new LinkedList();
        linkedList.add(cat1);
        linkedList.add(cat2);
        linkedList.add(cat3);
        Cat last = linkedList.getLast();
        System.out.println(last);
        for (Cat c:
                linkedList
             ) {
            System.out.println(c);
        }
    }
}
class Cat{
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}