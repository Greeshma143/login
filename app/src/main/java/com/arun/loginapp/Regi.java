package com.arun.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Regi extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    Button button;
    String nam,pho,pla,use,pas,ema,n,p1,p2,u,p3,e;
    Model model;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regi);
        e1=(EditText)findViewById(R.id.id5);
        e2=(EditText)findViewById(R.id.id6);
        e3=(EditText)findViewById(R.id.id7);
        e4=(EditText)findViewById(R.id.id8);
        e5=(EditText)findViewById(R.id.id9);
        e6=(EditText)findViewById(R.id.id10);
        button=(Button) findViewById(R.id.id11);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Login");
        model=new Model();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nam=e1.getText().toString().trim();
                pho=e2.getText().toString().trim();
                pla=e3.getText().toString().trim();
                use=e4.getText().toString().trim();
                pas=e5.getText().toString().trim();
                ema=e6.getText().toString().trim();

                model.setNa(nam);
                model.setPh(pho);
                model.setPl(pla);
                model.setUs(use);
                model.setPa(pas);
                model.setEm(ema);

                n=model.getNa();
                p1=model.getPh();
                p2=model.getPa();
                u=model.getUs();
                p3=model.getPa();
                e=model.getEm();

                databaseReference.push().setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Succes",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });






            }
        });
    }
}
