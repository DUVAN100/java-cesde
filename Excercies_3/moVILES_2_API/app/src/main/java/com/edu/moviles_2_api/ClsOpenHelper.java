package com.edu.moviles_2_api;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClsOpenHelper extends SQLiteOpenHelper {
    public ClsOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table TblVehiculo(placa text primary key, " +
                    "marca text not null," +
                    " modelo text not null, " +
                    "valor integer not null," +
                    " activo text not null default 'si' )");
            db.execSQL("create table TblFactura(cod_factura text primary key ," +
                    " fecha text not null," +
                    " placa text not null," +
                    "activo text not null default 'si'," +
                    "constraint Pk_factura foreign key (placa) references TblVehiculo(placa) )");
        }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table TblVehiculo");{
            onCreate(db);
        };
        db.execSQL("drop table TblFactura");{
            onCreate(db);
        };
    }
}
