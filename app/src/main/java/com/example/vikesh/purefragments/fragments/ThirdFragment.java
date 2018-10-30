package com.example.vikesh.purefragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vikesh.purefragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {
   private View mView;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_third, container, false);

        ViewGroup viewGroup = (ViewGroup) mView;

        int count2 = getChildrenViews(viewGroup);
        Log.d("viewCountThirdFragment:",""+count2);
        return mView;
    }

    public int getChildrenViews(ViewGroup parent){
        int count = parent.getChildCount();
        for (int i=0;i<parent.getChildCount();i++){
            if (parent.getChildAt(i) instanceof ViewGroup){
                count+= getChildrenViews((ViewGroup) parent.getChildAt(i));
            }
        }
        return count;
    }

}
