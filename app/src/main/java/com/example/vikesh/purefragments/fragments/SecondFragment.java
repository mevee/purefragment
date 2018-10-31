package com.example.vikesh.purefragments.fragments;


import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.vikesh.purefragments.Dialogs;
import com.example.vikesh.purefragments.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements View.OnClickListener {
    private int viewCount,mStackLevel;
    private View mView, rootView;
    private View boardGame, btnonplay, btnGoBack;
    private ImageView ludoRed, ludoYellow, ludoGreen, ludoBlue;
    private View userred, useryelow;
    private View tokenGreen1, tokenGreen2, tokenGreen3, tokenGreen4;
    private View tokenYellow1, tokenYellow2, tokenYellow3, tokenYellow4;
    private View tokenBlue1, tokenBlue2, tokenBlue3, tokenBlue4;
    private View tokenRed1, tokenRed2, tokenRed3, tokenRed4;
    private View gifts1,gifts2,gifts3;

    private boolean token;
    private AdView mAdView;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_second, container, false);
        init();

        ViewGroup viewGroup = (ViewGroup) mView;

        int count2 = getChildrenViews(viewGroup);
        Log.d("viewCount:", "" + count2);

        useryelow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             userInfoDialog();
            }
        });


        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               showDialog();

            }
        });
        gifts1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGiftsDialog();
            }
        });
        gifts2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGiftsDialog();
            }
        });

        btnonplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ludoRed.setVisibility(View.VISIBLE);
                if (token) {
                    ludoRed.setVisibility(View.VISIBLE);
                    ludoRed.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            token = true;
                            Log.d("clicked", "yes" + token);
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
                } else {
                    ludoYellow.setVisibility(View.VISIBLE);
                    tokenRed1.setVisibility(View.VISIBLE);
                    tokenRed2.setVisibility(View.VISIBLE);
                    tokenRed3.setVisibility(View.VISIBLE);
                    tokenRed4.setVisibility(View.VISIBLE);

                    tokenYellow1.setVisibility(View.VISIBLE);
                    tokenYellow2.setVisibility(View.VISIBLE);
                    tokenYellow3.setVisibility(View.VISIBLE);
                    tokenYellow4.setVisibility(View.VISIBLE);

                    tokenBlue1.setVisibility(View.VISIBLE);
                    tokenBlue2.setVisibility(View.VISIBLE);
                    tokenBlue3.setVisibility(View.VISIBLE);
                    tokenBlue4.setVisibility(View.VISIBLE);

                    tokenGreen1.setVisibility(View.VISIBLE);
                    tokenGreen2.setVisibility(View.VISIBLE);
                    tokenGreen3.setVisibility(View.VISIBLE);
                    tokenGreen4.setVisibility(View.VISIBLE);

                }
                userred.setVisibility(View.VISIBLE);
                useryelow.setVisibility(View.VISIBLE);
            }
        });

//        ludoYellow.setBackgroundResource(R.drawable.dice_animation);
//        final AnimationDrawable frameAnimation = (AnimationDrawable) ludoYellow.getBackground();

        ludoBlue.setOnClickListener(this);
        ludoRed.setOnClickListener(this);
        ludoGreen.setOnClickListener(this);
        ludoYellow.setOnClickListener(this);

