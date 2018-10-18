package com.example.vikesh.purefragments.fragments;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.vikesh.purefragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private View mView;
    private View boardGame,btnonplay;
    private View ludoRed,ludoYellow,userred,useryelow;
    private View tokenGreen1,tokenGreen2,tokenGreen3,tokenGreen4;
    private View tokenYellow1,tokenYellow2,tokenYellow3,tokenYellow4;
    private View tokenBlue1,tokenBlue2,tokenBlue3,tokenBlue4;
    private View tokenRed1,tokenRed2,tokenRed3,tokenRed4;
    private boolean token;

    public SecondFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_second, container, false);
        init();


        btnonplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            ludoRed.setVisibility(View.VISIBLE);
               if(token){
                   ludoRed.setVisibility(View.VISIBLE);
                   ludoRed.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           token=true;
                           Log.d("clicked","yes"+token);
//                           tokenBlue1.setVisibility(View.VISIBLE);
//                           tokenBlue2.setVisibility(View.VISIBLE);
//                           tokenBlue3.setVisibility(View.VISIBLE);
//                           tokenBlue4.setVisibility(View.VISIBLE);
//
//                           tokenGreen1.setVisibility(View.VISIBLE);
//                           tokenGreen1.setVisibility(View.VISIBLE);
//                           tokenGreen1.setVisibility(View.VISIBLE);
//                           tokenGreen1.setVisibility(View.VISIBLE);

                       }
                   });
               }
               else{
                   ludoYellow.setVisibility(View.VISIBLE);
                   tokenRed1.setVisibility(View.VISIBLE);
                   tokenRed2.setVisibility(View.VISIBLE);
                   tokenRed3.setVisibility(View.VISIBLE);
                   tokenRed4.setVisibility(View.VISIBLE);

                   tokenYellow1.setVisibility(View.VISIBLE);
                   tokenYellow2.setVisibility(View.VISIBLE);
                   tokenYellow3.setVisibility(View.VISIBLE);
                   tokenYellow4.setVisibility(View.VISIBLE);
                   ludoYellow.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           token =false;
                           Log.d("clicked","yes"+token);
//                           Animation animation = AnimationUtils.loadAnimation(getContext(),);
//                           ObjectAnimator animator = ObjectAnimator.)
                       }
                   });
               }
                userred.setVisibility(View.VISIBLE);
                useryelow.setVisibility(View.VISIBLE);
            }
        });
        return mView;
    }

    private void init() {

        ludoRed =mView.findViewById(R.id.ludoRed);
        ludoYellow =mView.findViewById(R.id.ludoYellow);
        userred = mView.findViewById(R.id.userred);
        useryelow = mView.findViewById(R.id.useryellow);

        tokenBlue1 = mView.findViewById(R.id.bytkn1);
        tokenBlue2 = mView.findViewById(R.id.bytkn2);
        tokenBlue3 = mView.findViewById(R.id.bytkn3);
        tokenBlue4 = mView.findViewById(R.id.bytkn4);

        tokenGreen1 = mView.findViewById(R.id.gtkn1);
        tokenGreen2 = mView.findViewById(R.id.gtkn2);
        tokenGreen3 = mView.findViewById(R.id.gtkn3);
        tokenGreen4 = mView.findViewById(R.id.gtkn4);

        tokenRed1 = mView.findViewById(R.id.rtkn1);
        tokenRed2 = mView.findViewById(R.id.rtkn2);
        tokenRed3 = mView.findViewById(R.id.rtkn3);
        tokenRed4 = mView.findViewById(R.id.rtkn4);

        tokenYellow1 = mView.findViewById(R.id.ytkn1);
        tokenYellow2 = mView.findViewById(R.id.ytkn2);
        tokenYellow3 = mView.findViewById(R.id.ytkn3);
        tokenYellow4 = mView.findViewById(R.id.ytkn4);

//        userred = mView.findViewById(R.id.ludoRed);

        boardGame =mView.findViewById(R.id.gameboard);
     btnonplay = mView.findViewById(R.id.btnplay);

    }

    @Override
    public void onStart() {
        super.onStart();
//        ObjectAnimator scale = ObjectAnimator.ofFloat(boardGame,View.SCALE_X);
        Animation zerotoone = AnimationUtils.loadAnimation(getContext(),R.anim.scale0to1);
        boardGame.startAnimation(zerotoone);

    }
}
