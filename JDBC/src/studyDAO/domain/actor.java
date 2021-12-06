package studyDAO.domain;

public class actor {
    private String name;
    private String company;
    private String works;
    private int sal;

    public actor() {
    }

    public actor(String name, String company, String works, int sal) {
        this.name = name;
        this.company = company;
        this.works = works;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "actor{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", works='" + works + '\'' +
                ", sal=" + sal +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }
}
