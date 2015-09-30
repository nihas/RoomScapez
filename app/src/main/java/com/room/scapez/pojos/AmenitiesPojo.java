package com.room.scapez.pojos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snyxius on 9/28/2015.
 */
public class AmenitiesPojo {
    String name;
    int imageID;
    int category;
    public static List<AmenitiesPojo> amenites;

    public String getName() {
        return name;
    }


    public int getImageID() {
        return imageID;
    }



    public int getCategory() {
        return category;
    }

    public AmenitiesPojo() {
        this.amenites=new ArrayList<>();
    }


    public AmenitiesPojo(String name, int image_id, int category) {
        this.name=name;
        this.imageID=image_id;
        this.category=category;
        this.amenites=new ArrayList<>();
    }

    public List<AmenitiesPojo> getAmenites() {
        return amenites;
    }

    public void setAmenites(List<AmenitiesPojo> amenites) {
        this.amenites.clear();
        this.amenites = amenites;
    }
}
