package InnerClass;

public class study2 {
    public static void main(String[] args) {
       CellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("起来学习");
            }
        });
    }
}
interface Bell{
    void ring();
}
class CellPhone{
    public static void alarmClock(Bell bell){
        bell.ring();
    }

}