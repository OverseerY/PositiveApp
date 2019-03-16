package xyz.yaroslav.positivetestapp;

public class CharacterStrength {
    private String name;
    private String virtue;
    private int value;
    private int icon_resource;

    public CharacterStrength() {}

    public CharacterStrength(String name, String virtue, int value, int icon_resource) {
        this.name = name;
        this.virtue = virtue;
        this.value = value;
        this.icon_resource = icon_resource;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getVirtue() {
        return virtue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setVirtue(String virtue) {
        this.virtue = virtue;
    }

    public int getIcon_resource() {
        return icon_resource;
    }

    public void setIcon_resource(int icon_resource) {
        this.icon_resource = icon_resource;
    }
}
