package com.edu.proyectconsecionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo);
        getSupportActionBar().hide();
        eTplaca = findViewById(R.id.eTplaca);
        etMarca = findViewById(R.id.eTmarca);
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
            Registro.put("model", modelo);
            Registro.put("valor", Integer.parseInt(valor));
            respuesta = db.insert("lblVehiculo", null, Registro);
            if (respuesta > 0) {
                Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();
                LImpiar_campos();
            } else
                Toast.makeText(this, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }
    public void Consultar(View view){
        placa= eTplaca.getText().toString();
        if (placa.isEmpty()){
            Toast.makeText(this, "La placa es requerida", Toast.LENGTH_SHORT).show();
            eTplaca.requestFocus();
        }
        else{
            SQLiteDatabase db=admin.getReadableDatabase();
            Cursor fila=db.rawQuery("select * from TblVehiculo where placa='" + placa + "'",null);
            if (fila.moveToNext()){

            }
            else
                Toast.makeText(this, "Vehiculo no registrado", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }
    public void LImpiar_campos() {
        eTplaca.setText("");
        etMarca.setText("");
        etModel.setText("");
        etValor.setText("");
        checkBoxActivo.setChecked(false);
        eTplaca.requestFocus();
    }
}