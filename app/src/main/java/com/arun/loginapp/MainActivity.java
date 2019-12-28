package com.arun.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        String value=sharedPreferences.getString("Email",null);

        if(value!=null)
        {
            Intent ob3=new Intent(getApplicationContext(),Wel.class);
            startActivity(ob3);
        }




        e1=(EditText) findViewById(R.id.id1);
        e2=(EditText) findViewById(R.id.id2);
        b1=(Button) findViewById(R.id.id3);
        b2=(Button) findViewById(R.id.id4);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Login");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=e1.getText().toString().trim();
                final String password=e2.getText().toString().trim();

                final Query query=databaseReference.orderByChild("em").equalTo(Email);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        for (DataSnapshot s:dataSnapshot.getChildren())
                        {
                            Model model=s.getValue(Model.class);
                            String seml=model.em;
                            String spa=model.pa;
                            String nam=model.na;

                            Toast.makeText(getApplicationContext(),"Succes"+nam,Toast.LENGTH_SHORT).show();

                            if(spa.equals(password))
                            {

                                SharedPreferences.Editor editor=getSharedPreferences("Login",MODE_PRIVATE).edit();
                                editor.putString("Email",seml);
                                editor.commit();
                                Intent ob=new Intent(getApplicationContext(),Wel.class);
                                ob.putExtra("Name",nam);
                                startActivity(ob);


                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob=new Intent(getApplicationContext(),Regi.class);
                startActivity(ob);
            }
        });
    }
}
