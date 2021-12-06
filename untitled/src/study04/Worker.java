package study04;

import study04.Employee;

public class Worker extends Employee {

    public Worker(String name, double monthSalary) {
        super(name, monthSalary);
    }

    public void work(){
        System.out.println("工人会工作");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
