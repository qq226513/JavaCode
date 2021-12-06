package Wrapper;

public class IntegerTest {
    public static void main(String[] args) {
        Integer integer = 10;
        Integer integer1 = new Integer(11);

        int i = integer;
        int i1 = integer.intValue();
        String str = "" + new Integer(12);
        String str2 = new Integer(110).toString();
        String str3 = String.valueOf(10);
        Integer integer2 = Integer.parseInt(str);
        Integer integer3 = new Integer(str);
    }
}
