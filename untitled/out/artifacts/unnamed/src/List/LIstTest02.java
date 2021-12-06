package List;

import jdk.nashorn.internal.ir.LexicalContext;
import jdk.nashorn.internal.ir.LexicalContextNode;
import 集合.iterator.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LIstTest02 {
    public static void main(String[] args) {
        Dog hua = new Dog("小花", 19);
        Dog ming = new Dog("小明", 19);
        Dog cai = new Dog("小菜", 19);
        List<Dog> list = new ArrayList();
        list.add(hua);
        list.add(ming);
        list.add(cai);
        for (Dog g:
             list) {
            System.out.println(g);
        }
        Iterator<Dog> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
