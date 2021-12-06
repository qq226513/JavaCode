package study03;

public class Peasant extends Employee{
    private double sal;

    public Peasant(String name, int age, char sex, double sal) {
        super(name, age, sex);
        this.sal = sal;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String introduce() {
        return super.introduce()+" 基本工资："+getSal()+" 实际工资："+getSal();
    }
}
