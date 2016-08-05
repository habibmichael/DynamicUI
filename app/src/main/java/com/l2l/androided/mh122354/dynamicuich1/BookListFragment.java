package com.l2l.androided.mh122354.dynamicuich1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by mh122354 on 8/2/2016.
 */
public class BookListFragment extends Fragment
    implements RadioGroup.OnCheckedChangeListener{


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState){

        View viewHierarchy = inflater.inflate(R.layout.fragment_book_list,container,false);

        //Set listener to BookListFragment  class
        RadioGroup group = (RadioGroup)viewHierarchy.findViewById(R.id.bookSelectGroup);
        group.setOnCheckedChangeListener(this);

        return viewHierarchy;


    }

    //Translates book ids to indexes
    public int translateToIndex(int id){

        int index=-1;

        switch(id){
            case R.id.dynamicUiBook:
                index=0;
                break;
            case R.id.android4NewBook:
                index=1;
                break;
            case R.id.androidSysDevBook:
                index=2;
                break;
            case R.id.androidEngineBook:
                index=3;
                break;
            case R.id.androidDbProgBook:
                index=4;
                break;

        }

        return index;




    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        int bookIndex = translateToIndex(i);

        //Get parent activity & send notification
        onSelectedBookChangedListener listener =
                (onSelectedBookChangedListener)getActivity();

        listener.onSelectedBookChanged(bookIndex);

    }
}
