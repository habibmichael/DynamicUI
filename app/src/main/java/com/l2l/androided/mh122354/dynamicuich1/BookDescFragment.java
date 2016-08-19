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

    public static final String BOOK_INDEX = "book index";
    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_IMAGE_ID = "image id";
    private static final String ARG_POSITION = "position";

    private static final int BOOK_INDEX_NOT_SET = -1;

    private onSelectedBookChangedListener mListener;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View viewHierarchy = inflater.inflate(R.layout.fragment_book_desc,container,false);

        viewHierarchy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onSelectedBookChanged(view,0);
            }
        });

        //Load array of book descriptions
        mBookDescriptions = getResources().getStringArray(R.array.bookDescriptions);
        //Get refrence to textview of book desc
        mBookDescriptionTextView = (TextView)viewHierarchy.findViewById(R.id.bookDescription);

        //Retrieve index if attached
        Bundle args = getArguments();
        int bookIndex = args!=null?
                args.getInt(BOOK_INDEX,BOOK_INDEX_NOT_SET): BOOK_INDEX_NOT_SET;

        if(bookIndex!=BOOK_INDEX_NOT_SET){
            setBook(bookIndex);


        }


        return viewHierarchy;


    }

    public void setBook(int bookIndex){

        //look up & display desc
        String bookDesc = mBookDescriptions[bookIndex];
        mBookDescriptionTextView.setText(bookDesc);
    }

    //Simplifies process of creating an istance and passing in the index value

    public static BookDescFragment newInstance(String title, String description,
                                               int imageResourceId, int position) {
        BookDescFragment fragment = new BookDescFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESCRIPTION, description);
        args.putInt(ARG_IMAGE_ID, imageResourceId);
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }



}
