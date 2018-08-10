package com.example.muklahhn.booklistingapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Muklah H N on 28/07/2018.
 */

public class BookItem implements Parcelable {

    private String title;

    public BookItem(String title) {
        this.title = title;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(title);
    }

    private BookItem(Parcel in) {
        this.title              = in.readString();
    }

    public BookItem() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<BookItem> CREATOR = new Parcelable.Creator<BookItem>() {
        @Override
        public BookItem createFromParcel(Parcel in) {
            return new BookItem(in);
        }
        @Override
        public BookItem[] newArray(int i) {
            return new BookItem[i];
        }
    };

    public String getTitle() {
        return title;
    }

}
