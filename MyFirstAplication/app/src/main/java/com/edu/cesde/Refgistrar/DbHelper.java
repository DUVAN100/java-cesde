package com.edu.cesde.Refgistrar;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "cesdeshop";
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(
                    "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "name VARCHAR(50), email VARCHAR(50)," +
                            "identification int, password VARCHAR(16))");
            sqLiteDatabase.execSQL(
                    "CREATE TABLE products(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "cod VARHCAR(5)," +
                            "nameP VARCHAR(20), " +
                            "cantidad VARHCAR(5)" +
                            ")"
            );
        }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users" + DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
}
