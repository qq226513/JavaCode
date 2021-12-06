package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

//jSoup快速入门
public class JSoupDemo1 {
    public static void main(String[] args) throws IOException {
        //获取xml的路径
        String path = Objects.requireNonNull(JSoupDemo1.class.getClassLoader().getResource("a.xml")).getPath();
        //解析xml文档，加载进内存，获取dom树-->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //获取元素对象,Elements实际上是一个ArrayList集合
        Elements age = document.getElementsByTag("age");
        Elements user = document.getElementsByTag("user");
        System.out.println("====");
        System.out.println(user);
        //通过属性名获取
        Elements id = document.getElementsByAttribute("id");
        System.out.println(id.equals(user));
        //通过get方法获取数据
        System.out.println(age.get(0).text());
        //通过URL路径获取Document
        URL url = new URL("https://www.bilibili.com/video/BV1uJ411k7wy?p=671&spm_id_from=pageDriver");
        Document document1 = Jsoup.parse(url, 100000);
        System.out.println(document1);
    }
}