//            boolean b;
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
        return mView;
    }

    private void init() {

        AdView adView = new AdView(getActivity());
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        mAdView = mView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

// TODO: Add adView to your view hierarchy.
        View v = mView.findViewById(R.id.left_red);
        v.setAlpha(.7f);

        gifts1 = mView.findViewById(R.id.giftyellow);
        gifts2 = mView.findViewById(R.id.giftblue);

        rootView = mView.findViewById(R.id.framelayout_second);
        ludoBlue = mView.findViewById(R.id.ludo_image_view_blue);
        ludoGreen = mView.findViewById(R.id.ludo_image_view_green);
        ludoRed = mView.findViewById(R.id.ludo_image_view_red);
        ludoYellow = mView.findViewById(R.id.ludo_image_view_yellow);

        btnGoBack = mView.findViewById(R.id.goback);
        userred = mView.findViewById(R.id.user_image_red);
        useryelow = mView.findViewById(R.id.user_image_yellow);

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

        boardGame = mView.findViewById(R.id.gameboard);
        btnonplay = mView.findViewById(R.id.btnplay);

    }

    boolean b = false;

    @Override
    public void onClick(View view) {
        final AnimationDrawable frameAnimation;

        switch (view.getId()) {
            case R.id.ludo_image_view_yellow:

                ludoYellow.setBackgroundResource(R.drawable.dice_animation);
                ludoYellow.setScaleX(1.4f);
                ludoYellow.setScaleY(1.4f);
                frameAnimation = (AnimationDrawable) ludoYellow.getBackground();
                if (b == false) {
                    frameAnimation.start();

                    b = true;
                } else {
                    frameAnimation.stop();
                    ludoYellow.setScaleX(1);
                    ludoYellow.setScaleY(1);
                    b = false;
                }
                break;

            case R.id.ludo_image_view_red:
                ludoRed.setBackgroundResource(R.drawable.dice_animation);
                frameAnimation = (AnimationDrawable) ludoRed.getBackground();
                if (b == false) {
//                    frameAnimation.start();
//                    b=true;
                } else {
                    frameAnimation.stop();
//                    b=false;
                }
                break;

            case R.id.ludo_image_view_green:
                ludoGreen.setBackgroundResource(R.drawable.dice_animation);
                frameAnimation = (AnimationDrawable) ludoGreen.getBackground();
                if (b == false) {
//                    frameAnimation.start();
//                    b=true;
                } else {
                    frameAnimation.stop();
//                    b=false;
                }
                break;

            case R.id.ludo_image_view_blue:
                ludoBlue.setBackgroundResource(R.drawable.dice_animation);
                frameAnimation = (AnimationDrawable) ludoBlue.getBackground();
                if (b == false) {
//                    frameAnimation.start();
//                    b=true;
                } else {
                    frameAnimation.stop();
//                    b=false;
                }
                break;

        }
    }

    @Override
    public void onStart() {
        super.onStart();
//        ObjectAnimator scale = ObjectAnimator.ofFloat(boardGame,View.SCALE_X);
        Animation zerotoone = AnimationUtils.loadAnimation(getContext(), R.anim.scale0to1);
        boardGame.startAnimation(zerotoone);

    }

    public int getChildrenViews(ViewGroup parent) {
        int count = parent.getChildCount();
        for (int i = 0; i < parent.getChildCount(); i++) {
            if (parent.getChildAt(i) instanceof ViewGroup) {
                count += getChildrenViews((ViewGroup) parent.getChildAt(i));
            }
        }
        return count;
    }

    private int countChild(View view) {
        if (!(view instanceof ViewGroup))
            return 1;

        int counter = 0;

        ViewGroup viewGroup = (ViewGroup) view;

        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            counter += countChild(viewGroup.getChildAt(i));
        }

        return counter;
    }

    private void showDialog() {
        mStackLevel++;
//
//        // DialogFragment.show() will take care of adding the fragment
//        // in a transaction.  We also want to remove any currently showing
//        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = Dialogs.newInstance(mStackLevel);
        newFragment.show(ft, "dialog");
    }

    private void userInfoDialog() {
        mStackLevel++;
//
//        // DialogFragment.show() will take care of adding the fragment
//        // in a transaction.  We also want to remove any currently showing
//        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = UserInfoDalog.newInstance(mStackLevel);
        newFragment.show(ft, "dialog");
    }

    private void showGiftsDialog() {
        mStackLevel++;

//        // DialogFragment.show() will take care of adding the fragment
//        // in a transaction.  We also want to remove any currently showing
//        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        // Create and show the dialog.
        DialogFragment newFragment = GiftsDialog.newInstance(mStackLevel);
        newFragment.show(ft, "dialog");
    }
}
