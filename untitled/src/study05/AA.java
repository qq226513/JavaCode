package study05;

public class AA {
    public static void main(String[] args) {
        new BB();
        GirlFriend.getInstance();
    }
}
class BB extends CC{
    public static int num = getN();
    static {
        System.out.println("BB");
    }
    {
        System.out.println("BBputong");
    }
    public static int getN(){
        return 10;
    }
    public BB(){
        System.out.println("BBwucan");
    }
}
class CC {
    public static int num = getNum();
    static {
        System.out.println("CC");
    }
    {
        System.out.println("CCputong");
    }
    public static int getNum(){
        System.out.println("CC getNum");
        return 10;
    }
    public CC(){
        System.out.println("CCwucan");
    }
}
class GirlFriend{
    private String name;
    private GirlFriend(String name) {
        this.name = name;
    }
    private static GirlFriend gf = new GirlFriend("张三");
    public static GirlFriend getInstance(){
        return gf;
    }
}

class Cat{
    private static Cat cat;
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    private Cat(){

    }

    public static Cat getInstance(){
        if (cat == null){
            cat = new Cat("三七");
        }
        return cat;
    }
}