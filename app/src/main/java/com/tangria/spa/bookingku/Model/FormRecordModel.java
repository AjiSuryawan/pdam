package com.tangria.spa.bookingku.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FormRecordModel extends RealmObject {

    @PrimaryKey
    private String id;
    private String meteran;
    private String imagePath;

    public String getMeteran() {
        return meteran;
    }

    public void setMeteran(String meteran) {
        this.meteran = meteran;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
