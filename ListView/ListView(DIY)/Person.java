package com.example.bin.hell1;

public class Person {
    private String name;
    private int imageId;

    public Person(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
