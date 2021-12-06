package study02;

public class Test02 {
    public static void main(String[] args) {
        Professor professor = new Professor("张思",65,"教授",1000,1.3);
        String str = professor.introduce();
        System.out.println("基本信息");
        System.out.println(str);

    }
}
