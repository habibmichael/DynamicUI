package com.l2l.androided.mh122354.dynamicuich1;



import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.Image;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends Activity implements onSelectedBookChangedListener{

    boolean isDynamic;

    String[] mTitles;
    String[] mDescriptions;

    //book images
    int[] mImageLargeResourceIds = {
            R.drawable.db_programming_top_card,
            R.drawable.dynamic_ui_top_card,
            R.drawable.sys_dev_top_card,
            R.drawable.and_engine_top_card

    };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // load the activity_main layout resource
            setContentView(R.layout.activity_main);

            //Get book titles & descriptions
            mTitles = getResources().getStringArray(R.array.bookTitles);
            mDescriptions = getResources().getStringArray(R.array.bookDescriptions);

            //Get book Description Fragment
            FragmentManager fm = getFragmentManager();
            Fragment bookDescFragment =
                    fm.findFragmentById(R.id.fragmentDesc);

            //If not found we're doing dynamic management
            isDynamic = bookDescFragment == null || !bookDescFragment.isInLayout();

            //Load List if needed
            if(isDynamic){

                Slide slideLeftTransistion = new Slide(Gravity.LEFT);
                slideLeftTransistion.setDuration(500);
                BookListFragment listFragment = new BookListFragment();
                listFragment.setExitTransition(slideLeftTransistion);

                //Begin Transaction
                FragmentTransaction ft = fm.beginTransaction();

                //Create Fragment & Add

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
    public void onSelectedBookChanged(View view,int bookIndex) {

        Slide slideBottomTransition = new Slide(Gravity.BOTTOM);
        slideBottomTransition.setDuration(500);

        //Get references to image and titles
        ImageView bookImageView = (ImageView)view.findViewById(R.id.topImage);
        TextView titleTextView = (TextView)view.findViewById(R.id.bookTitle);
        TransitionSet sharedTransitionSet = new TransitionSet();
        sharedTransitionSet.addTransition(new ChangeBounds()).addTransition(
                new ChangeTransform()).setDuration(500);

        BookDescFragment bookDescFragment = BookDescFragment.newInstance(mTitles[bookIndex],
                mDescriptions[bookIndex],mImageLargeResourceIds[bookIndex],bookIndex);

        bookDescFragment.setEnterTransition(slideBottomTransition);
        bookDescFragment.setAllowEnterTransitionOverlap(false);
        bookDescFragment.setSharedElementEnterTransition(
                sharedTransitionSet
        );

        //Access fragment manager
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .replace(R.id.layoutRoot,bookDescFragment)
                .addSharedElement(bookImageView,"book_image"+bookIndex)
                .addSharedElement(titleTextView,"title_text"+bookIndex)
                .addToBackStack(null)
                .commit();



    }


}

