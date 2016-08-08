package com.l2l.androided.mh122354.dynamicuich1;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by mh122354 on 8/7/2016.
 */
public class BookListFragment2 extends ListFragment {

    private onSelectedBookChangedListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //TODO: Change Adapter to display content
        String[] bookTitles =
                getResources().getStringArray(R.array.bookTitles);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,bookTitles));
    }

    public void onAttach(Context context){
        super.onAttach(context);

        try{
            mListener= (onSelectedBookChangedListener)context;
        }catch (ClassCastException e){

            throw new ClassCastException(context.toString());
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);

        if(null!=mListener){
            mListener.onSelectedBookChanged(position);
        }


    }
}
