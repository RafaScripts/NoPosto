package com.rafascripts.noposto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    protected EditText autonomiaAlcool, autonomiaGasolina;
    protected TextView textTuto;
    private  AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autonomiaAlcool = findViewById(R.id.autonomiaAlcool);
        autonomiaGasolina = findViewById(R.id.autonomiaGasolina);
        textTuto = findViewById(R.id.textTuto);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
    public void irParaTutorial(View t1){
        Intent intent6 = new Intent(getApplicationContext(), Tutorial.class);
        startActivity(intent6);
    }

    public void irParaTela2(View view) {

        //Pegando os Campos Digitados
        String autoAlcool = autonomiaAlcool.getText().toString();
        String autoGasolina = autonomiaGasolina.getText().toString();

        //Abrindo validação ou tela2
       Boolean camposValidados = validarCampos1(autoAlcool, autoGasolina);
       if (camposValidados){
           Intent intent1 = new Intent(getApplicationContext(), Page2.class);
           intent1.putExtra("aAlcool", autoAlcool);
           intent1.putExtra("aGasolina", autoGasolina);
           startActivity(intent1);


       }else{
           AlertDialog.Builder dialog = new AlertDialog.Builder(this);
           dialog.setTitle("Preencha os Campos");
           dialog.setMessage("Preencha os campos corretamente!");
            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            dialog.create();
            dialog.show();
       }
    }

        //Validando Campos
    public Boolean validarCampos1(String aAlcool, String aGasolina){
        boolean camposValidados = true;
        if (aAlcool == null || aAlcool.equals("")){
            camposValidados = false;
        }else if (aGasolina == null || aGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;

    }


}

