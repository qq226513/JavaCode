package studyCode.MyJDBC;

public class employee {
    private String name;
    private Integer id;
    private int sal;
    private String sex;
    private String address;
    private Integer age;

    public employee() {
    }

    public employee(String name, int id, int sal, String sex, String address, int age) {
        this.name = name;
        this.id = id;
        this.sal = sal;
        this.sex = sex;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sal=" + sal +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
