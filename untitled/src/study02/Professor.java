package study02;

public class Professor extends Teacher{
    private double level;

    public Professor(String name, int age, String post, double basicSalary, double level) {
        super(name, age, post, basicSalary);
        this.level = level;
    }

    @Override
    public String introduce() {
        return "姓名："+getName()+" 年龄："+getAge()+" 职称："+getPost()+" 基本工资："+getBasicSalary()*level;
    }
}
