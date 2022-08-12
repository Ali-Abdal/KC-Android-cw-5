package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        TextView cardname = findViewById(R.id.nameact3);
        TextView cardage = findViewById(R.id.ageact3);
        TextView carddes = findViewById(R.id.desact3);



        Bundle act1 = getIntent().getExtras();


        String crdname = act1.getString("name");
        cardname.setText(crdname);

        int crdage = act1.getInt("age");
        cardage.setText(String.valueOf(crdage));

        String crddes = act1.getString("des");
        carddes.setText(crddes);




    }
}