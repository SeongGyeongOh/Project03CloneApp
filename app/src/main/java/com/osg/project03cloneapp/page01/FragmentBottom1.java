package com.osg.project03cloneapp.page01;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.osg.project03cloneapp.R;

import java.util.ArrayList;

public class FragmentBottom1 extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Page01Rec01Item> items=new ArrayList<>();
    Page01Rec01Adapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        items.add(new Page01Rec01Item(R.drawable.giraffe, "기린"));
        items.add(new Page01Rec01Item(R.drawable.pig, "꿀꿀"));
        items.add(new Page01Rec01Item(R.drawable.hippo, "하마"));
        items.add(new Page01Rec01Item(R.drawable.rabbit, "토끼"));
        items.add(new Page01Rec01Item(R.drawable.penguin, "펭귄"));
        items.add(new Page01Rec01Item(R.drawable.parrot, "족제비?"));
        items.add(new Page01Rec01Item(R.drawable.giraffe, "기린"));
        items.add(new Page01Rec01Item(R.drawable.pig, "꿀꿀"));
        items.add(new Page01Rec01Item(R.drawable.hippo, "하마"));
        items.add(new Page01Rec01Item(R.drawable.rabbit, "토끼"));
        items.add(new Page01Rec01Item(R.drawable.penguin, "펭귄"));
        items.add(new Page01Rec01Item(R.drawable.parrot, "족제비?"));


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment_bottom1, container, false);
        Toolbar toolbar=view.findViewById(R.id.toolbar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);


        //첫 번재 리사이클러뷰
        recyclerView=view.findViewById(R.id.recycler01);
        adapter = new Page01Rec01Adapter(getActivity(), items);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        return view;
    }
}
