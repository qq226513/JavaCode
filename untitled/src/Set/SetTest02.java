package Set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetTest02 {
    public static void main(String[] args) {
        Set<student> set = new HashSet();
        student s1 = new student(1, "张三", new myDate(1991, 10, 1));
        student s2 = new student(2, "张三", new myDate(1992, 10, 1));
        student s3 = new student(1, "张三", new myDate(1991, 10, 1));
        student s4 = new student(4, "张三", new myDate(1994, 10, 1));
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        for (student s:
             set) {
            System.out.println(s);
        }
    }
}
class student{
    int id;
    String name;
    myDate birthday;

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(birthday, student.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public student(int id, String name, myDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
}
class myDate{
    int month;
    int year;
    int day;

    public myDate(int month, int year, int day) {
        this.month = month;
        this.year = year;
        this.day = day;
    }

    @Override
    public String toString() {
        return "myDate{" +
                year +"年"
                + month +"月"
                + day +"日"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myDate myDate = (myDate) o;
        return month == myDate.month &&
                year == myDate.year &&
                day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, year, day);
    }
}
