package com.rafascripts.noposto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Page2 extends AppCompatActivity {

    private Button buttonCalcular;
    private EditText valorAlcool, valorGasolina, valorAbastecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        valorAlcool = findViewById(R.id.valorAlcool);
        valorGasolina = findViewById(R.id.valorGasolina);
        valorAbastecimento = findViewById(R.id.valorAbastecimento);
        buttonCalcular = findViewById(R.id.button3);

    }

    public void calcular(View view){
        //Recuperar Valor dos campos
        String precoAlcool = valorAlcool.getText().toString();
        String precoGasolina = valorGasolina.getText().toString();
        String valorAbastecido = valorAbastecimento.getText().toString();

        //Recuperando Autonomia da 1 página
        Bundle dados = getIntent().getExtras();
        String aAlcool = dados.getString("aAlcool");
        String aGasolina = dados.getString("aGasolina");

        //Validando Campos
       Boolean camposValidados = validarCampos2(precoAlcool, precoGasolina, valorAbastecido);
       if (camposValidados){
           Double dvAlcool = Double.parseDouble(precoAlcool);
           Double dvGasolina = Double.parseDouble(precoGasolina);
           Double dAbastecimento = Double.parseDouble(valorAbastecido);
           Double daAlcool = Double.parseDouble(aAlcool);
           Double daGasolina = Double.parseDouble(aGasolina);

            //Fazendo o Calculo:

           Double ra1 = (dAbastecimento/dvAlcool)*daAlcool;
           Double ra2 = (dAbastecimento/dvGasolina)*daGasolina;
           Intent intent2 = new Intent(getApplicationContext(), Page3.class);

           if (ra1 > ra2){
               intent2.putExtra("auto",ra1);
               intent2.putExtra("resultado","Alcool");
               startActivity(intent2);
           }else{
               intent2.putExtra("auto",ra2);
               intent2.putExtra("resultado","Gasolina");
               startActivity(intent2);
           }

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

    public Boolean validarCampos2(String vAlcool, String vGasosa, String vAbastecimento){
        boolean camposValidados = true;
        if (vAlcool == null || vAlcool.equals("")){
            camposValidados = false;
        }else if(vGasosa == null || vGasosa.equals("")){
            camposValidados = false;
        }else if(vAbastecimento == null || vAbastecimento.equals("")){
            camposValidados = false;
        }
        return camposValidados;
    }

}