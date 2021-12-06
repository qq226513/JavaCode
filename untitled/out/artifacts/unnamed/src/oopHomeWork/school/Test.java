package oopHomeWork.school;

public class Test {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new Student("张三",'男',18,1);
        people[1] = new Student("李四",'男',58,2);
        people[2] = new Teacher("张三一",'男',48,19);
        people[3] = new Teacher("李四二",'男',68,23);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2){
                    break;
                }
                if (people[j].getAge() > people[j+1].getAge()){
                    Person p = null;
                    p = people[j];
                    people[j] = people[j+1];
                    people[j+1] = p;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(people[i].toString());
        }
    }
}
