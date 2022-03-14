package com.example.helloapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final private String CAT="IG2I";
    EditText editSaisie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(CAT, "onCreate");
        setContentView(R.layout.activity_main);
        Button btnOK = findViewById(R.id.buttonOk);
        editSaisie = findViewById(R.id.saisie);
        // V2 : Ecouteur anonyme
        // V3 : Faire implémenter l'interface onClickListener

        /* ... verbeux
        btnOK.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alerter("Click par écouteur anonyme");
                    }
                }
        );*/
        btnOK.setOnClickListener(this);
        editSaisie.setOnClickListener(this);
    }

    // Click sur Ok
    // V1 : ajouter un attr onClick sur le bouton correspondant
    public void foo(View view) {
        alerter("Bouton cliqué (foo)");
    }

    @Override
    public void onClick(View view) {
        String cible = "";
        String contenu = "";
        // Cette méthode est appelé sur les clicks sur btn et editText
        switch (view.getId()) {
            case R.id.buttonOk:
                cible="btnOk";
                // récupérer champs de saisie
                contenu = editSaisie.getText().toString();
                Bundle data = new Bundle();
                data.putString("nom", contenu);
                // Changement d'activité
                Intent versSecondeActivite;
                versSecondeActivite = new Intent(this, SecondActivity.class);
                versSecondeActivite.putExtras(data);
                startActivity(versSecondeActivite);
                break;
            case R.id.saisie: cible="editSaisie"; break;
        }
        alerter("click par la méthode onClick de la classe d'activité sur "+ cible);
    }


    private void alerter(String s) {
        Log.i(CAT, "Toast : " + s);
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(CAT, "onStart");
        alerter("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(CAT, "onResume");
    }
}