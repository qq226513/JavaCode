package oopHomeWork.school;

public class Student extends Person{
    private int stu_id;

    public Student(String name, char sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public void study(){
        System.out.println("我是学生，我会好好学习");
    }
    @Override
    public String play(Person person) {
        return person.getName()+"爱下象棋";
    }

    @Override
    public String toString() {
        return super.toString()+"Student{" + "stu_id=" + stu_id + '}';
    }
}
