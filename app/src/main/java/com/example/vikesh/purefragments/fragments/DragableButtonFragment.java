package com.example.vikesh.purefragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.vikesh.purefragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DragableButtonFragment extends Fragment implements View.OnTouchListener {
    private View mView;
    private View dgmebtn, cancelarea;
    int  width =15,height=25;
    float cordxOfCancelArea,
            cordyOfCancelArea;


//    width= (int) (getResources().getDimension(R.dimen.bonusfloatinglayoutwidth)/2);
//    height= (int) (getResources().getDimension(R.dimen.bonusfloatinglayoutheight)/2);


    public DragableButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_dragable_button, container, false);
        dgmebtn = mView.findViewById(R.id.dragmebtn);
        cancelarea = mView.findViewById(R.id.cancelarea);
//        cancelarea.setOnTouchListener();
//        cordx = cancelarea.getX();
//        cordyOfCancelArea = cancelarea.getY();

//        cordyOfCancelArea = cancelarea.getRawX()

        dgmebtn.setOnTouchListener(this);

     return mView;
    }
    float startX = 0;
    float startY = 0;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        cordxOfCancelArea = cancelarea.getX();
        cordyOfCancelArea = cancelarea.getY();

        int CLICK_ACTION_THRESHOLD = 10;

        switch (motionEvent.getAction() /*& MotionEvent.ACTION_MASK*/) {
            case MotionEvent.ACTION_DOWN:
                cancelarea.setVisibility(View.VISIBLE);
                startX = motionEvent.getRawX();
                startY = motionEvent.getRawY();
                Log.d("motionEvent", "ACTION_DOWN"+startX +" "+startY);
                return true;
            case MotionEvent.ACTION_UP:
                float endX = motionEvent.getRawX();
                float endY = motionEvent.getRawY();
                cancelarea.setVisibility(View.GONE);

                float differenceX = Math.abs(startX - endX);
                float differenceY = Math.abs(startY - endY);

//                if (view.getX()>cordxOfCancelArea&&view.getX()< cordyOfCancelArea +50&&view.getY()> cordyOfCancelArea &&view.getY()< cordyOfCancelArea -50)
//                {  Log.d("cordsofviewis:","x:"+view.getX()+" y:"+view.getY());
//                    Log.d("cordsofviewis:--","x:"+cordxOfCancelArea+" y:"+ cordyOfCancelArea);
//                    cancelarea.setVisibility(View.GONE);
//                    dgmebtn.setVisibility(View.GONE);
//                }

                if (differenceX < CLICK_ACTION_THRESHOLD && differenceY < CLICK_ACTION_THRESHOLD) {
//                    if (mdailyStreak >= 1 && mdailyBonusCoinsValues != null) {
//                        showDailyBonusPopUpForWordRun(mdailyStreak, mdailyBonusCoinsValues);
//                    }else{
//                        callServerForDailyBonusWordRun();
//                    }
                    Log.d("motionEvent", "youclicked");
                }

                Log.d("motionEvent", "ACTION_UP"+differenceX +" "+differenceY);
                return true;

            case MotionEvent.ACTION_MOVE:
                cancelarea.setVisibility(View.VISIBLE);
                Log.d("motionEvent", "ACTION_UP"+motionEvent.getRawX() +" "+motionEvent.getRawY());
                Log.d("cordsofviewis:","x:"+view.getX()+" y:"+view.getY());
                Log.d("cordsofviewis:--","x:"+cordxOfCancelArea+" y:"+ cordyOfCancelArea);
                view.setX(motionEvent.getRawX()-width);
                view.setY(motionEvent.getRawY()-height);

                if (view.getX()>cordxOfCancelArea&&view.getX()< cordyOfCancelArea +50&&view.getY()> cordyOfCancelArea &&view.getY()< cordyOfCancelArea -50)
                {
                    Log.d("cordsofviewis:","x:"+view.getX()+" y:"+view.getY());
                    Log.d("cordsofviewis:--","x:"+cordxOfCancelArea+" y:"+ cordyOfCancelArea);
                    cancelarea.setBackgroundDrawable(ContextCompat.getDrawable(getContext(),R.drawable.ic_cancel_black_24dp));
// cancelarea.setVisibility(View.GONE);
//                    dgmebtn.setVisibility(View.GONE);
                }
                return true;
        }

//        rootLayout.invalidate();
        return false;
    }



}
