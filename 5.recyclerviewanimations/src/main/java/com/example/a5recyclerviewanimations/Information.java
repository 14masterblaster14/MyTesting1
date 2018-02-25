package com.example.a5recyclerviewanimations;

public class Information {

    public int imageId;
    public String title;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Information{" +
                "imageId=" + imageId +
                ", title='" + title + '\'' +
                '}';
    }
}
