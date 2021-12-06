package List;

import java.util.ArrayList;
import java.util.List;

public class ListTest03 {
    //List接口的index都是从0开始数的
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add("hua");
        }
        arrayList.add(1, "cao");//index是从0开始数的
        int i = 0;
        for (String s :
                arrayList) {
            System.out.println(i + s);
            i++;
        }
        Object o = arrayList.get(1);//index是从0开始的
        System.out.println("第二个" + o);
        arrayList.remove(1);//index是从0开始的
        arrayList.set(1, "nice");
        i = 0;
        for (String s :
                arrayList) {
            System.out.println(i + s);
            i++;
        }
    }
}
