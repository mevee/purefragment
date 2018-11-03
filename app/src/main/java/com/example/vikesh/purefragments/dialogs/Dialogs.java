package com.example.vikesh.purefragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dialogs extends DialogFragment {
    private int mNum;
    private TextView tvOk,tvCancel,tvtitle,tvcontent;

    public static Dialogs newInstance(int num) {
        Dialogs f = new Dialogs();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");

//        // Pick a style based on the num.
//        int style = DialogFragment.STYLE_NORMAL, theme = 0;
//        switch ((mNum-1)%6) {
//            case 1: style = DialogFragment.STYLE_NO_TITLE; break;
//            case 2: style = DialogFragment.STYLE_NO_FRAME; break;
//            case 3: style = DialogFragment.STYLE_NO_INPUT; break;
//            case 4: style = DialogFragment.STYLE_NORMAL; break;
//            case 5: style = DialogFragment.STYLE_NORMAL; break;
//            case 6: style = DialogFragment.STYLE_NO_TITLE; break;
//            case 7: style = DialogFragment.STYLE_NO_FRAME; break;
//            case 8: style = DialogFragment.STYLE_NORMAL; break;
//        }
//        switch ((mNum-1)%6) {
//            case 4: theme = android.R.style.Theme_Holo; break;
//            case 5: theme = android.R.style.Theme_Holo_Light_Dialog; break;
//            case 6: theme = android.R.style.Theme_Holo_Light; break;
//            case 7: theme = android.R.style.Theme_Holo_Light_Panel; break;
//            case 8: theme = android.R.style.Theme_Holo_Light; break;
//        }
//        setStyle(style, theme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.dialogs_layout, container, false);
          tvtitle = view.findViewById(R.id.tv_dialog_title);
          tvcontent = view.findViewById(R.id.content_of_dialog);
          tvCancel = view.findViewById(R.id.tvcancel);
          tvOk = view.findViewById(R.id.tv_ok);

          tvOk.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(getContext(), "YouClicked ok", Toast.LENGTH_SHORT).show();
                  getDialog().dismiss();
              }
          });

          tvCancel.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  getDialog().dismiss();
              }
          });

        return view;
    }


}
