package com.ahmed.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterActivity extends AppCompatActivity {

    //Creating array list of animals which accepts <Animal> objects <-- Generic type
    final List<Animal> animals = new ArrayList<Animal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting content view which will be displayed when creating an instance of CustomAdapterActivity class
        setContentView(R.layout.activity_custom_adapter);

        //Adding Animal objects to animals array list
        animals.add(new Animal("Ant", R.mipmap.and_foreground));
        animals.add(new Animal("Bear", R.mipmap.bear_fore));
        animals.add(new Animal("Bird", R.mipmap.bird_fore));
        animals.add(new Animal("Cat", R.mipmap.cat_fore));
        animals.add(new Animal("Dog", R.mipmap.dog_fore));
        animals.add(new Animal("Donkey", R.mipmap.donkey_fore));
        animals.add(new Animal("Elephant", R.mipmap.elephant_fore));
        animals.add(new Animal("Giraffe", R.mipmap.giraffe_fore));
        animals.add(new Animal("Goat", R.mipmap.goat_fore));
        animals.add(new Animal("Monkey", R.mipmap.monkey_fore));
        animals.add(new Animal("Pig", R.mipmap.pig_fore));
        animals.add(new Animal("Rat", R.mipmap.rat_foreground));
        animals.add(new Animal("Snake", R.mipmap.snake_fore));
        animals.add(new Animal("Spider", R.mipmap.spider_fore));

        //Creating a ListView of the list_view layout using its id.
        final ListView listView = (ListView) findViewById(R.id.list_view);

        //From AnimalAdapter class create an instance object and push animals array list to it
        AnimalAdapter adapter = new AnimalAdapter(this,animals);

        //Setting the listView Adapter
        listView.setAdapter(adapter);
    }

}
