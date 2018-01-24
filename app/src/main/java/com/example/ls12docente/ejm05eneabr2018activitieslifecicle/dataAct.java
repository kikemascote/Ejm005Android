package com.example.ls12docente.ejm05eneabr2018activitieslifecicle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class dataAct extends AppCompatActivity {
    private static int OK = 1;
    private TextView name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataact);
        name = findViewById(R.id.txtName);

        //me voy a traer los datos que me envìo la otra actividad
        Bundle parametros = getIntent().getExtras();
        name.setText(parametros.getString("name").toString());

    }

    private void onresponse() {
        Intent intento = null;
        intento = new Intent();
        intento.putExtra("result", "OK");
        setResult(OK, intento);

    }

    @Override
    public void onBackPressed() {
        onresponse();
        dataAct.this.finish();
        super.onBackPressed();
    }
}
