package xyz.yaroslav.positivetestapp;

public class Card {
    private String title;
    private String description;
    private int imgResource;

    public Card() {}

    public Card(String title, String description, int imgResource) {
        this.title = title;
        this.description = description;
        this.imgResource = imgResource;
    }

    public int getImgResource() {
        return imgResource;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
