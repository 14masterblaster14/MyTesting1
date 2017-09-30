package com.example.a11butterknifedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ADMIN on 9/30/2017.
 */

public class MyAdapter extends BaseAdapter {

    private static final String[] CONTENTS = "The quick brown fox jumps over the lazy dog".split(" ");
    private final LayoutInflater inflater;

    public MyAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        //return 0;
        return CONTENTS.length;
    }

    @Override
    public Object getItem(int i) {
        // return null;
        return CONTENTS[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // return null;

        ViewHolder viewHolder;

        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.list_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        String word = getItem(i).toString();
        viewHolder.word.setText("Word: " + word);
        viewHolder.length.setText("Length: " + word.length());
        viewHolder.position.setText("Position: " + i);
        // Note: don't actually do string concatenation like this in an adapter's getView.

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.word)
        TextView word;
        @BindView(R.id.length)
        TextView length;
        @BindView(R.id.position)
        TextView position;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
