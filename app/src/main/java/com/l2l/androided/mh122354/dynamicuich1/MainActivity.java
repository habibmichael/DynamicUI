package com.l2l.androided.mh122354.dynamicuich1;



import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements onSelectedBookChangedListener{

    boolean isDynamic;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // load the activity_main layout resource
            setContentView(R.layout.activity_main);

            //Get book Description Fragment
            FragmentManager fm = getFragmentManager();
            Fragment bookDescFragment =
                    fm.findFragmentById(R.id.fragmentDesc);

            //If not found we're doing dynamic management
            isDynamic = bookDescFragment == null || !bookDescFragment.isInLayout();

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

