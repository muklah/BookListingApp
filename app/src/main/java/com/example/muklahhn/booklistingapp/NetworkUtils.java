package com.example.muklahhn.booklistingapp;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Muklah H N on 28/07/2018.
 */

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    private static final String BOOKS_BASE_URL = "https://www.googleapis.com/books/v1/volumes";
    private static final String Q = "q";
    private static final String BOOKS_END_URL = "maxResults";
    private static final String Value = "20";

    public static URL buildUrl(String BooksQuery) {
        Uri builtUri = Uri.parse(BOOKS_BASE_URL).buildUpon()
                .appendQueryParameter(Q, BooksQuery)
                .appendQueryParameter(BOOKS_END_URL, Value)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}
