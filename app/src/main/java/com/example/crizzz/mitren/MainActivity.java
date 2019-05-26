package com.example.crizzz.mitren;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private Boolean mLocationPermissionsGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLocationPermission();
    }

    public void rutas(View view){
        Intent i = new Intent(this,NavigationDrawerMiTren.class);
        i.putExtra("llave","rutas");
        startActivity(i);
    }
    public void destino(View view){
        Intent i = new Intent(this,NavigationDrawerMiTren.class);
        i.putExtra("llave","destinos");
        startActivity(i);
    }
    public void conoceMiTren(View view){
        Intent i = new Intent(this,NavigationDrawerMiTren.class);
        i.putExtra("llave","conoceMiTren");
        Bundle result = new Bundle();
        result.putString("key",mLocationPermissionsGranted.toString());
        startActivity(i);
    }
    public void conoceCochabamba(View view){
        Intent i = new Intent(this,NavigationDrawerMiTren.class);
        i.putExtra("llave","conoceCocha");
        startActivity(i);
    }
    public void horarios(View view){
        Intent i = new Intent(this,NavigationDrawerMiTren.class);
        i.putExtra("llave","horarios");
        startActivity(i);
    }
    public void educacionVial(View view){
        Intent i = new Intent(this,NavigationDrawerMiTren.class);
        i.putExtra("llave","educacionVial");
        startActivity(i);
    }

    private void getLocationPermission(){
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this,
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this,
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;
            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        mLocationPermissionsGranted = false;

        switch(requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionsGranted = false;
                            Log.d(TAG, "onRequestPermissionsResult: permission failed");
                            return;
                        }
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
                    mLocationPermissionsGranted = true;
                }
            }
        }
    }
}
