package com.osg.project03cloneapp.page01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.osg.project03cloneapp.R;

import java.util.ArrayList;

public class Page01Rec01Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Page01Rec01Item> items;

    public Page01Rec01Adapter(Context context, ArrayList<Page01Rec01Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(context).inflate(R.layout.page01_recycler01, parent, false);
        VH viewHolder=new VH(itemview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH viewHolder=(VH)holder;
        Page01Rec01Item item=items.get(position);

        Glide.with(context).load(item.img).into(viewHolder.iv);
        viewHolder.tv.setText(item.text);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.recImg);
            tv=itemView.findViewById(R.id.recText);
        }

    }

}
