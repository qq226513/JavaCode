package study04;

public class Test04 {
    public static double showEmpAnnual(Employee employee){
        return employee.getAnnual();
    }
    public static void testWork(Employee employee){
        if(employee instanceof  Worker){
            ((Worker) employee).work();
        }
        if (employee instanceof  Manager){
            ((Manager) employee).manage();
        }
    }



    public static void main(String[] args) {
        Employee employee1 = new Worker("张三",5000);
        Employee employee3 = employee1;
        Employee employee4 = new Worker("张三",5000);
        Employee employee2 = new Manager("李四",20000,4302.4);
        System.out.println(showEmpAnnual(employee1));
        System.out.println(showEmpAnnual(employee2));
        testWork(employee1);
        testWork(employee2);
        System.out.println(employee1.equals(employee4));
        employee1 = null;



    }
}


