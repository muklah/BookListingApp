package com.example.muklahhn.booklistingapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muklah H N on 28/07/2018.
 */

public class BookAdapter extends ArrayAdapter<BookItem> {

    public BookAdapter(Activity context, ArrayList<BookItem> books) {
        super(context, 0, books);
    }

    private static class ViewHolder {
        TextView BookTitle;
        TextView BookAuthors;
        TextView BookPublisher;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        View bookList = convertView;
        if (bookList == null) {
            bookList = LayoutInflater.from(getContext()).inflate(R.layout.book_list_item, parent, false);
            holder = new ViewHolder();
            holder.BookTitle = (TextView) bookList.findViewById(R.id.book_title);
            holder.BookAuthors = (TextView) bookList.findViewById(R.id.book_authors);
            holder.BookPublisher = (TextView) bookList.findViewById(R.id.book_publisher);
            bookList.setTag(holder);
        } else {
            holder = (ViewHolder) bookList.getTag();
        }
        BookItem book = getItem(position);

        holder.BookTitle.setText(book.getTitle());
        holder.BookAuthors.setText("Authors: " + book.getAuthors());
        holder.BookPublisher.setText("Publisher: " + book.getPublisher());

        return bookList;
    }
}