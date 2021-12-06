package domain;

public class employee {
    private Integer id;
    private String emp_id;
    private String name;
    private String password;
    private String job;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public employee() {
    }

    public employee(Integer id, String emp_id, String name, String password, String job) {
        this.id = id;
        this.emp_id = emp_id;
        this.name = name;
        this.password = password;
        this.job = job;
    }
}
