package com.example.vikesh.purefragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.vikesh.purefragments.fragments.DragableButtonFragment;
import com.example.vikesh.purefragments.fragments.FirstFragment;
import com.example.vikesh.purefragments.fragments.SecondFragment;
import com.example.vikesh.purefragments.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity  {
    private View rootView;
    private Fragment fm;
    private FragmentManager fragmentManager;
    private Button btnFragOne,getBtnFragTwo,btnFragThree,btnFragFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

//        btnFragOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              fm = new FirstFragment();
//                FragmentTransaction ft = fragmentManager.beginTransaction();
//                ft.replace(rootView.getId(),fm);
//                ft.commit();
//            }
//        });
        getBtnFragTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = new SecondFragment();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(rootView.getId(),fm);
                ft.commit();
            }
        });
//        btnFragThree.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fm = new FirstFragment();
//                FragmentTransaction ft = fragmentManager.beginTransaction();
//                ft.replace(rootView.getId(),fm);
//                ft.commit();
//            }
//        });
//        btnFragFour.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                fm = new SecondFragment();
//                FragmentTransaction ft = fragmentManager.beginTransaction();
//                ft.replace(rootView.getId(),fm);
//                ft.commit();
//            }
//        });
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(rootView.getId(),new SecondFragment());
        ft.commit();

    }
    private void init() {
//        btnFragOne = findViewById(R.id.btnfirstfrag);
        getBtnFragTwo = findViewById(R.id.btnsecondfrag);
//        btnFragThree = findViewById(R.id.btnfourthfrag);
//        btnFragFour = findViewById(R.id.btnfourthfrag);
        fragmentManager = getSupportFragmentManager();
        rootView = findViewById(R.id.rootlayout);

    }

    @Override
    protected void onStart() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if(count<1)
        super.onStart();
        else
            getSupportFragmentManager().popBackStack();
    }
}
