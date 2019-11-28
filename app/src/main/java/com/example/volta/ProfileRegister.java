package com.example.volta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hereshem.lib.recycler.MyRecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProfileRegister extends AppCompatActivity {

    private Button valider;
    private DatabaseReference data;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_register);

        data = FirebaseDatabase.getInstance().getReference("volta-47230");
        data.child("user").setValue("Tony");

        valider = findViewById(R.id.valider);

        listView = (ListView) findViewById(R.id.liste);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Homme");
        arrayList.add("Femme");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);


        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileRegister.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
