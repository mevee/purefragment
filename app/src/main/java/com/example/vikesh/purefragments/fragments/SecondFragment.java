package com.example.vikesh.purefragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vikesh.purefragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private View mView;

    public SecondFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_second, container, false);
        init();
        return mView;
    }

    private void init() {
    }

}
