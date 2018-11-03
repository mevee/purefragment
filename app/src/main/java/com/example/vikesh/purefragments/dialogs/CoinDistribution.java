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

import com.example.vikesh.purefragments.R;

public class CoinDistribution extends DialogFragment {

    private float x;
    private float y;
    private static View source;

    public CoinDistribution() {
        super();
    }
    public static CoinDistribution newInstance(int num, View view) {
        source = view;
        return new CoinDistribution();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.coine_distrbution,container,false);

        Window window = getDialog().getWindow();

        // set "origin" to top left corner, so to speak
//        window.setGravity(Gravity.TOP|Gravity.LEFT);

        // after that, setting values for x and y works "naturally"
        WindowManager.LayoutParams params = window.getAttributes();

        params.x = (int) x;
        params.y = (int) y;

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
//        float a1 =source.getX();
//        float a2 = source.getY();
        int sourceX = location[0];
        int sourceY = location[1];

        Window window = getDialog().getWindow();

        // set "origin" to top left corner
        window.setGravity(Gravity.TOP|Gravity.LEFT);

        WindowManager.LayoutParams params = window.getAttributes();
        int x1 = (int)(getResources().getDimension(R.dimen.golddis_dialogofsetx)/getResources().getDisplayMetrics().density);
        int y1 = (int)(getResources().getDimension(R.dimen.golddis_dialogofsety)/getResources().getDisplayMetrics().density);

        // Just an example; edit to suit your needs.
        params.x = sourceX - dpToPx(0); // about half of confirm button size left of source view
        params.y = sourceY - (y1); // above source view

        window.setAttributes(params);
    }

    public int dpToPx(float valueInDp) {
        DisplayMetrics metrics = getActivity().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }
}
