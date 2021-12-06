package oopHomeWork;

public class PersonTest {
    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0] = new Person("zs","ft",39);
        persons[1] = new Person("zsf","ft",44);
        persons[2] = new Person("zsp","ft",33);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2){
                    break;
                }
                if (persons[j].getAge() > persons[j+1].getAge()){
                    Person p = null;
                    p = persons[j];
                    persons[j] = persons[j+1];
                    persons[j+1] = p;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(persons[i].toString());
        }
    }
}

class Person{
    private String name;
    private String job;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, String job, int age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}
