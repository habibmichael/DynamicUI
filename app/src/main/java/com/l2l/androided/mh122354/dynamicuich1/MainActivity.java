package com.l2l.androided.mh122354.dynamicuich1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements onSelectedBookChangedListener{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // load the activity_main layout resource
            setContentView(R.layout.activity_main);


        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }


    @Override
    public void onSelectedBookChanged(int bookIndex) {
        //Access fragment manager
      android.app.FragmentManager fragmentManager = getFragmentManager();

        BookDescFragment bookDescFragment = (BookDescFragment)
                fragmentManager.findFragmentById(R.id.fragmentDesc);

        //Display book title
        if(bookDescFragment!=null)
            bookDescFragment.setBook(bookIndex);
    }
}

