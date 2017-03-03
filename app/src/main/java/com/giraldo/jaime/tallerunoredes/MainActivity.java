package com.giraldo.jaime.tallerunoredes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton left;
    ImageButton right;
    ImageButton shoot;
    ImageButton shoot2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        left = (ImageButton) findViewById(R.id.leftButton);
        right = (ImageButton) findViewById(R.id.rightButton);
        shoot = (ImageButton) findViewById(R.id.shootButton);
        shoot2 = (ImageButton) findViewById(R.id.shootButton2);

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        shoot.setOnClickListener(this);
        shoot2.setOnClickListener(this);
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

        } else if ((v.getId() == shoot.getId()) || (v.getId() == shoot2.getId())) {
            mensaje = "shoot";
            Comunicacion.instancia().enviar(mensaje.getBytes());
            Toast.makeText(getApplicationContext(), "Se envió un comando de SHOOT", Toast.LENGTH_LONG).show();

        }
    }


}
