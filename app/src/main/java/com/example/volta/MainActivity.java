package com.example.volta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private Toolbar toolbar;
    private DrawerLayout drawer;

    SpaceNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fireBaseAuthentification();




        navigationView = findViewById(R.id.space);
        navigationView.initWithSaveInstanceState(savedInstanceState);
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_insert_chart_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_add_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_person_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_settings_black_24dp));


       navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
           @Override
           public void onCentreButtonClick() {
               navigationView.setCentreButtonSelectable(true);
           }

           @Override
           public void onItemClick(int itemIndex, String itemName) {
               switch (itemIndex) {
                   case 0:
                       Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
                       break;
                   case 1:
                       Intent i = new Intent(MainActivity.this, AddSport.class);
                       startActivity(i);
                       break;
                   case 2:
                       Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
                       break;
                   case 3:
                       Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
                       break;

                   default:

               }
           }

           @Override
           public void onItemReselected(int itemIndex, String itemName) {

           }
       });

    }


    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
    private void fireBaseAuthentification(){
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();

        if(firebaseUser == null){
            startActivity(new Intent(this,ConnexionActivity.class));
            finish();
            return;
        }
    }




}
