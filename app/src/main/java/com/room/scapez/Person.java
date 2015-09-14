package com.room.scapez;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nihas on 16-Jul-15.
 */
public class Person {
    String name;
    String age;
    String photoId;
    private List<Person> persons;

    public Person(String name, String age, String photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getPhotoId() {
        return photoId;
    }
    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.

}