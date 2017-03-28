package com.example.smilyrating;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileyRating;

public class MainActivity extends AppCompatActivity implements SmileyRating.OnSmileySelectionListener, SmileyRating.OnRatingSelectedListener {

    private static final String TAG = "MainActivity";

    private SmileyRating mSmileyRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSmileyRating = (SmileyRating) findViewById(R.id.ratingView);
        mSmileyRating.setOnSmileySelectionListener(this);
        mSmileyRating.setOnRatingSelectedListener(this);
        mSmileyRating.setSelectedSmiley(BaseRating.GREAT);
    }

    @Override
    public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
        switch (smiley) {
            case SmileyRating.BAD:
                Log.i(TAG, "Bad");
                break;
            case SmileyRating.GOOD:
                Log.i(TAG, "Good");
                break;
            case SmileyRating.GREAT:
                Log.i(TAG, "Great");
                break;
            case SmileyRating.OKAY:
                Log.i(TAG, "Okay");
                break;
            case SmileyRating.TERRIBLE:
                Log.i(TAG, "Terrible");
                break;
        }
    }

    @Override
    public void onRatingSelected(int level, boolean reselected) {
        Log.i(TAG, "Rated as: " + level + " - " + reselected);
    }
}
