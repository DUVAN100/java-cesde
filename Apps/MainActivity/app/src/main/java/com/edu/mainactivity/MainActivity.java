package com.edu.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import com.edu.mainactivity.R;
import com.edu.mainactivity.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Activity register;
    private ActivityMainBinding mainBinding;
    private DBhelper DBhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        DBhelper = new DBhelper(this);
        mainBinding.BtnlogIn.setOnClickListener(this);
        mainBinding.BtnSingUP.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.BtnlogIn:
                String temail = mainBinding.EtEmail.getText().toString();
                String tpassword = mainBinding.EtPasword.getText().toString();
                SQLiteDatabase db = DBhelper.getWritableDatabase();
                String query = String.format("SELECT * FROM users WHERE email='%s' and password='%s'", temail, tpassword);
                Cursor cursor = db.rawQuery(query, null);
                // verifica si el usuario exi,ste
                int count = cursor.getCount();
                if ( count >0) {
                    Intent LooKusers = new Intent(this, LookUsers.class);
                    startActivity(LooKusers);
                } else {
                    Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.BtnSingUP:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.BtnListuser:
                Intent List = new Intent(this, ListUsers.class);
                startActivity(List);
                break;
        }
    }
}


