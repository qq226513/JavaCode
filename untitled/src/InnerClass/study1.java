package InnerClass;
//局部内部类
//1.局部内部类的位置一般在外部类的成员方法中
//2.局部内部类实际上相当于局部变量的地位，不可以添加修饰符，但是可以使用final来修饰，作用域就在方法体内
//3.内部类的本质还是一个类
public class study1 {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.m2();
    }
}

class Outer01{
    private int num = 8;

    private void m1(){
        System.out.println("m1()");
    }
    public void m2(){

        class Inner01{//局部内部类
            int num = 10;
            public void f1(){
                m1();
                System.out.println(Outer01.this.num);
                System.out.println(num);
            }

        }
        new Inner01().f1();
    }
}