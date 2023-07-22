package com.example.digitaltech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Entity;
import org.w3c.dom.Text;

public class Signup extends AppCompatActivity {
    EditText fullname, email, password, repassword;
    TextView btnsignup, btnsignin;
    DBHelper DB;
    final String secretKey="donottouch";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        email = (EditText) findViewById(R.id.email);
        fullname = (EditText) findViewById(R.id.fullname);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);

        btnsignup = (TextView) findViewById(R.id.btnsignup);
        btnsignin = (TextView) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email.getText().toString();
                String pass1 = password.getText().toString();
                String fullname1 = fullname.getText().toString();
                String repass1 = repassword.getText().toString();
                MyAES myaes=new MyAES();
                pass1= myaes.encrypt(pass1,secretKey);
                repass1=myaes.encrypt(repass1,secretKey);

                if(email1.equals("")||pass1.equals("")||fullname1.equals("")||repass1.equals(""))
                    Toast.makeText(Signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass1.equals(repass1)){
                        Boolean checkemail = DB.checkemail(email1);
                        if(checkemail == false){
                            Boolean insert = DB.insertData(email1,fullname1,pass1);
                            if(insert == true){
                                Toast.makeText(Signup.this, "Registered sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(Signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Signup.this, "User Already exists please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Signup.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this, SignIn.class);
                startActivity(intent);

            }
        });




    }
}