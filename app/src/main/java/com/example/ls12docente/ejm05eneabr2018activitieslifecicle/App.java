package com.example.ls12docente.ejm05eneabr2018activitieslifecicle;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class App extends AppCompatActivity {
    private static final int REQUEST_CAMERA = 0;
    private static final int REQUEST_CAMERA_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        App.this.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void segunda(View view) {
        Intent intento = null;
        intento = new Intent(App.this, SecondAct.class);
        startActivity(intento);
    }

    public void tercera(View view) {
        Intent intento = null;
        intento = new Intent(App.this, dataAct.class);
        intento.putExtra("name", "Ricardo Alderete");
        startActivityForResult(intento, 10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            Bundle MBuddle = data.getExtras();
            String MMessage = MBuddle.getString("result");
            Toast.makeText(this, "" + MBuddle, Toast.LENGTH_SHORT).show();
        }
    }

    private void tomolafoto() {
        Intent intento = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intento);
        Toast.makeText(this, "Gracias", Toast.LENGTH_SHORT).show();
    }

    public void camara(View view) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            tomolafoto();
            Log.e("Permiso", "camara:Menor que android 6 ");
        } else {
            int permiso = ContextCompat.checkSelfPermission(App.this, Manifest.permission.CAMERA);
            if (permiso != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 001);
                //  tomolafoto();
                Log.e("Permiso", "camara: Mayor que android 6");
            } else {
                tomolafoto();
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        switch (requestCode) {
            case REQUEST_CAMERA_PERMISSION:
                final int numOfRequest = grantResults.length;
                final boolean isGranted = numOfRequest == 1
                        && PackageManager.PERMISSION_GRANTED == grantResults[numOfRequest - 1];
                Log.v("error", "Camera Permission callback on onRequestPermissionsResult");
                if (isGranted) {
                    tomolafoto();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}


















