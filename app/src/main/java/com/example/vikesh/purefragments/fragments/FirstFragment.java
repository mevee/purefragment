package com.example.vikesh.purefragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vikesh.purefragments.R;

public class FirstFragment extends Fragment {
private Context mContext;
private View mView;
    public FirstFragment() {
    }

      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_first, container, false);
//        Bundle bundel = getArguments();
//        bundel.getString("kasjkdhsjk");
        // Inflate the layout for this fragment
        init();
        return mView;
    }

    private void init() {

    }

}
