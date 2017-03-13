package com.example.usuario.intent;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SharedPreferences sp = getSharedPreferences("Historial", Context.MODE_PRIVATE);
        String mensaje = String.valueOf(sp.getAll());

        TextView textView = (TextView)findViewById(R.id.textView2);

        textView.setText(mensaje);
    }
}
