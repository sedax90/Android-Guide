package com.example.listviewobjectstutorial;

import android.content.Context;

/**
 * Created by Cristian on 27/07/13.
 */
public class Cms {

    public String Large;
    public String Small;
    public int Id;

    public Cms(String large, String small, int id){
        this.Large = large;
        this.Small = small;
        this.Id = id;
    }

    public void setLarge(String text){
        this.Large = text;
    }

    public void setSmall(String text){
        this.Small = text;
    }

    public void setId(int num){
        this.Id = num;
    }

    public String getLarge(){
        return this.Large;
    }

    public String getSmall(){
        return this.Small;
    }

    public int getId(){
        return this.Id;
    }

}
