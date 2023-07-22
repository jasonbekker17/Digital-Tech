package com.example.digitaltech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Incident extends AppCompatActivity {
    TextView btnsubmit ;
    EditText gender,email,phone,firstname,lastname,incident;
    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident);

        btnsubmit=(TextView) findViewById(R.id.btnsubmit);
        gender=(EditText) findViewById(R.id.gender);
        email=(EditText) findViewById(R.id.email);
        phone=(EditText) findViewById(R.id.phone);
        firstname=(EditText) findViewById(R.id.firstname);
        lastname=(EditText) findViewById(R.id.lastname);
        incident=(EditText) findViewById(R.id.incident) ;

        DB = new DBHelper(Incident.this);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email.getText().toString();
                String gender1 = gender.getText().toString();
                Integer phone1 = Integer.parseInt(phone.getText().toString());

                String firstname1 = firstname.getText().toString();
                String lastname1 = lastname.getText().toString();
                String incident1 = incident.getText().toString();

                IncidentModel incidentModel;

                try {
                    incidentModel= new IncidentModel(email1,incident1,firstname1,lastname1,gender1,-1,phone1);
                    Toast.makeText(Incident.this,incidentModel.toString(),Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(Incident.this,"Error creating incident",Toast.LENGTH_SHORT).show();
                    incidentModel=new IncidentModel(email1,"error","error","error","error",-1,phone1);


                }



                Boolean success= DB.insertIncident(incidentModel);






            }
        });
    }
}