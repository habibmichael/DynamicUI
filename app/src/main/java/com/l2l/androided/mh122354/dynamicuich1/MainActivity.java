package com.l2l.androided.mh122354.dynamicuich1;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
            FragmentManager fm = getSupportFragmentManager();
            Fragment bookDescFragment =
                    fm.findFragmentById(R.id.fragmentDesc);

            //If not found we're doing dynamic management
            isDynamic = bookDescFragment == null || !bookDescFragment.isInLayout();

            //Load List if needed
            if(isDynamic){

                //Begin Transaction
                FragmentTransaction ft = fm.beginTransaction();

                //Create Fragment & Add
                BookListFragment2 listFragment = new BookListFragment2();
                ft.add(R.id.layoutRoot,listFragment,"bookList");

                ft.commit();
            }

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
        FragmentManager fm = getSupportFragmentManager();

        BookDescFragment bookDesc;

        if(isDynamic){

            //Replace list with desc fragment
            FragmentTransaction ft = fm.beginTransaction();
            bookDesc = BookDescFragment.newInstance(bookIndex);
            ft.replace(R.id.layoutRoot,bookDesc,"bookDescription");
            ft.addToBackStack(null);
            ft.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            ft.commit();
        }
        else{

            bookDesc = (BookDescFragment)fm.findFragmentById(R.id.fragmentDesc);
            bookDesc.setBook(bookIndex);
        }
    }


}

