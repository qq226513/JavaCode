package String;

import java.util.Arrays;
import java.util.Scanner;

public class String1 {
    public static void main(String[] args) {
        String a = "hell";
        try {
            System.out.println(ReverseString(a,0,31));
        } catch (Exception e) {
            System.out.println("参数不正确");
        }
        String b = "ad";
        String c = a + b;
        Test test = new Test();
        test.change(test.s, test.chars);
        System.out.print(test.s + "and");
        String s = new String("");
        for (int i = 0; i < 10; i++) {
            s += "hellp";
            System.out.println(s);
        }
        System.out.println(s.length());

        String str = new String("abfaasfasfc");
        char[] buf = new char[10];
        buf[0] = 97;
        buf[1] = 99;
        System.out.println(str.equals("abc"));
        System.out.println(str.charAt(2));
        System.out.println(str.length());
        System.out.println(str.concat("fsadf"));//concat方法就是在原字符串之后添加，但是不会对原始str造成影响
        //getChars方法用于截取字符串的子字符串添加到字符数组中
        //srcBegin，srcEnd是指str的子字符串的开始和结尾，dstBegin是字符数组的复制开始的下标
        str.getChars(0, 2, buf, 1);
        //截取字符串
        System.out.println(str.substring(0, 4));
        System.out.println(str);
        //indexOf与lastIndexOf方法用于返回子字符串在字符中第一次出现和最后一次出现的位置
        System.out.println(str.indexOf("fas"));
        System.out.println(str.lastIndexOf("fas"));
        System.out.println(buf);
        //replace方法用于替换字符，参数是char类型，只能替换一个值
        System.out.println(str.replace('f', 'l'));
        //split方法用于分割字符串,即去掉指定字符，然后返回对应字符串数组
        String[] sss = str.split("f");
        for (int i = 0; i < sss.length; i++) {
            System.out.print(sss[i]);
        }
        System.out.println(
        );
        System.out.println(str);


        System.out.println("======================");
        //StringBuffer初始化为长度为16的char数组
        StringBuffer sb = new StringBuffer();
        //StringBuffer初始化为长度为100的char数组
        StringBuffer sb2 = new StringBuffer(100);
        //StringBuffer初始化为长度为16+str.length的char数组
        StringBuffer sb3 = new StringBuffer(str);
        //String -- 》 StringBuffer
        //1.使用append方法
        sb.append(str);
        //2.使用StringBuffer的构造方法,本质还是调用了append方法
        sb2 = new StringBuffer(str);

        //StringBuffer -- > String
        //1.使用StringBuffer的toString方法
        //2.使用String的构造方法
        String st = new String(sb);

        //append方法
        sb3.append("fasfsa");
        System.out.println(sb3);
        //delete,取头不取尾
        sb3.delete(0, 10);
        System.out.println(sb3);
        //insert:在指定位置插入字符
        sb3.insert(0, "abcd");
        System.out.println(sb3);

        String s1 = null;
        StringBuffer stringBuffer = new StringBuffer("123");
        //当append方法传入一个null值时，会在StringBuffer对象内容之后添加“null”字符
        stringBuffer.append(s1);
        System.out.println(stringBuffer);
        //此处s1为空，在构造方法中会调用s1.length，此处报空指针异常
        //        StringBuffer stringBuffer1 = new StringBuffer(s1);
//        System.out.println(stringBuffer1);

        Scanner sc = new Scanner(System.in);
        s1 = sc.next();
        StringBuffer stringBuffer1 = new StringBuffer(s1);
        int i = stringBuffer1.lastIndexOf(".");
        for (int j = i - 3; j > 0; j -= 3) {
            stringBuffer1 = stringBuffer1.insert(j, ",");
        }
        System.out.println(stringBuffer1);

    }

    public static String ReverseString(String str, int start, int end) {
        if (!(str != null || start < end || end < str.length())) {
            throw new RuntimeException("值错误");
        }
        char[] ch = str.toCharArray();
        for (int i = start, j = end; i < j; i++, j--) {
                char temp = ch[j];
                ch[j] = ch[i];
                ch[i] = temp;
        }
        return Arrays.toString(ch);
    }
}

class Test {
    String s = new String("hsp");
    final char[] chars = {'j', 'a', 'v', 'a'};
    int[] arr = {1, 2, 3};

    public void change(String s, char[] chars) {
        s = "java";
        chars[0] = 'h';
    }
}
