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
import java.util.zip.Inflater;

public class Page01Rec02Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Page01Rec02Item> items;

    public Page01Rec02Adapter(Context context, ArrayList<Page01Rec02Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(context).inflate(R.layout.page01_recycler02, parent, false);
        VH viewHolder=new VH(itemview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH viewHolder=(VH)holder;
        Page01Rec02Item item=items.get(position);

        Glide.with(context).load(item.flag).into(viewHolder.iv);
        viewHolder.text.setText(item.text);
        viewHolder.date.setText(item.date);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView text, date;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.recImg);
            text=itemView.findViewById(R.id.recText);
            date=itemView.findViewById(R.id.recDate);
        }
    }
}
