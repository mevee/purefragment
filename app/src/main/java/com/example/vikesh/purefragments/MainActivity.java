package com.example.vikesh.purefragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.vikesh.purefragments.bridge.ViewObservable;
import com.example.vikesh.purefragments.fragments.DragableButtonFragment;
import com.example.vikesh.purefragments.fragments.FirstFragment;
import com.example.vikesh.purefragments.fragments.SecondFragment;
import com.example.vikesh.purefragments.fragments.ThirdFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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
        EventBus.getDefault().register(this);

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
    @Subscribe
    public void onEvent(ViewObservable view){

    }
    private void init() {
        rootView = findViewById(R.id.rootlayout);
        rootView.setOnTouchListener(new View.OnTouchListener() {
        boolean b =true;
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                hideSystemUI();

////                if (event.getAction()==event.U)
//                if(b==true){
//                    showSystemUI();
//                    b=false;}
//                else{
//                    hideSystemUI();
//                    b=true;
//                }
                return true;
            }
        });
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
        if(count==0)
        super.onStart();
        else
            getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }

    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setAlpha(1);
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setAlpha(1);
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
