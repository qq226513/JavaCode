package 集合.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/**
 * @author 一台
 */
public class iterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection  c = new ArrayList();
        c.add("java");
        c.add("afss");
        for (Object next : c) {
            System.out.println(next);
        }
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
