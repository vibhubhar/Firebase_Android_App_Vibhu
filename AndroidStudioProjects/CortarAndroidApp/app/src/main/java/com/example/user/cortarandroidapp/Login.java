package com.example.user.cortarandroidapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;


public class Login extends AppCompatActivity {
    DatabaseHelper db;

    EditText e1,e2,e3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registraton_form);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pass);
        e3=(EditText)findViewById(R.id.cpass);
        b1=(Button)findViewById(R.id.register);
        db=new DatabaseHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                alertDialog.setTitle("hi");
                alertDialog.setMessage("this is my app");
                alertDialog.show();
               alertDialog.show();  //<-- See This!

                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty!",Toast.LENGTH_LONG).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean chkemail= db.Chkemail(s1);
                        if(chkemail== true){
                            Boolean insert= db.Insert(s1,s2);
                            if(insert== true){
                                Toast.makeText(getApplicationContext(),"Registered successfully!",Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email already exists!", Toast.LENGTH_LONG).show();

                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password don't match!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



    }
}
