package com.example.vikesh.purefragments.dialogs;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
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

import com.example.vikesh.purefragments.EmojiDialog;
import com.example.vikesh.purefragments.R;
import com.example.vikesh.purefragments.bridge.ViewObservable;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class GameInfo extends DialogFragment {

    private int x;
    private int  y;
    private View source;
    private static View viewSource;
//    private  View source;

    public GameInfo() {

    }

    public static GameInfo newInstance(int num, View view) {
        viewSource = view;
        return new GameInfo();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.gemeinfo_dialog,container,false);
        Window window = getDialog().getWindow();

        // set "origin" to top left corner, so to speak
        window.setGravity(Gravity.TOP|Gravity.CENTER);

//         after that, setting values for x and y works "naturally"
        WindowManager.LayoutParams params = window.getAttributes();
        int x1 = (int)(getResources().getDimension(R.dimen.info_dialogofsetx)/getResources().getDisplayMetrics().density);

        params.x =  - x1;
        params.y =  -10;

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
        viewSource.getLocationOnScreen(location);
        int sourceX = location[0];
        int sourceY = location[1];
        Log.d("onCreateView_", String.format("Positioning  to: x1 %d; y1 %d", sourceX, sourceY));

        Window window = getDialog().getWindow();

        // set "origin" to top left corner
//        window.setGravity(Gravity.TOP|Gravity.LEFT);

        WindowManager.LayoutParams params = window.getAttributes();

        // Just an example; edit to suit your needs.
        params.x = sourceX - dpToPx(80); // about half of confirm button size left of source view
        params.y = sourceY - dpToPx(100); // above source view

        window.setAttributes(params);
    }

    public int dpToPx(float valueInDp) {
        DisplayMetrics metrics = getActivity().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }
}
