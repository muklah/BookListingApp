package com.example.muklahhn.booklistingapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Muklah H N on 28/07/2018.
 */

public class OpenBookJsonUtils {

    public static ArrayList<BookItem> getSimpleBookStringsFromJson(Context context, String booksJsonString)
            throws JSONException {

        final String ITEMS = "items";
        final String VOLUMEINFO = "volumeInfo";
        final String TITLE = "title";
        final String ORIGINAL_TITLE = "original_title";
        final String RELEASE_DATE = "release_date";
        final String VOTE_AVERAGE = "vote_average";
        final String OVERVIEW = "overview";
        final String ID = "id";

        ArrayList<BookItem> parsedBookData = new ArrayList<BookItem>();

        JSONObject booksObject = new JSONObject(booksJsonString);
        JSONArray booksArray = booksObject.getJSONArray(ITEMS);

        for (int i = 0; i < booksArray.length(); i++) {
            String title;
            String original_title;
            String release_date;
            double vote_average;
            String overview;
            int id;

            JSONObject bookObject = booksArray.getJSONObject(i);

            JSONObject volumeInfo = bookObject.getJSONObject(VOLUMEINFO);

            title = volumeInfo.getString(TITLE);
//            poster_path = moviesObject.getString(POSTER_PATH);
//            original_title = moviesObject.getString(ORIGINAL_TITLE);
//            release_date = moviesObject.getString(RELEASE_DATE);
//            vote_average = moviesObject.getDouble(VOTE_AVERAGE);
//            overview = moviesObject.getString(OVERVIEW);
//            id = moviesObject.getInt(ID);

            parsedBookData.add(new BookItem(title));

        }

        return parsedBookData;
    }

}
