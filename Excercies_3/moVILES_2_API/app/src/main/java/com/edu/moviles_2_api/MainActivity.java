package com.edu.moviles_2_api;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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


    public void Factura(View view) {
        Intent INtFactura = new Intent(this, FacturaActivity.class);
        startActivity(INtFactura);
    }
}