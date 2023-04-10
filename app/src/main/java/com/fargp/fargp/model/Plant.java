package com.fargp.fargp.model;

import android.media.Image;

public class Plant {
    private String name;
    private String scientificName;
    private String type;
    private Image photo;
    private Recordation[] recordations;

    public Plant(String name, String scientificName, String type) {
        this.name = name;
        this.scientificName = scientificName;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public Recordation getRecordations(int index) {
        return recordations[index];
    }

    public void setRecordations(int index, Recordation recordations) {
        this.recordations[index] = recordations;
    }


}
