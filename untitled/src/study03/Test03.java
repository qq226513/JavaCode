package study03;

import java.sql.SQLOutput;

public class Test03 {
    public static void main(String[] args) {
        Peasant peasant = new Peasant("张三", 44, '男', 3201.2);
        Scientist scientist = new Scientist("杨修山", 54, '男', 60000, 439999);
        Teachers teachers = new Teachers("陈赵权", 50, '男', 31, 440, 400);
        System.out.println("农民"+peasant.getName()+"基本信息如下：");
        System.out.println(peasant.introduce());
        System.out.println("科学家"+scientist.getName()+"基本信息如下：");
        System.out.println(scientist.introduce());
        System.out.println("教师"+teachers.getName()+"基本信息如下：");
        System.out.println(teachers.introduce());
    }
}
