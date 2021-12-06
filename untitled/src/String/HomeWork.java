package String;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class HomeWork {
    static boolean loop1 = true;

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            Log("name");
            Log("userName");
            Log("passWord");
            Log("email");
            System.out.println("登录成功");
            loop = false;
        }
    }

    public static void Log(String logParameter) {
        int num = Judge(logParameter);
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (loop1) {
            System.out.println("请输入你的" + logParameter);
            str = sc.next();
            switch (num) {
                case 1:
                    if (judgeName(str)) {
                        loop1 = false;
                    } else {
                        System.out.println("数据有误，请重新输入");
                    }
                    break;
                case 2:
                    if (judgePassword(str)) {
                        loop1 = false;
                    } else {
                        System.out.println("数据有误，请重新输入");
                    }
                    break;
                case 3:
                    if (judgeEmail(str)) {
                        loop1 = false;
                    } else {
                        System.out.println("数据有误，请重新输入");
                    }
                    break;
                case 4:
                    if (judgeNameFormat(str)){
                        loop1 = false;
                        printName(str);
                    }else {
                        System.out.println("数据有误，请重新输入");
                    }
                    break;
                default:
            }
        }
        loop1 = true;
    }

    public static int Judge(String LogParameter) {
        if ("userName".equals(LogParameter)) {
            return 1;
        } else if ("passWord".equals(LogParameter)) {
            return 2;
        } else if ("email".equals(LogParameter)) {
            return 3;
        }else if ("name".equals(LogParameter)){
            return 4;
        }
        return -1000;
    }

    public static boolean judgeName(String name) {
        return name.length() >= 2 && name.length() <= 4;
    }

    public static boolean judgeNameFormat(String name) {
        String str;
        str = name;
        String[] arr = str.split(" ");
        for (String s : arr) {
            char[] ch = s.toCharArray();
            if (!(ch[0] >= 65 && ch[0] <= 91 && ch[ch.length - 1] >= 97 && ch[ch.length - 1] <= 125)) {
                return false;
            }

        }
        return true;
    }

    public static void printName(String name) {
        if (judgeNameFormat(name)) {
            String str;
            str = name;
            String[] arr = str.split(" ");
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.printf(arr[i] + " ");

            }

        } else {
            System.out.println("你输入的名字格式有误");
        }

    }

    public static boolean judgePassword(String passwd) {
        char[] ch = passwd.toCharArray();
        for (char c :
                ch) {
            if (!(c >= 48 && c <= 57)) {
                return false;
            }
        }
        return true;
    }

    public static boolean judgeEmail(String Email) {
        if (!Email.contains("@") || !Email.contains(".")) {
            return false;
        }
        return Email.indexOf("@") < Email.indexOf(".");
    }
}
