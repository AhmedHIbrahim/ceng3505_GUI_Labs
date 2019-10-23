package com.ahmed.listviewexample;

public class Animal {
    //Each animal has two variables: its type and its picture
    private String type;
    private int picId;

    //When creating an instance of the class, you have to add its type and its picture id
    public Animal(String type,int picId){
        this.type = type;
        this.picId = picId;
    }

    //Creating getters and setters method for each variable

    public String getType(){
        return type;
    }

    public void setType(String tyep){
        this.type = type;
    }

    public int getPicId(){
        return picId;
    }

    public void setPicId(int picId){
        this.picId = picId;
    }

}
