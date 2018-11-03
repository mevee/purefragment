package com.example.vikesh.purefragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;
import android.widget.TextView;

import com.example.vikesh.purefragments.R;

public class ChatMessageDialog extends DialogFragment {
    public static View source;
    private int BYUSER;
    private View mView;
    private float x,y;
    private static int USER =1;
    private static String message;
    private TextView tvMessage;
    private static final int USER_RED =1,USER_BLUE=2,USER_GREEN=3,USER_YELLOW=4;

    public static ChatMessageDialog newInstance(int num,String s){
        if (s!=null){message = s;}
        else message = "Empty Message";
//        source = view;
        USER =num;
        return new ChatMessageDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.chatmessage_diaog,container,false);
        tvMessage = mView.findViewById(R.id.tv_message_is);
        tvMessage.setText("+"+message);
        Window window = getDialog().getWindow();

        switch(USER){
            case USER_RED:  window.setGravity(Gravity.BOTTOM|Gravity.LEFT);
            break;
            case USER_BLUE: window.setGravity(Gravity.BOTTOM|Gravity.RIGHT);
            break;
            case USER_GREEN:  window.setGravity(Gravity.TOP|Gravity.LEFT);
                break;
            case USER_YELLOW: window.setGravity(Gravity.TOP|Gravity.RIGHT);
                break;

        }

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
        return mView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mNum = getArguments().getInt("num");

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
    public void onDestroyView() {
        super.onDestroyView();
        getFragmentManager().popBackStack();
    }

    private void setDialogPosition() {
//        if (source == null) {
//            return; // Leave the dialog in default position
//        }
//        // Find out location of source component on screen
//        // see https://stackoverflow.com/a/6798093/56285
//        int[] location = new int[2];
//        source.getLocationOnScreen(location);
//        int sourceX = location[0];
//        int sourceY = location[1];

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

}
