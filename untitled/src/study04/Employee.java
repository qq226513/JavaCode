package study04;

import java.util.Objects;

public class Employee {
    private String name;
    private double monthSalary;

    public Employee(String name, double monthSalary) {
        this.name = name;
        this.monthSalary = monthSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    public double getAnnual(){
        return 12*getMonthSalary();
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if(o instanceof Employee){
        return this.name.equals(((Employee) o).getName())&&this.monthSalary == ((Employee) o).getMonthSalary();
    }
    return false;
    }
}
