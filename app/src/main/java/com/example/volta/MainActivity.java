package com.example.volta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fireBaseAuthentification();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AcceuilActivity()).commit();
            navigationView.setCheckedItem(R.id.nav_Acceuil);
        }

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       switch(menuItem.getItemId()){
           case R.id.nav_Acceuil:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AcceuilActivity()).commit();
               break;
           case R.id.nav_Analyse:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new analyseActivity()).commit();
               break;
           case  R.id.nav_Deco:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new deconnecterActivity()).commit();
               break;
           case  R.id.nav_Para:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new parametreActivity()).commit();
               break;
           case R.id.nav_Pref:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new preferencesActivity()).commit();
               break;
           case R.id.nav_Profil:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new profilActivty()).commit();
               break;
       }
       drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
