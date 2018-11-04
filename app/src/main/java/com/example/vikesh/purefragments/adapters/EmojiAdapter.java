package com.example.vikesh.purefragments.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vikesh.purefragments.EmojiDialog;
import com.example.vikesh.purefragments.R;

import java.util.List;
import java.util.zip.Inflater;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.MyViewHolder> {
//    private static ClickListener mClick;
    private List<String> mData;
    private LayoutInflater mInflater;
//    private ItemClickListener mClickListener;

    public EmojiAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = mInflater.inflate(R.layout.single_text_view,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String animal = mData.get(i);
        myViewHolder.setTextView(animal);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public static TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView =itemView.findViewById(R.id.tv_single_text);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {

//            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
        public void setTextView(String text){
            textView.setText(text);
        }

    }

}
