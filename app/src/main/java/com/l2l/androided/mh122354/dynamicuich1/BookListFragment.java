package com.l2l.androided.mh122354.dynamicuich1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mh122354 on 8/2/2016.
 */
public class BookListFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState){

        View viewHierarchy = inflater.inflate(R.layout.fragment_book_list,container,false);

        return viewHierarchy;


    }
}
