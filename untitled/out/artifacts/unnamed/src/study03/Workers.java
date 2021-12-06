package study03;

public class Workers extends Employee{
        private double sal;

    public Workers(String name, int age, char sex, double sal) {
        super(name, age, sex);
        this.sal = sal;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String introduce(){
        return super.introduce()+" 基本工资："+getSal();
    }
}
