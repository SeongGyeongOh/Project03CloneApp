package com.osg.project03cloneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.osg.project03cloneapp.page01.FragmentBottom1;
import com.osg.project03cloneapp.page02.FragmentBottom2;
import com.osg.project03cloneapp.page03.FragmentBottom3;
import com.osg.project03cloneapp.page04.FragmentBottom4;
import com.osg.project03cloneapp.page05.FragmentBottom5;

public class MainActivity extends AppCompatActivity {
//    배달의민족 클론앱을 만들어보자 (액티비티 생김새만...)
    BottomNavigationView bottomNavigationView;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomMenu);


        manager=getSupportFragmentManager();
        final Fragment[] frags=new Fragment[5];
        frags[0]=new FragmentBottom1();
        frags[1]=new FragmentBottom2();
        frags[2]=new FragmentBottom3();
        frags[3]=new FragmentBottom4();
        frags[4]=new FragmentBottom5();

        FragmentTransaction tran=manager.beginTransaction().add(R.id.main_container, frags[0]);
        tran.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction tran=manager.beginTransaction();
                switch(menuItem.getItemId()){
                    case R.id.bottom1:
                        tran.replace(R.id.main_container, frags[0]);
                        break;

                    case R.id.bottom2:
                        tran.replace(R.id.main_container, frags[1]);
                        break;

                    case R.id.bottom3:
                        tran.replace(R.id.main_container, frags[2]);
                        break;

                    case R.id.bottom4:
                        tran.replace(R.id.main_container, frags[3]);
                        break;

                    case R.id.bottom5:
                        tran.replace(R.id.main_container, frags[4]);
                        break;
                }

                tran.commit();
                return true;
            }
        });
    }
}