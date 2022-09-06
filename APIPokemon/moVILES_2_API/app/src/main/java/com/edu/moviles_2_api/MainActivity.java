package com.edu.moviles_2_api;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Vehiculo(View view){
        Intent intvehiculo=new Intent(this,VehiculoActivity.class);
        startActivity(intvehiculo);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Factura(View view) {
        Intent INtFactura = null;
            INtFactura = new Intent(this, FacturaActivity.class);
        startActivity(INtFactura);
    }
}