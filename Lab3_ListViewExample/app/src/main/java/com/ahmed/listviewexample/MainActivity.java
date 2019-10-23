package com.ahmed.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btnArrayAdapter;
    Button btnCustomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get btnArrayAdapter from resources and assign it to btnArrayAdapter
        btnArrayAdapter = (Button) findViewById(R.id.btnArrayAdapter);

        //When btnArrayAdapter is clicked
        btnArrayAdapter.setOnClickListener(new View.OnClickListener(){

           @Override
            public void onClick(View view){

               //Android Intent is the message that is passed between components such as activities, content providers,etc.
               Intent intent = new Intent(MainActivity.this,ArrayAdapterActivity.class);

               //method to invoke ArrayAdapterActivity
               startActivity(intent);

           }
        });


        //Get btnCustomAdapter from resources and assign it to btnCustomAdapter
        btnCustomAdapter = (Button) findViewById(R.id.btnCustomAdapter);

        //When btnCustomAdapter is clicked
        btnCustomAdapter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                //Android Intent is the message that is passed between components such as activities, content providers,etc.
                Intent intent = new Intent(MainActivity.this,CustomAdapterActivity.class);

                //method to invoke ArrayAdapterActivity
                startActivity(intent);

            }
        });
    }
}
