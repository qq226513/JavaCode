package study03;

public class Scientist extends Employee{
    private double sal;
    private double bonus;

    public Scientist(String name, int age, char sex, double sal, double bonus) {
        super(name, age, sex);
        this.sal = sal;
        this.bonus = bonus;
    }

    @Override
    public String introduce() {
        return super.introduce()+" 基本工资："+sal+" 实际工资："+(getSal()+getBonus());
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
