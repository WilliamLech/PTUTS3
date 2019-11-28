package com.example.volta;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class test extends AppCompatActivity {

    SpaceNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.space);
        navigationView.initWithSaveInstanceState(savedInstanceState);
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_insert_chart_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_add_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_person_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_settings_black_24dp));

        navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(test.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(test.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(test.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
