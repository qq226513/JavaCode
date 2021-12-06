package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.geom.Dimension2D;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class JSoupDemo2 {
    public static void main(String[] args) throws IOException {
        String path = Objects.requireNonNull(JSoupDemo1.class.getClassLoader().getResource("a.xml")).getPath();
        //解析xml文档，加载进内存，获取dom树-->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //通过Document获取标签
        Elements name1 = document.getElementsByTag("age");
        System.out.println(name1.size());
        //通过Element获取
        Elements users = document.getElementsByTag("user");
        Element name2 = users.get(0);
        String attr = name2.attr("id");
        System.out.println(attr);
        Elements age = name2.getElementsByTag("age");
        System.out.println(age.size());

        //获取文本内容：text(),html()
        String text = name2.text();
        String html = name2.html();
        System.out.println("text="+text);//获取子标签的纯文本内容
        System.out.println("html="+html);//获取包含子标签的标签体的所有内容

        //关于Node：是document和Element的父类
    }
}
