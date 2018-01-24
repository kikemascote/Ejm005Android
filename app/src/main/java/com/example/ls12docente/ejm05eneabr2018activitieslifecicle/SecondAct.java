package com.example.ls12docente.ejm05eneabr2018activitieslifecicle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SecondAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "Terminando Actividad ", Toast.LENGTH_SHORT).show();
        SecondAct.this.finish();

    }
}
