package HomeWork;

public class HomeWork01 {
    public static void main(String[] args) {
        new Cellphone().testWork(new Caculate() {
            @Override
            public void work() {
                System.out.println("手机运算");
            }
        });
    }
}
class Cellphone {
    public void testWork(Caculate caculate){
        caculate.work();

    }
}

interface Caculate{
    void work();
}
