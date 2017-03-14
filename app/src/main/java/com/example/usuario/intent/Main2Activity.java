package com.example.usuario.intent;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            SharedPreferences sp = getSharedPreferences("Historial", Context.MODE_PRIVATE);
            //mensaje_leido = sp.getString("mensaje2", mensaje_leido);

            String mensaje = String.valueOf(sp.getAll());
            Log.d("mensaje", "mesaje recibido"+mensaje);


            String[] mensajes = null;

            mensajes = mensaje.substring(1,mensaje.length()-1).split(",");//utilizar substring y split xa crear array de string

            //Log.d("mensaje", "mesajes contenido "+mensajes[0]+" "+mensajes[1]+" "+mensajes[2]+" "+mensajes[3]);
            lv = (ListView) findViewById(R.id.idListWiew);
            //  ArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects)
            ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1/*R.layout.fila*/, mensajes);



            lv.setAdapter(adapter);
            /*lv.setOnClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick (AdapterView<?> adapterView, View view, int i, long l){
                    Toast.makeText(getApplicationContext(),"mensaje"+i,Toast.LENGTH_SHORT).show();
                }
            });*/

        }catch (Throwable e){
            Log.e("mensaje","error",e);
        }



    }
}
