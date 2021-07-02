package com.rafascripts.noposto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tutorial extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuturial_p1);



    }

    public void irParaInicio(View view){
        Intent intent3 = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent3);
        finish();
    }


}