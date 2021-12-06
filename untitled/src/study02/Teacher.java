package study02;

public class Teacher {
    private String name;
    private int age;
    private String post;
    private double basicSalary;

    public Teacher() {
    }

    public Teacher(String name, int age, String post, double basicSalary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.basicSalary = basicSalary;
    }

    public String introduce(){
        return "姓名："+getName()+" 年龄："+getAge()+" 职称："+getPost()+" 基本工资："+getBasicSalary();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
}
