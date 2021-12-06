package oopHomeWork.school;

public class Teacher extends Person{
    public int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }
    public void teach(){
        System.out.println("我是老师，我会认真教书");
    }

    @Override
    public String play(Person person) {
        return person.getName()+"爱踢足球";
    }

    @Override
    public String toString() {
        return super.toString()+"Teacher{" + "work_age=" + work_age + '}';
    }
}
