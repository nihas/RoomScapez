package com.room.scapez.pojos;

/**
 * Created by snyxius on 9/28/2015.
 */
public class AmenitiesPojo {
    String name;
    int imageID;
    int category;

    public String getName() {
        return name;
    }


    public int getImageID() {
        return imageID;
    }



    public int getCategory() {
        return category;
    }


    public AmenitiesPojo(String name, int image_id, int category) {
        this.name=name;
        this.imageID=image_id;
        this.category=category;
    }
}
