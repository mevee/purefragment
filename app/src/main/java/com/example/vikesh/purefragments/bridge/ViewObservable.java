package com.example.vikesh.purefragments.bridge;

import android.view.View;

import java.io.Serializable;
import java.util.Observable;

public class ViewObservable  {
    private View source;

    public View getSource() {
        return source;
    }

    public void setSource(View source) {
        this.source = source;

    }
}
