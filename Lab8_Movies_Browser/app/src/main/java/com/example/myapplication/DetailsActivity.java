package com.example.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);

        Movie movie = (Movie)getIntent().getSerializableExtra("movie");

        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        detailsFragment df = detailsFragment.newInstance(movie);

        fts.add(R.id.container, df);
        fts.commit();
    }
}