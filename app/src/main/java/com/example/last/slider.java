package com.example.last;

public class slider {
    private  int Image;
    private  String Title;


    public slider(int image, String title) {
        Image = image;
        Title = title;
    }

    public int getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
