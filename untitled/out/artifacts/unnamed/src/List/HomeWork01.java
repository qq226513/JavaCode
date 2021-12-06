package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeWork01 {
    public static void main(String[] args) {
        News news1 = new News("新闻一：新冠确诊病例超千万,数百万印度人进入恒河沐浴");
        News news2 = new News("新闻二：男子突然想起两个月前吊的鱼还在网兜，想起来之后赶紧放生");
        List<News> list = new ArrayList();
        list.add(news1);
        list.add(news2);
        for (News n:
             list) {
            if (n.getTitle().length() >15){
                System.out.println(n.getTitle().substring(0,15)+"... ");
            }else {
                System.out.println(n);
            }
        }

    }
}
class News{
    String title;
    String content;

    @Override
    public String toString() {
        return title+" "+content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String title) {
        this.title = title;
    }
}
