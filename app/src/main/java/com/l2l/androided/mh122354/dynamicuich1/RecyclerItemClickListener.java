package com.l2l.androided.mh122354.dynamicuich1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mh122354 on 8/13/2016.
 */
public class RecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    GestureDetector mGestureDetector;

    public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        if(mGestureDetector.onTouchEvent(e)) {
            View theView = view.findChildViewUnder(e.getX(), e.getY());
            if(mListener != null && theView != null)
                mListener.onItemClick(theView, view.getChildAdapterPosition(theView));
            return true;
        }
        return false;
    }

}