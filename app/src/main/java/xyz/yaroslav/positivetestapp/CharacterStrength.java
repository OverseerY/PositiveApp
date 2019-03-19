package xyz.yaroslav.positivetestapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Comparator;

public class CharacterStrength implements Parcelable {
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

    public CharacterStrength(Parcel parcel) {
        name = parcel.readString();
        virtue = parcel.readString();
        value = parcel.readInt();
        icon_resource = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(virtue);
        dest.writeInt(value);
        dest.writeInt(icon_resource);
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

    public static final Parcelable.Creator<CharacterStrength> CREATOR = new Parcelable.Creator<CharacterStrength>() {
        public CharacterStrength createFromParcel(Parcel in) {
            return new CharacterStrength(in);
        }

        public CharacterStrength[] newArray(int size) {
            return new CharacterStrength[size];
        }
    };

    public static Comparator<CharacterStrength> StrengthComparator = (o1, o2) -> {
        int strengthValue1 = o1.getValue();
        int strengthValue2 = o2.getValue();

        return strengthValue2 - strengthValue1;
    };
}
