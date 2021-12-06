package EnumTest;

public class enumTest01 {
    public static void main(String[] args) {
        Week[] values = Week.values();
        for (Week value : values) {
            System.out.println(value.name);
        }
        Music.MUSIC1.run();
    }
}
enum Week{
    Monday("星期一"),Tuesday("星期二"),Wednesday("星期三"),Thursday("星期四"),
    Friday("星期五"),Saturday("星期六"),Sunday("星期日");
    String name;

    Week() {
    }
    Week(String name){
        this.name = name;
    }

}
enum Music implements playing{
    MUSIC1;


    @Override
    public void run() {
        System.out.println("播放音乐");
    }
}
interface playing{
    void run();
}