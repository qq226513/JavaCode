package ExceptionTest;

import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        try {
            if (args.length != 2){
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            System.out.println(cal(n1,n2));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.out.println("你的数据格式有误");
        }catch (ArithmeticException e){
            System.out.println("你输入的数据有误");
        }
    }
    public static int cal(int n1,int n2){
        return n1/n2;
    }
}
