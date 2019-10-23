package com.ahmed.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmed.listviewexample.R;

import java.util.List;

public class AnimalAdapter extends BaseAdapter {
    //needed Variables
    private LayoutInflater mInFlater;    //it is a variable of the Activity when class is called by CustomAdapterActivity
    private List<Animal> animals;        //it is a variable of the the list when class is called by CustomAdapterActivity


    public AnimalAdapter(Activity activity, List<Animal> animals){
        mInFlater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.animals = animals;

    }
    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Object getItem(int i) {
        return animals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View rowView;

        rowView = mInFlater.inflate(R.layout.activity_listview_row, null);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.pic);


        Animal animal = animals.get(i);
        textView.setText(animal.getType());
        imageView.setImageResource(animal.getPicId());

        return rowView;
    }
}


