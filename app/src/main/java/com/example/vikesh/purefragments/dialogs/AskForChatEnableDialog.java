package com.example.vikesh.purefragments.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.vikesh.purefragments.R;
import com.example.vikesh.purefragments.dialogs.ChatMessageDialog;
import com.example.vikesh.purefragments.dialogs.MessageWriteDialg;


public class AskForChatEnableDialog extends DialogFragment {
    private float x;
    private float y;
    private Button btnYes,btnNo;

    private static View source;

    public AskForChatEnableDialog() {

    }

    public static AskForChatEnableDialog newInstance(int num, View view) {
         source = view;
        return new AskForChatEnableDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.askforchatenabledialog,container,false);
        btnYes = view.findViewById(R.id.bt_yes_chat);
        btnNo = view.findViewById(R.id.bt_no_chat);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessageWriteDialog();
                dismiss();
//                getDialog().dismiss();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        Window window = getDialog().getWindow();

        // set "origin" to top left corner, so to speak
        window.setGravity(Gravity.BOTTOM|Gravity.LEFT);

        // after that, setting values for x and y works "naturally"
        WindowManager.LayoutParams params = window.getAttributes();
        int x1 = (int)(getResources().getDimension(R.dimen.chat_dialog_ofsetx)/getResources().getDisplayMetrics().density);

        params.x = (int)x;
        params.y = (int)y;

        window.setAttributes(params);

        Log.d("onCreateView", String.format("Positioning DialogFragment to: x %d; y %d", params.x, params.y));
      setDialogPosition();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setStyle(STYLE_NO_FRAME, R.style.Dialog);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Less dimmed background; see https://stackoverflow.com/q/13822842/56285
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.dimAmount = 0.0f; // dim only a little bit
        window.setAttributes(params);

        // Transparent background; see https://stackoverflow.com/q/15007272/56285
        // (Needed to make dialog's alpha shadow look good)
        window.setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getFragmentManager().popBackStack();
    }

    private void setDialogPosition() {
        if (source == null) {
            return; // Leave the dialog in default position
        }
        // Find out location of source component on screen
        // see https://stackoverflow.com/a/6798093/56285
        int[] location = new int[2];
        source.getLocationOnScreen(location);
        int sourceX = location[0];
        int sourceY = location[1];

        Window window = getDialog().getWindow();

        // set "origin" to top left corner
        window.setGravity(Gravity.BOTTOM|Gravity.LEFT);


        WindowManager.LayoutParams params = window.getAttributes();
        int x1 = (int)(getResources().getDimension(R.dimen.chat_dialog_ofsetx)/getResources().getDisplayMetrics().density);
        int y1 = (int)(getResources().getDimension(R.dimen.chat_dialog_ofsety)/getResources().getDisplayMetrics().density);

//        Just an example; edit to suit your needs.
        params.x = x1;  // about half of confirm button size left of source view
        params.y = y1;
//        (sourceY/(getResources().getDisplayMetrics().density)); // above source view
//        params.y =200;
//        params.x =10;
                window.setAttributes(params);
    }

    public int dpToPx(float valueInDp) {
        DisplayMetrics metrics = getActivity().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    private void showMessageWriteDialog(){

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        // Create and show the dialog.
        DialogFragment newFragment = MessageWriteDialg.newInstance(1,getView().findViewById(R.id.emoji_layout));
        newFragment.show(ft, "messagewrite");

    }
}
