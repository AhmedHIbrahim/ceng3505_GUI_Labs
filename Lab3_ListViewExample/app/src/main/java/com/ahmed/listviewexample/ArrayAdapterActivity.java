package com.ahmed.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ArrayAdapterActivity extends ListActivity {

   /* ListActivity -->
    An activity that displays a list of items by binding to a data source
    such as an array or Cursor,and exposes event handlers when the user selects an item.
   */

    //Creating a List of Animals under "ANIMALS" name.
    static final String[] ANIMALS = new String[]{"Ant","Bear","Bird","Cat",
            "Dog","Donkey","Elephant","Giraffe","Goat","Monkey",
            "Pig","Rat","Snake","Spider"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_array_adapter);   //<-- Commented


        setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_array_adapter, ANIMALS));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);
        //Implementing an OnItemClickListener for the ListView.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
