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
            bookList.setTag(holder);
        } else {
            holder = (ViewHolder) bookList.getTag();
        }
        BookItem book = getItem(position);

        holder.BookTitle.setText(book.getTitle());

        return bookList;
    }
}