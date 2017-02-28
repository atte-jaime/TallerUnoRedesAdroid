package com.giraldo.jaime.tallerunoredes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button left;
    Button right;
    Button shoot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left = (Button) findViewById(R.id.leftButton);
        right = (Button) findViewById(R.id.rightButton);
        shoot = (Button) findViewById(R.id.shootButton);

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        shoot.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        String mensaje = null;
        if (v.getId() == left.getId()) {
            mensaje = "left";
            Comunicacion.instancia().enviar(mensaje.getBytes());
            Toast.makeText(getApplicationContext(), "Se envió un comando de LEFT", Toast.LENGTH_LONG).show();
        } else if (v.getId() == right.getId()) {
            mensaje = "right";
            Comunicacion.instancia().enviar(mensaje.getBytes());
            Toast.makeText(getApplicationContext(), "Se envió un comando de RIGHT", Toast.LENGTH_LONG).show();

        } else if (v.getId() == shoot.getId()) {
            mensaje = "shoot";
            Comunicacion.instancia().enviar(mensaje.getBytes());
            Toast.makeText(getApplicationContext(), "Se envió un comando de SHOOT", Toast.LENGTH_LONG).show();

        }
    }


}
