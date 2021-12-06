package String;

public class HomeWork2 {
    public static void main(String[] args) {
        String s1 = "fas";
        Ani ani = new Ani(s1);
        Ani ani2 = new Ani(s1);
        System.out.println(ani.equals(ani2));
        s1.intern();

    }
}

class Ani{
    String name;

    public Ani(String name) {
        this.name = name;
    }
}