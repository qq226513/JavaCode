public class abstractTemplate {
    public static void main(String[] args) {
        BB2 b = new BB2();
        CC2 c = new CC2();
        b.caculateTime();
        c.caculateTime();
    }
}
abstract class AA2{
    public abstract void job();
    public void caculateTime(){
        long strat = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("执行时间"+(end-strat));
    }
}
class BB2 extends AA2{
    @Override
    public void job() {
        int num = 1;
        for (int i = 0; i < 100000; i++) {
            num *= i;
        }
    }
}
class CC2 extends AA2{
    @Override
    public void job() {
        int num = 0;
        for (int i = 0; i < 1000000; i++) {
            num += i;
        }
    }
}