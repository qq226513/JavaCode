package List;

import java.util.HashSet;
import java.util.Objects;

public class HomeWork03 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        person p1 = new person(100,"查飒");
        person p2 = new person(20,"发生");
        set.add(p1);
        p1.name = "启发";
        set.add(p2);
        set.remove(p1);
        set.add(new person(100,"启发"));
        set.add(new person(100,"查飒"));
        System.out.println(set);

    }
}

class person {
    int age;
    String name;

    @Override
    public String toString() {
        return "person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    public person(int age, String name) {
        this.age = age;
        this.name = name;
    }


}
