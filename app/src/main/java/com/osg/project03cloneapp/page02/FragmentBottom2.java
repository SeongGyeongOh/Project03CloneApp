package com.osg.project03cloneapp.page02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.osg.project03cloneapp.R;

import org.w3c.dom.Text;

import java.util.Random;

public class FragmentBottom2 extends Fragment {
    TextView tvRandom;
    String[] menu;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment_bottom2, container, false);



        menu= new String[]{"한정식", "된장찌개", "김치찌개", "곱창", "순두부찌개", "해장국", "고등어구이", "불고기", "제육볶음", "마라샹궈", "마라탕", "양꼬치", "초밥", "라멘", "우동", "피자", "스테이크", "쌀국수", "햄버거", "떡볶이", "팟타이", "삼겹살"};
        Random random=new Random();
//        int i=random.nextInt(menu.length);
        tvRandom=view.findViewById(R.id.tvRandom);
//        tvRandom.setText(menu[i]);

        MenuThread menu=new MenuThread();
        menu.start();


        return view;
    }

    class MenuThread extends Thread{

        @Override
        public void run() {
            super.run();

            for (int i=0;i<menu.length-10;i++){
                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        Random random=new Random();
                        int r=random.nextInt(menu.length-10);

                        tvRandom.setText(menu[r]);
                    }
                };



                ((AppCompatActivity)getContext()).runOnUiThread(runnable);

                try{
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
    //TODO: 돌아가는 메뉴를 ListView로 생성, ScrollView 자동스크롤 알아보고 적용하기
}
