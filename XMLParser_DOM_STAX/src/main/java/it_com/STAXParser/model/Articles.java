package it_com.STAXParser.model;

import java.util.List;

public class Articles {
    private String title;
    private String author;
    private String url;
    private List<Hotkeys> hotkeys;
    private String id;

    public Articles() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHotkeys(List<Hotkeys> hotkeys) {
        this.hotkeys = hotkeys;
    }

     public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", hotkeys=" + hotkeys +
                '}';
    }
}
