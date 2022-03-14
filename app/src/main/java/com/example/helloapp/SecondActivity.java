package com.example.helloapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private final String CAT = "IG2I";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle data = this.getIntent().getExtras();
        alerter("Contenu reçu : " + data.getString("nom"));
    }

    private void alerter(String s) {
        Log.i(CAT, "Toast : " + s);
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
