package com.example.muklahhn.booklistingapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muklah H N on 28/07/2018.
 */

public class OpenBookJsonUtils {

    public static ArrayList<BookItem> getSimpleBookStringsFromJson(Context context, String booksJsonString)
            throws JSONException {

        final String ITEMS = "items";
        final String VOLUMEINFO = "volumeInfo";
        final String TITLE = "title";
        final String AUTHORS = "authors";
        final String PUBLISHER = "publisher";
        final String INFOLINK = "infoLink";

        ArrayList<BookItem> parsedBookData = new ArrayList<BookItem>();

        JSONObject booksObject = new JSONObject(booksJsonString);
        JSONArray booksArray = booksObject.getJSONArray(ITEMS);

        for (int i = 0; i < booksArray.length(); i++) {
            String title;
            StringBuilder authors = new StringBuilder();
            String publisher;
            String infoLink = null;

            JSONObject bookObject = booksArray.getJSONObject(i);
            JSONObject volumeInfo = bookObject.getJSONObject(VOLUMEINFO);

            title = volumeInfo.getString(TITLE);

            if (volumeInfo.has(AUTHORS)) {
                JSONArray author = volumeInfo.getJSONArray(AUTHORS);
                for (int j=0; j < author.length(); j++) {
                    authors.append(System.getProperty("line.separator"));
                    authors.append(author.getString(j));
                }
            } else {
                authors.append("No Authors");
            }

            if (volumeInfo.has(PUBLISHER)) {
                publisher = volumeInfo.getString(PUBLISHER);
            } else {
                publisher = "No Publisher";
            }

            if (volumeInfo.has(INFOLINK)){
                infoLink = volumeInfo.getString(INFOLINK);
            }

            parsedBookData.add(new BookItem(title, authors, publisher, infoLink));

        }

        return parsedBookData;
    }

}
