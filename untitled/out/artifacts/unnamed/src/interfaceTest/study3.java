package interfaceTest;

public class study3 {
    public static void main(String[] args) {
        LittleMonkey wukong = new LittleMonkey("悟空");
        wukong.flying();
        wukong.swimming();
        wukong.climb();

    }
}

class Monkey{
    private String name;

    public Monkey() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Monkey(String name) {
        this.name = name;
    }
    public void climb(){
        System.out.println("猴子天生会爬树。");
    }
}

class LittleMonkey extends Monkey implements fish,bird{

    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void flying() {
        System.out.println("通过学习，猴子会飞了");
    }

    @Override
    public void swimming() {
        System.out.println("通过学习，猴子会游泳了");
    }
}
interface bird{
    void flying();
}
interface fish{
    void swimming();
}