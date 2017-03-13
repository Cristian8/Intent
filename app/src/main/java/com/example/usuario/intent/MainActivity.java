package com.example.usuario.intent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int contador = 0;
    //String mensaje = String.valueOf(contador);


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

                SharedPreferences sp = getSharedPreferences("Historial", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                contador++;
                String mensajes = sp.getString("mensaje"+contador, mensaje);
                ed.putString("mensaje"+contador, mensaje);
                ed.commit();
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       /* menu.add(Menu.NONE, 1, 1, "Salir");
        menu.add(Menu.NONE, 2, 2, "Femxa Web");*/
        getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("Mensaje", "ITEM ID"+item.getItemId());


       /* if (item.getItemId()==1){
            Log.d("Mensaje", "El usuario le ha dado a salir");
            this.finish();
        }else{
            Log.d("Mensaje", "El usuario va ha la segunda actividad");
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        }*/
        switch (item.getItemId()){
            case R.id.boton_salir:
                finish();
                break;
            case R.id.boton_historial:
               //Intent i = new Intent(Intent.ACTION_VIEW);
                //i.setData(Uri.parse("http://femxa-ebtm.rhcloud.com"));
                //startActivity(i);
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
