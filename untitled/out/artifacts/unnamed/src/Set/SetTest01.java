package Set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        Set<user>set = new HashSet(10);
            set.add(new user("张安",10));
            set.add(new user("张安",11));
            set.add(new user("张",10));
        for (user u:
             set) {
            System.out.println(u);
        }
    }
}
class user{
    String name;
    int age;

    public user(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
