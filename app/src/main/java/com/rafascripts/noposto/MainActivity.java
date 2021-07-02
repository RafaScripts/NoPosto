package com.rafascripts.noposto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    protected EditText autonomiaAlcool, autonomiaGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autonomiaAlcool = findViewById(R.id.autonomiaAlcool);
        autonomiaGasolina = findViewById(R.id.autonomiaGasolina);

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



    public void irParaTutorial(View view){
        Intent intent6 = new Intent(getApplication(), Tutorial.class);
        startActivity(intent6);
    }

}

