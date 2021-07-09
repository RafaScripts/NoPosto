package com.rafascripts.noposto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Page3 extends AppCompatActivity {

    Button buttonInicio;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        TextView textResult = findViewById(R.id.textResult);
        TextView textAutonomia = findViewById(R.id.textAutonomia);

        //Recuperando Dados
        Bundle dados2 = getIntent().getExtras();
        String exibir = dados2.getString("resultado");
        Double exibir2 = dados2.getDouble("auto");

        textResult.setText(exibir);
        textAutonomia.setText(String.valueOf(exibir2));


        buttonInicio = findViewById(R.id.button5);
        buttonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent5);
                finish();
            }
        });
    }
}