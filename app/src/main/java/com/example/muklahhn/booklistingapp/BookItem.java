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

//    @Override
//    public void writeToParcel(Parcel out, int flags) {
//        out.writeString(title);
//        out.writeStringList(authors);
//        out.writeString(publisher);
//    }
//
//    private BookItem(Parcel in) {
//        this.title              = in.readString();
//        in.readStringList(authors);
//        this.publisher              = in.readString();
//    }
//
//    public BookItem() {
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    public static final Parcelable.Creator<BookItem> CREATOR = new Parcelable.Creator<BookItem>() {
//        @Override
//        public BookItem createFromParcel(Parcel in) {
//            return new BookItem(in);
//        }
//        @Override
//        public BookItem[] newArray(int i) {
//            return new BookItem[i];
//        }
//    };

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
