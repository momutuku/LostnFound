package com.example.last;

public class IDs {

    private String Title;
    private  String Desc;
    private int Thumbnail;
    private String regno;

    public IDs(String title, int thumbnail) {
        Title = title;
        Thumbnail = thumbnail;
    }

    public IDs(String title, String desc, int thumbnail, String regno) {
        Title = title;
        Desc = desc;
        Thumbnail = thumbnail;
        this.regno = regno;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }
}
