package com.example.volta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;

public class AddSport extends AppCompatActivity {

    SpaceNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sport);


        navigationView = findViewById(R.id.space);
        navigationView.initWithSaveInstanceState(savedInstanceState);
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_insert_chart_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_add_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_person_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_settings_black_24dp));

//Utiliser des fragments pour passer entre les pages + check pour color item selected en rapport avce la page
    }
}
