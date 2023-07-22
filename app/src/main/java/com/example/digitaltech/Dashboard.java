package com.example.digitaltech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Calendar;

public class Dashboard extends AppCompatActivity {
    CardView btnincident,btnprofile,btntips,btnreports;
    ImageView btnlogout;
    @Override
    protected  void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.dashboard);
        btnincident = (CardView) findViewById(R.id.btnincident);

        btnlogout=(ImageView) findViewById(R.id.btnlogout);
        btnprofile=(CardView) findViewById(R.id.btnprofile);



        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Dashboard.this, SignIn.class);
                startActivity(intent);
            }
        });



        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( Dashboard.this,Profile.class);
            }
        });

        btnincident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Incident.class);
                startActivity(intent);

            }
        });
    }
}
