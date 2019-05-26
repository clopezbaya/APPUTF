package com.example.crizzz.mitren;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InicioMiTren extends AppCompatActivity {



    private static int tiempoSplash = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_mi_tren);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nuevo = new Intent(InicioMiTren.this,MainActivity.class);
                startActivity(nuevo);
                finish();
            }
        },tiempoSplash);
    }
}
