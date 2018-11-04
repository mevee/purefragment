package com.example.vikesh.purefragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.vikesh.purefragments.adapters.EmojiAdapter;
import com.example.vikesh.purefragments.dialogs.MessageWriteDialg;
import com.example.vikesh.purefragments.fragments.AskForChatEnableDialog;

import java.util.ArrayList;
import java.util.List;

public class EmojiDialog extends DialogFragment {

    private float x;
    private float y;
    private static View source;
    private RecyclerView prefixedTextList;
    private EmojiAdapter mAdapter;
    private List<String> mList;
    private View emoji1,emoji2;


    public EmojiDialog() {
        super();
    }

    public static EmojiDialog newInstance(int num, View view) {
        source = view;
        return new EmojiDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.emoji_dialog, container, false);
        emoji1 = view.findViewById(R.id.emoji1);
        emoji1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        prefixedTextList = view.findViewById(R.id.recycler_View_Chat_text);
        mList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i > 3 && i < 6)
                mList.add("message is br" + i);
            else
                mList.add("message" + i);

        }
        mAdapter = new EmojiAdapter(getContext(), mList);

        prefixedTextList.hasFixedSize();
        prefixedTextList.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        prefixedTextList.setAdapter(mAdapter);

        Window window = getDialog().getWindow();

        //        // set "origin" to top left corner, so to speak
        ////        window.setGravity(Gravity.TOP|Gravity.LEFT);
        //
        //        // after that, setting values for x and y works "naturally"
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
        int sourceX = location[0];
        int sourceY = location[1];

        Window window = getDialog().getWindow();

        // set "origin" to top left corner
        window.setGravity(Gravity.BOTTOM | Gravity.LEFT);

        WindowManager.LayoutParams params = window.getAttributes();
        int x1 = (int) (getResources().getDimension(R.dimen.chat_dialog_ofsetx) / getResources().getDisplayMetrics().density);
        int y1 = (int) (getResources().getDimension(R.dimen.chat_dialog_ofsety) / getResources().getDisplayMetrics().density);

//        Just an example; edit to suit your needs.
//        params.x = x1;  // about half of confirm button size left of source view
//        params.y = y1;
        params.x = x1;
        params.y = y1;
        window.setAttributes(params);
    }

    public int dpToPx(float valueInDp) {
        DisplayMetrics metrics = getActivity().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }
    private void showMessage()
    {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        // Create and show the dialog.
        DialogFragment newFragment = MessageWriteDialg.newInstance(1,getView().findViewById(R.id.emoji_layout));
        newFragment.show(ft, "messagewrite");

    }
}
