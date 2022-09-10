package com.edu.examen0909;

import androidx.activity.result.contract.ActivityResultContracts;
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

public class Viajes extends AppCompatActivity {

    EditText Cod_viaje, CiudadDestino, CantidadPersonas, ValorPersona;
    CheckBox ViajeActivo;
    String codigoViaje,ciudadDestino,cantidadPersonas,valorPersona;
    long respuesta;
     int swith;
    ClsOpenHelper admin = new ClsOpenHelper(this, "concesionar2.db", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajes);
        Cod_viaje = findViewById(R.id.Cod_viaje);
        CiudadDestino = findViewById(R.id.CiudadDestino);
        CantidadPersonas = findViewById(R.id.CantidadPersonas);
        ValorPersona = findViewById(R.id.ValorPersona);
        ViajeActivo = findViewById(R.id.ViajeActivo);
    }
    public void Regresar(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //CReo el metodo guardar Viaje
    public void GuardarViaje(View view) {
        codigoViaje = Cod_viaje.getText().toString();
        ciudadDestino = CiudadDestino.getText().toString();
        cantidadPersonas= CantidadPersonas.getText().toString();
        valorPersona = ValorPersona.getText().toString();
        if (codigoViaje.isEmpty() || ciudadDestino.isEmpty() || cantidadPersonas.isEmpty() || valorPersona.isEmpty()) {
            Toast.makeText(this, "Campos incompletos", Toast.LENGTH_SHORT).show();
            Cod_viaje.requestFocus();
        } else {
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues Registro = new ContentValues();
            Registro.put("Cod_VIaje", codigoViaje);
            Registro.put("Ciudad", ciudadDestino);
            Registro.put("Cantidad", cantidadPersonas);
            Registro.put("Valor", valorPersona);
            swith=1;
            if(swith == 1){
                respuesta = db.insert("TblViajes", null, Registro);
            }else {
                respuesta = db.update("TblViajes", Registro, "Cod_VIaje"+ codigoViaje+ " ", null);
            }

            if ( respuesta > 0 ) {
                Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();
                LImpiar_campos();
            } else
                Toast.makeText(this, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }
    public void ConsultarViaje(View view){
        codigoViaje = Cod_viaje.getText().toString();
        if (codigoViaje.isEmpty()){
            Toast.makeText(this, "La placa es requerida", Toast.LENGTH_SHORT).show();
            Cod_viaje.requestFocus();
        }
        else{
            SQLiteDatabase db = admin.getReadableDatabase();
            Cursor fila = db.rawQuery("select * from TblViajes where Cod_VIaje='" + codigoViaje + "'",null);
            if (fila.moveToNext()){
                Cod_viaje.setText(fila.getString(0));
                CiudadDestino.setText(fila.getString(1));
                CantidadPersonas.setText(fila.getString(2));
                ValorPersona.setText(fila.getString(3));
                if (fila.getString(4).equals("si")){
                    ViajeActivo.setChecked(true);
                }else{
                    ViajeActivo.setChecked(false);
                }
            }
            else
                Toast.makeText(this, "Vehiculo no registrado", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }
    public void Anular(View view){
        if (respuesta > 0){
            Toast.makeText(this, "Primero debes consultarlo", Toast.LENGTH_SHORT).show();
            Cod_viaje.requestFocus();
        }else{
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("activo", "no");
            respuesta = db.update("TblViajes", registro, "Cod_VIaje='"+codigoViaje+"'", null);
            if (respuesta > 0){
                Toast.makeText(this, "Registro anulado", Toast.LENGTH_SHORT).show();
                LImpiar_campos();
            }else{
                Toast.makeText(this, "Error anulando el regitro ", Toast.LENGTH_SHORT).show();
                db.close();
            }
        }

    }


    private void LImpiar_campos() {
        Cod_viaje.setText("");
        CiudadDestino.setText("");
        CantidadPersonas.setText("");
        ValorPersona.setText("");
    }

}