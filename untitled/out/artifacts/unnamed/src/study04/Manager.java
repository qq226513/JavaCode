package study04;

import study04.Employee;

import java.sql.SQLOutput;

public class Manager extends Employee {
    private double bounds;

    public Manager(String name, double monthSalary, double bounds) {
        super(name, monthSalary);
        this.bounds = bounds;
    }

    public double getBounds() {
        return bounds;
    }

    public void setBounds(double bounds) {
        this.bounds = bounds;
    }

    public void manage(){
        System.out.println("经理会剥削");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual()+bounds;
    }
}
