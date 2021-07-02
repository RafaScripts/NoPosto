package com.rafascripts.noposto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Tutorial extends AppCompatActivity {

    Button buttonInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuturial_p1);

        buttonInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentT = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intentT);
            }
        });



    }


}