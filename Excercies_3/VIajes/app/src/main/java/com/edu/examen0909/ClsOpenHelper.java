package com.edu.examen0909;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClsOpenHelper extends SQLiteOpenHelper {
    public ClsOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version ) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table TblViajes(Cod_VIaje text primary key, " +
                    "Ciudad text not null," +
                    " Cantidad text not null, " +
                    "Valor text not null, " +
                    "activo taxt not null default 'si')");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table TblViajes");{
            onCreate(db);
        };
        db.execSQL("drop table TblFactura");{
            onCreate(db);
        };
    }
}
