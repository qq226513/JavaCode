package study01;

import study01.Employee;

public class Worker extends Employee {
    private double level ;

    public Worker(String name, double daySalary, int day, double level) {
        super(name, daySalary, day);
        this.level = level;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double printSalary(){
        return super.printSalary()*getLevel();
    }
}
