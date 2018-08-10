package com.example.muklahhn.booklistingapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mBooksList;
    BookAdapter mAdapter;
    private EditText mSearchBox;
    private Button search;
    private TextView mErrorMessageDisplay;
    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBox = (EditText)findViewById(R.id.search_box);
        mBooksList = (ListView)findViewById(R.id.list_view);
        search = (Button)findViewById(R.id.search);
        mErrorMessageDisplay = (TextView) findViewById(R.id.error_message_display);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.loading_indicator);

        mAdapter = new BookAdapter(this, new ArrayList<BookItem>());
        mBooksList.setAdapter(mAdapter);

        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                loadBooksData();

            }
        });

    }

    private void loadBooksData() {
        String searchQuery = mSearchBox.getText().toString();
        URL searchUrl = NetworkUtils.buildUrl(searchQuery);
        showBookDataView();
        new FetchBooksTask().execute(String.valueOf(searchUrl));
    }

    private void showBookDataView() {
        mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        mBooksList.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        mBooksList.setVisibility(View.INVISIBLE);
        mErrorMessageDisplay.setVisibility(View.VISIBLE);
    }

    public class FetchBooksTask extends AsyncTask<String, Void, ArrayList<BookItem>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<BookItem> doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }
            String searchBook = params[0];
            URL booksRequestUrl = NetworkUtils.buildUrl(searchBook);

            try {
                String jsonBookResponse = NetworkUtils.getResponseFromHttpUrl(booksRequestUrl);

                ArrayList<BookItem> simpleJsonBookData = OpenBookJsonUtils.getSimpleBookStringsFromJson(MainActivity.this, jsonBookResponse);

                return simpleJsonBookData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<BookItem> bookData) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            if (bookData != null) {
                showBookDataView();
                mAdapter.addAll(bookData);
            } else {
                showErrorMessage();
            }
        }
    }

}
