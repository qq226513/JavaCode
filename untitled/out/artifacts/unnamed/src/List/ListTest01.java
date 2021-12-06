package List;

import java.util.*;

/**
 * @author 一台
 */
public class ListTest01 {
    public static void main(String[] args) {
        List<Book> list = new ArrayList();
        list.add(new Book("java",900,"mark"));
        list.add(new Book("python",120,"marks"));
        list.add(new Book("c++",110,"marry"));
        list.add(new Book("c",1990,"read"));
        list.add(new Book("go",180,"mark"));
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).price > list.get(j+1).price){
                    Book temp = list.get(j+1);
                    list.set(j+1, list.get(j));
                    list.set(j, temp);
                }

            }
        }
        for (Object o :
                list) {
            System.out.println(o);
        }
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(2,5);
        list2.remove(1);
        Set set  = new HashSet();
    }

}

class Book{
    String bookName;
    int price;
    String authorName;

    public Book(String bookName, int price, String authorName) {
        this.bookName = bookName;
        this.price = price;
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", price=" + price +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}