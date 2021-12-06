package study03;

public class Teachers extends Employee{
    private int  classDay;
    private double classSal;
    private double sal;

    public Teachers(String name, int age, char sex, int classDay, double classSal, double sal) {
        super(name, age, sex);
        this.classDay = classDay;
        this.classSal = classSal;
        this.sal = sal;
    }

    @Override
    public String introduce() {
        return super.introduce()+" 基本工资："+getSal()+" 实际工资："+(getSal()+getClassDay()*getClassSal());
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}
