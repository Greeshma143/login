package com.arun.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Wel extends AppCompatActivity {
    TextView t;
    String getValue;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);

        SharedPreferences sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        String s=sharedPreferences.getString("namee","null");
        t = (TextView) findViewById(R.id.tv);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("Login",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();

                Intent in1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in1);
            }
        });
        Intent intent=getIntent();
        getValue=intent.getStringExtra("Name");
        t.setText(getValue);

        Toast.makeText(getApplicationContext(),"Value"+getValue,Toast.LENGTH_SHORT).show();


    }

}
