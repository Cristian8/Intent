package com.example.usuario.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = findViewById(R.id.btnenviar);//castin
        Button boton = (Button) v;
        /*Intent intent = new Intent(this, Main2Activity.class);//intent explicito xq digo dnd quiero ir
           startActivity(intent);*/

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentenviar = new Intent();
                intentenviar.setAction(Intent.ACTION_SEND);
                View vista = findViewById(R.id.miedittext);
                EditText editText = (EditText)findViewById(R.id.miedittext);
                String mensaje = editText.getText().toString();
                intentenviar.putExtra(Intent.EXTRA_TEXT, mensaje/*"Hola que tal"*/);
                intentenviar.setType("text/plain");
                intentenviar.setPackage("com.whatsapp");//le digo q quiero x whatsapp
                startActivity(intentenviar);
            }
        });



    }
}
