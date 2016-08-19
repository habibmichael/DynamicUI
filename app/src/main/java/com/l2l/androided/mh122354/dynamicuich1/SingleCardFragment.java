package com.l2l.androided.mh122354.dynamicuich1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mh122354 on 8/13/2016.
 */
public class SingleCardFragment extends Fragment {
    public static SingleCardFragment newInstance() {
        SingleCardFragment fragment = new SingleCardFragment();
        return fragment;
    }

    public SingleCardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.book_card_view, container, false);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectedBookChangedListener listener = (onSelectedBookChangedListener)getActivity();

                listener.onSelectedBookChanged(rootView, 0);
            }
        });
        return rootView;
    }


}