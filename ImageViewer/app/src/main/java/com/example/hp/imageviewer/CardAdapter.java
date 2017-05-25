package com.example.hp.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 5/25/2017.
 */
class ViewHolder extends RecyclerView.ViewHolder {
    public TextView rank;
    public TextView country;
    public TextView population;
    public ImageView flag;

    public ViewHolder(View itemView) {
        super(itemView);
        rank = (TextView) itemView.findViewById(R.id.rank);
        country = (TextView) itemView.findViewById(R.id.country);
        population = (TextView) itemView.findViewById(R.id.population);
        flag=(ImageView)itemView.findViewById(R.id.flag);
    }
}




public class CardAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<MyData> mItems;
    Context context;

    public CardAdapter(Context context,ArrayList<MyData> objects) {
        super();
        this.context=context;
        mItems = objects;
    }







    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

       holder.rank.setText(mItems.get(position).getRank());
        holder.country.setText(mItems.get(position).getCountry());

        holder.population.setText(mItems.get(position).getPopulation());

        String images = mItems.get(position).getFlag();
        holder.flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(context,FullscreenActivity.class);
                in.putExtra("Image",mItems.get(position).getFlag());
                Log.d("**********","url send"+mItems.get(position).getFlag());
                v.getContext().startActivity(in);
            }
        });

        Glide.with(context)
                .load(images)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(holder.flag);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }





}
