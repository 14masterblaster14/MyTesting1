package com.example.a5recyclerviewanimations;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    protected RecyclerViewClickListener recyclerViewClickListener;
    private Context context;
    private ArrayList<Information> data;
    private LayoutInflater inflater;
    private int previousPosition = 0;

    public MyCustomAdapter(Context context, ArrayList<Information> data, RecyclerViewClickListener listener) {

        this.context = context;
        this.data = data;
        this.recyclerViewClickListener = listener;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {
        final Information information = data.get(position);
        myViewHolder.textview.setText(information.title);
        myViewHolder.imageView.setImageResource(information.imageId);

        if (position > previousPosition) { // We are scrolling DOWN

            AnimationUtil.animate(myViewHolder, true);

        } else { // We are scrolling UP

            AnimationUtil.animate(myViewHolder, false);


        }

        previousPosition = position;


        final int currentPosition = position;
        final Information infoData = data.get(position);

       /* myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "OnClick Called at position " + position, Toast.LENGTH_SHORT).show();
                addItem(currentPosition, infoData);
            }
        });

        myViewHolder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(context, "OnLongClick Called at position " + position, Toast.LENGTH_SHORT).show();

                removeItem(infoData);

                return true;
            }
        });*/

        myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewClickListener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // This removes the data from our Dataset and Updates the Recycler View.
    private void removeItem(Information infoData) {

        int currPosition = data.indexOf(infoData);
        data.remove(currPosition);
        notifyItemRemoved(currPosition);
    }

    // This method adds(duplicates) a Object (item ) to our Data set as well as Recycler View.
    private void addItem(int position, Information infoData) {

        data.add(position, infoData);
        notifyItemInserted(position);
    }

    public interface RecyclerViewClickListener {

        void onItemClick(View view, int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout linearLayout;
        TextView textview;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linear_layout);
            textview = itemView.findViewById(R.id.txv_row);
            imageView = itemView.findViewById(R.id.img_row);
            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (recyclerViewClickListener != null) {
                Log.i("@MasterBlaster", "ClickListener : ");

                recyclerViewClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }
}
