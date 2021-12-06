package interfaceTest;

public class study4 {
    public static void main(String[] args) {
        A a = new C();
        B b = new C();
        s((C)a);
    }
    public static void s(C c){

    }
}
interface A{
    void a();
}
interface B extends A{
    void b();
}
class C implements B{
    //因为B 继承了 A
    //所以相当于C 实现了 B 和 A
    //所以要实现两个方法
    @Override
    public void a() {

    }

    @Override
    public void b() {

    }
}