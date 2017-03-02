package com.example.rakesh.recyclerviewtest;

/**
 * Created by Rakesh on 14-02-2017.
 */

public class Icon {

    private int drawable;
    private String title;

    public Icon(int drawable, String name) {
        this.drawable = drawable;
        this.title = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public String getTitle() {
        return title;
    }
}
