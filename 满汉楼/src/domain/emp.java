package domain;


public class emp {
    private Integer id;
    private String emp_id;
    private String password;
    private String name;
    private String job;

    @Override
    public String toString() {
        return "emp{" +
                "emp_id='" + emp_id + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public emp(String emp_id, String password, String name, String job) {
        this.emp_id = emp_id;
        this.password = password;
        this.name = name;
        this.job = job;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public emp() {
    }
}
