package com.l2l.androided.mh122354.dynamicuich1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by mh122354 on 8/2/2016.
 */
public class BookDescFragment extends Fragment {

    String[] mBookDescriptions;
    TextView mBookDescriptionTextView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View viewHierarchy = inflater.inflate(R.layout.fragment_book_desc,container,false);

        //Load array of book descriptions
        mBookDescriptions = getResources().getStringArray(R.array.bookDescriptions);
        //Get refrence to textview of book desc
        mBookDescriptionTextView = (TextView)viewHierarchy.findViewById(R.id.bookDescription);


        return viewHierarchy;


    }

    public void setBook(int bookIndex){

        //look up & display desc
        String bookDesc = mBookDescriptions[bookIndex];
        mBookDescriptionTextView.setText(bookDesc);
    }


}
