package Map;

import 集合.iterator.iterator;

import java.util.*;

public class MapTest01 {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1","张三丰");
        map.put("no2","张无忌");
        map.put("no4","虚竹");
        map.put("no3","玄冥二老");
        //Map的遍历需要先变为set，使用keySet方法
        Set set = map.keySet();
        for (Object key:
             set) {
            System.out.println(key+" "+map.get(key));
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next+" "+map.get(next));
        }
        //Map的遍历需要先变为set，使用entrySet方法
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            Map.Entry next1 = (Map.Entry) next;
            System.out.println(next1.getKey()+" "+next1.getValue());
        }
        for (Object obj :
                set1) {
            Map.Entry mapE = (Map.Entry) obj;
            System.out.println(mapE.getKey()+""+mapE.getValue());

        }
        Collection values = map.values();
        System.out.println(values);

    }
}
