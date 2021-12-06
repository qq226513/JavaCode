package ExceptionTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        String input1 = "";
        String input2 = "";
           while(true){
               System.out.println("请输入两个整数");
               input1 = scanner.next();
               input2 = scanner.next();
               try {
                   num1 = Integer.parseInt(input1);
                   num2 = Integer.parseInt(input2);
                   System.out.println(cal(num1,num2));
                   break;
               } catch (NumberFormatException e) {
                   System.out.println("你输入的不是两个整数");
               }catch (ArithmeticException e){
                   System.out.println("你输入的分母为0");
               }catch (ArrayIndexOutOfBoundsException e){
                   System.out.println("你输入的数据格式不正确");
               }

           }

    }
    public static int cal(int n1,int n2) throws ArithmeticException,ArrayIndexOutOfBoundsException{
        return n1/n2;
    }
}

