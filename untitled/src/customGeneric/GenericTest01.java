package customGeneric;

public class GenericTest01 {
}
//定义接口类
//1.接口的泛型类型在实现或继承接口时指定
//2.静态不可使用泛型
//3.在接口中不能定义泛型变量，因为接口中的变量都是静态的
interface See<T,R,M>{
    R getR();
    T getT();
    M getM();

}
//继承时指定了泛型类型
interface B extends See{

}
//实现时会自动替换泛型类型
class BB implements B{

    @Override
    public Double getR() {
        return null;
    }

    @Override
    public String getT() {
        return null;
    }

    @Override
    public Integer getM() {
        return null;
    }
}