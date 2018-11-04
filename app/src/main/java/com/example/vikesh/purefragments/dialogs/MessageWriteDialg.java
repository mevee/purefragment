package com.example.vikesh.purefragments.dialogs;

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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vikesh.purefragments.Dialogs;
import com.example.vikesh.purefragments.R;

public class MessageWriteDialg extends DialogFragment {

    private float x;
    private float y;

    private static View source;

    private int mNum;
    private TextView tvOk,tvCancel,tvtitle,tvcontent;
    private EditText etMessage;
    private Button btnOk;
    private Switch chatswitch;
    private static String IMAGEIS;

    public static MessageWriteDialg newInstance(int num,View view) {
        source = view;
        MessageWriteDialg f = new MessageWriteDialg();

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

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.mesaage_write_dialog, container, false);

        etMessage = view.findViewById(R.id.message_write);
        btnOk=view.findViewById(R.id.send_message);
        chatswitch =view.findViewById(R.id.switch_chat);
        chatswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String message = etMessage.getText().toString();
              showMessageDialog(message);
              getDialog().dismiss();
            }
        });

        Window window = getDialog().getWindow();

        // set "origin" to top left corner, so to speak
        window.setGravity(Gravity.BOTTOM|Gravity.LEFT);

        // after that, setting values for x and y works "naturally"
        WindowManager.LayoutParams params = window.getAttributes();
        int x1 = (int)(getResources().getDimension(R.dimen.chat_dialog_ofsetx)/getResources().getDisplayMetrics().density);
        int y1 = (int)(getResources().getDimension(R.dimen.chat_dialog_ofsety)/getResources().getDisplayMetrics().density);

        params.x = (int)x1+20;
        params.y = y1;

        window.setAttributes(params);

        Log.d("onCreateView", String.format("Positioning DialogFragment to: x %d; y %d", params.x, params.y));
//        setDialogPosition();

        return view;
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
        params.x = 70;  // about half of confirm button size left of source view
        params.y = 200;
//        (sourceY/(getResources().getDisplayMetrics().density)); // above source view
//        params.y =200;
//        params.x =10;
        window.setAttributes(params);
    }

    public int dpToPx(float valueInDp) {
        DisplayMetrics metrics = getActivity().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    private void showMessageDialog(String message) {
      if (message==null){
          message ="Helllow Friend";
      }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        Fragment prev = getFragmentManager().findFragmentByTag("message");
//        if (prev != null) {
//            ft.remove(prev);
//        }
//        ft.addToBackStack(null);
        // Create and show the dialog.
        DialogFragment newFragment = ChatMessageDialog.newInstance(2,message,"e1");
        newFragment.show(ft, "message");
    }


}
