package customGeneric;

public class GenericTest {

}

class Emp {
}

class Tiger<T, R, M> {
    //T,R,M是泛型的标识符，一般是单个大写字母，标识符可以有多个
    //1.普通成员可以使用泛型（属性，方法）
    //2.使用泛型的数组不能初始化
    //3.在泛型没指定类型时是object
    String name;
    T t;
    R r;
    M m;
    //数组在new的时候不能确定开辟的空间多大
    T[] ts;

    //4.静态方法和属性不能使用泛型，普通方法可以
    //因为static是和类相关，在类加载时，对象还没有创建，泛型只有在类创建的时候才会指定
    //那么JVM无法完成初始化
    public  void m(M m) {

    }

    public Tiger(String name, T t, R r, M m) {//方法使用泛型
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}
