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


public class FacturaActivity extends AppCompatActivity {
    EditText  fechaFactura, placaehiculo, marcaVehiculo, modeloVehiculo, valorvehiculo, numeroFactura;
    CheckBox activoVehiculo;
    CheckBox activoFactura;
    String  placa, marca, modelo, valor, fecha;
    int Switch;
    long respuesta;
    String nfactura;
    ClsOpenHelper admin = new ClsOpenHelper(this, "concesionari.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        activoFactura = findViewById(R.id.checkFactura);
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
    //metodo para buscar la factura
    public void BusarFactura(View view) {
        nfactura = numeroFactura.getText().toString();
        if (nfactura.isEmpty()) {
            Toast.makeText(this, "El codigo de la factura es requerida", Toast.LENGTH_SHORT).show();
            placaehiculo.requestFocus();
        } {
            SQLiteDatabase db = admin.getReadableDatabase();
            Cursor fila = db.rawQuery("SELECT * FROM TblFactura WHERE cod_factura = '" + nfactura + "'", null);
            if (fila.moveToNext()) {
                numeroFactura.setText(fila.getString(0));
                fechaFactura.setText(fila.getString(1));
                placaehiculo.setText(fila.getString(2));
                if (fila.getString(3).equals("si")) {
                    activoFactura.setChecked(true);
                } else {
                    activoFactura.setChecked(false);
                }
            } else {
                Toast.makeText(this, "Esta fatura no existe", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //metodo para guardar la factua
    public void GuardarFactura(View view) {
        placa = placaehiculo.getText().toString();
        nfactura = numeroFactura.getText().toString();
        fecha = fechaFactura.getText().toString();
        if( nfactura.isEmpty() || fecha.isEmpty()) {
            Toast.makeText(this, "DIgite los campos requeridos", Toast.LENGTH_SHORT).show();
            placaehiculo.requestFocus();
        } else {
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            ContentValues registroV = new ContentValues();
            if (Switch==1) {
                registro.put("cod_factura", String.valueOf(numeroFactura));
                registro.put("fecha", fecha);
                registro.put("placa", placa);
                respuesta = db.insert("TblFactura", null, registro);
            } else {
                Toast.makeText(this, "Esta vehiculo ya se vendio", Toast.LENGTH_SHORT).show();
                Switch=0;
            }
            if (respuesta > 0) {
                Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();
                registroV.put("activo", "no");
                db.update("TblVehiculo", registroV, "placa='" + placa + "'", null);
                limpiarCampos();
            } else {
                Toast.makeText(this, "No es posible realizar esta accion", Toast.LENGTH_SHORT).show();
            }
            db.close();
        }
    }

    //metodo consultar para consultar el vehiculo
    public void ConsultarVehiculo(View view) {
        placa = placaehiculo.getText().toString();
        if (placa.isEmpty()) {
            Toast.makeText(this, "Digite la placa el vehiculo", Toast.LENGTH_SHORT).show();
            placaehiculo.requestFocus();
        }else{
            SQLiteDatabase db = admin.getReadableDatabase();
            Cursor fila = db.rawQuery("SELECT * FROM TblVehiculo WHERE placa = '" + placa + "' AND activo = 'si'", null);
            if (fila.moveToNext()) {
                Switch = 1;
                placaehiculo.setText("placa: "+ fila.getString(0));
                marcaVehiculo.setText("Marca: "+fila.getString(1));
                modeloVehiculo.setText("modelo: "+fila.getString(2));
                valorvehiculo.setText("valor: "+fila.getString(3));
            } else {
                placaehiculo.setText("");
                Toast.makeText(this, "Vehiculo no registrado", Toast.LENGTH_SHORT).show();
                marcaVehiculo.setText("");
                modeloVehiculo.setText("");
                valorvehiculo.setText("");
            }
        }
    }
    //meodo para limpiar campos
     public void limpiarCampos(){
         placaehiculo.setText("");
         marcaVehiculo.setText("");
         modeloVehiculo.setText("");
         valorvehiculo.setText("");
         activoVehiculo.setChecked(false);
         placaehiculo.requestFocus();
         Switch=0;
     }
}




