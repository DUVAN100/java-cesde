package com.edu.moviles_2_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class VehiculoActivity extends AppCompatActivity {

    EditText eTplaca, etMarca, etModel, etValor;
    CheckBox checkBoxActivo;
    ClsOpenHelper admin = new ClsOpenHelper(this, "concesionari.db", null, 1);
    long respuesta;
    String placa, marca, modelo, valor;
    int  swith=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo);
        getSupportActionBar().hide();
        eTplaca = findViewById(R.id.Placa);
        etMarca = findViewById(R.id.etMarca);
        etModel = findViewById(R.id.etModelo);
        etValor = findViewById(R.id.etValor);
        checkBoxActivo = findViewById(R.id.checkBoxActivo);
    }

    public void guardar(View view) {
        placa = eTplaca.getText().toString();
        marca = etMarca.getText().toString();
        modelo = etModel.getText().toString();
        valor = etValor.getText().toString();
        if (placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || valor.isEmpty()) {
            Toast.makeText(this, "Campos incompletos", Toast.LENGTH_SHORT).show();
            eTplaca.requestFocus();
        } else {
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues Registro = new ContentValues();
            Registro.put("placa", placa);
            Registro.put("marca", marca);
            Registro.put("modelo", modelo);
            Registro.put("valor", Integer.parseInt(valor));
            swith=1;
            if (swith == 1){
                respuesta = db.insert("TblVehiculo", null, Registro);
            }else{
                respuesta = db.update("TblVehiculo", Registro, "placa"+ placa+ " ", null);
            }
            if (respuesta > 0) {
                Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();
                LImpiar_campos();
            } else
                Toast.makeText(this, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }
    public void Consultar(View view){
        placa = eTplaca.getText().toString();
        if (placa.isEmpty()){
            Toast.makeText(this, "La placa es requerida", Toast.LENGTH_SHORT).show();
            eTplaca.requestFocus();
        }
        else{
            SQLiteDatabase db = admin.getReadableDatabase();
            Cursor fila = db.rawQuery("select * from TblVehiculo where placa='" + placa + "'",null);
            if (fila.moveToNext()){
                etMarca.setText(fila.getString(1));
                etModel.setText(fila.getString(2));
                etValor.setText(fila.getString(3));
                if (fila.getString(4).equals("si")){
                    checkBoxActivo.setChecked(true);
                }else{
                    checkBoxActivo.setChecked(false);
                }
            }
            else
                Toast.makeText(this, "Vehiculo no registrado", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }
    public void cancelar(View view){
        LImpiar_campos();
    }
    public void LImpiar_campos() {
        eTplaca.setText("");
        etMarca.setText("");
        etModel.setText("");
        etValor.setText("");
        checkBoxActivo.setChecked(false);
        eTplaca.requestFocus();
        swith=0;
    }
    public  void  Regresar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void anular(View view){
        if (swith == 0){
            Toast.makeText(this, "Primero debes consultarlo", Toast.LENGTH_SHORT).show();
            eTplaca.requestFocus();
        }else{
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("activo", "no");
            respuesta = db.update("TblVehiculo", registro, "placa='"+placa+"'", null);
            if (respuesta > 0){
                Toast.makeText(this, "Registro anulado", Toast.LENGTH_SHORT).show();
                LImpiar_campos();
            }else{
                Toast.makeText(this, "Error anulando el regitro ", Toast.LENGTH_SHORT).show();
                db.close();
            }
        }

    }
}

