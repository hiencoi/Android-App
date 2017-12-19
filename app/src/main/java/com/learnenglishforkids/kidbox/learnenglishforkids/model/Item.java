package com.learnenglishforkids.kidbox.learnenglishforkids.model;

import android.graphics.Bitmap;

/**
 * Created by trand on 10/13/2017.
 * Lop mo phong cac du lieu can hien thi cho 1 item trong GridView
 * Du lieu bao gom 1 hinh anh va 1 text
 */

public class Item {
    Bitmap image;
    String title;

    public Item(Bitmap image, String title) {
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
