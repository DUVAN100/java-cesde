package com.edu.moviles_2_api;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;


import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RequiresApi(api = Build.VERSION_CODES.N)
public class FacturaActivity extends AppCompatActivity {
    EditText  fechaFactura, placaehiculo, marcaVehiculo, modeloVehiculo, valorvehiculo, numeroFactura;
    CheckBox activoVehiculo;
    String feFactura,placav,nFactura,marca, modelo,valor ;
    long respuesta;
    String nfactura;
    ClsOpenHelper admin = new ClsOpenHelper(this, "concesionari.db", null, 1);
    String pattern = "MM-dd-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        feFactura =  simpleDateFormat.format(Calendar.getInstance().getTime());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        numeroFactura =  findViewById(R.id.numeroFactura);
        fechaFactura =  findViewById(R.id.fechaFactura);
        placaehiculo =  findViewById(R.id.placaVehiculo);
        marcaVehiculo =  findViewById(R.id.marcaVehiculo);
        modeloVehiculo =  findViewById(R.id.modeloVehiculo);
        valorvehiculo =  findViewById(R.id.valorVehiculo);
    }
    public void Regresar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void ConsultarVehculo(View view) {

    }
    public void Guardar() {
        nFactura = numeroFactura.getText().toString();
        feFactura = fechaFactura.getText().toString();
        placav = placaehiculo.getText().toString();
        modelo = modeloVehiculo.getText().toString();
        valor = valorvehiculo.getText().toString();
        if (nfactura.isEmpty() || feFactura.isEmpty() || placav.isEmpty() || modelo.isEmpty() || valor.isEmpty()) {
            Toast.makeText(this, "Campos incompletos (placa, valor)", Toast.LENGTH_SHORT).show();
            placaehiculo.requestFocus();
        }else{
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues Registro = new ContentValues();
            Registro.put("placa", placav);
            Registro.put("fecha", String.valueOf(feFactura));
            Registro.put("valor", Integer.parseInt(valor));
            respuesta = db.insert("TblFactura", null, Registro);
            //respuesta = db.update("TblFactura", Registro, "placa" + placa + " ", null);
        }
    }
    public void ConsultarVehiculo(View view){

    }
}




