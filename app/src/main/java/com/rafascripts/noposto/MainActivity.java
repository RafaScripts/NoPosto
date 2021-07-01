package com.rafascripts.noposto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public double aAlcool,aGasolina,vAlcool, vGasolina, vAbastecimento;
    public double resultado1, resultado2, ra1, ra2;
    public String textAutonomia, textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.page2);
        setContentView(R.layout.page3);
        setContentView(R.layout.tuturial_p1);


        aAlcool = Double.parseDouble(findViewById(R.id.autonomiaAlcool).toString());
        aGasolina = Double.parseDouble(findViewById(R.id.autonomiaGasolina).toString());
        vAlcool = Double.parseDouble(findViewById(R.id.valorAlcool).toString());
        vGasolina = Double.parseDouble(findViewById(R.id.valorGasolina).toString());
        vAbastecimento = Double.parseDouble(findViewById(R.id.valorAbastecimento).toString());
        textAutonomia = findViewById(R.id.textAutonomia).toString();
        textResult = findViewById(R.id.textResult).toString();
    }

    public void irParaTutorial(View view){
        Intent intent2 = new Intent(getApplicationContext(),Tutorial.class);
        startActivity(intent2);

    }
    public void irParaTela2(View view){
        Intent intent1 = new Intent(getApplicationContext(),Page2.class);
        startActivity(intent1);

    }
    public void irParaTela3() {
        Intent intent4 = new Intent(getApplication(), Page3.class);
        startActivity(intent4);

    }
    public void calcular(View view) {
        irParaTela3();
        calculara();
        resultado1 = (vAbastecimento / vAlcool) * aAlcool;
        resultado2 = (vAbastecimento / vGasolina) * aGasolina;
        if (resultado1 > resultado2) {
            textResult = "Alcool";
        } else {
            textResult = "Gasolina";
        }
    }

    public void calculara(){
        ra1 = (vAbastecimento / vAlcool) * aAlcool;
        ra2 = (vAbastecimento / vGasolina) * aGasolina;

        if(ra1 > ra2){
            textAutonomia = String.valueOf(ra1);
        }else{
            textAutonomia = String.valueOf(ra2);
        }
    }
}

