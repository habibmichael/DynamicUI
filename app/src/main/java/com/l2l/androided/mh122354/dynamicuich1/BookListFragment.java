package com.l2l.androided.mh122354.dynamicuich1;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by mh122354 on 8/2/2016.
 */
public class BookListFragment extends Fragment {

    private onSelectedBookChangedListener mListener;
    private String[] mTitles;
    private int[] mImageResourceIds;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState){

        mAdapter = new BookAdapter(mTitles,mImageResourceIds);
    }

    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState){

        View viewHierarchy = inflater.inflate(R.layout.book_card_view,container,false);
        mRecyclerView = (RecyclerView)viewHierarchy.findViewById(R.id.book_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(),
                        new RecyclerItemClickListener.OnItemClickListener(){
                            @Override
                            public void onItemClick(View v , int position){
                                mListener.onSelectedBookChanged(v, position);
                            }
                        })
        );




        return viewHierarchy;


    }

    @Override
    public void onAttach(Context context){

        super.onAttach(context);
        mListener = (onSelectedBookChangedListener)context;
    }




}
