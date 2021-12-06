package List;

import java.util.*;

public class Homework04 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList();
        Employee e1 = new Employee(12000, "张安", new MyDate(1994, 10, 1));
        Employee e2 = new Employee(11000, "张安", new MyDate(1991, 10, 5));
        Employee e3 = new Employee(18000, "张安", new MyDate(1993, 10, 1));
        Employee e4 = new Employee(15000, "张安", new MyDate(1991, 10, 1));
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int i = o1.name.compareTo(o2.name);
                if (i != 0){
                    return i;
                }
                return o1.birthday.compareTo(o2.birthday);
            }
        });
        for (Employee e :
                list) {
            System.out.println(e);
        }
    }
}

class Employee {
    int sal;
    String name;
    MyDate birthday;

    public Employee(int sal, String name, MyDate birthday) {
        this.sal = sal;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "sal=" + sal +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year &&
                month == myDate.month &&
                day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int compareTo(MyDate date){
        int yearMinus = this.getYear() - date.getYear();
        if (yearMinus != 0){
            return yearMinus;
        }
        int monthMinus = this.getMonth() - date.getMonth();
        if (monthMinus != 0){
            return monthMinus;
        }
        int dayMinus = this.getDay() - date.getDay();
        if (dayMinus != 0){
            return dayMinus;
        }
        return 0;

    }

       public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
