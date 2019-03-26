package xyz.yaroslav.positivetestapp;

public class Card {
    private String title;
    private String[] description;
    private String[] label;
    private int imgResource;

    public Card() {}

    public Card(String title, String[] description, String[] label, int imgResource) {
        this.title = title;
        this.description = description;
        this.label = label;
        this.imgResource = imgResource;
    }

    public Card(String title, int imgResource) {
        this.title = title;
        this.imgResource = imgResource;
    }

    public int getImgResource() {
        return imgResource;
    }

    public String getTitle() {
        return title;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String[] getDescription() {
        return description;
    }

    public String[] getLabel() {
        return label;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }
}
