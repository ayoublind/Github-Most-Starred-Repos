package com.ayoubelhassani.githubstarredrepos.model;

/**
 * Created by Ayoub on 10/25/2018.
 */

public class Repository {
    private String name, owner, desc;
    private double raiting;
    private String imageOwner;

    public Repository(String name, String owner, String desc, double raiting) {
        this.name = name;
        this.owner = owner;
        this.desc = desc;
        this.raiting = raiting;
    }

    public Repository(String name, String owner, String desc, double raiting, String imageOwner) {
        this.name = name;
        this.owner = owner;
        this.desc = desc;
        this.raiting = raiting;
        this.imageOwner = imageOwner;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getRaiting() {
        return raiting;
    }

    public void setRaiting(double raiting) {
        this.raiting = raiting;
    }

    public String getImageOwner() {
        return imageOwner;
    }

    public void setImageOwner(String imageOwner) {
        this.imageOwner = imageOwner;
    }
}
