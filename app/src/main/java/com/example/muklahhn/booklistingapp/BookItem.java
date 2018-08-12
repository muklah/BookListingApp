package com.example.muklahhn.booklistingapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Muklah H N on 28/07/2018.
 */

public class BookItem {

    private String title;
    private StringBuilder authors;
    private String publisher;
    private String infoLink;

    public BookItem(String title, StringBuilder authors, String publisher, String infoLink) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.infoLink = infoLink;
    }

    public String getTitle() {
        return title;
    }

    public StringBuilder getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getInfoLink() {
        return infoLink;
    }

}
