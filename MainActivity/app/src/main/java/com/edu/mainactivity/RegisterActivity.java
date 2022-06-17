package com.edu.mainactivity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.edu.mainactivity.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding registerBinding;
    private DBhelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = registerBinding.getRoot();
        setContentView(view);
        dbHelper = new DBhelper(this);
    }
    public void registerUser(View view){
        DBhelper dbHelper = new DBhelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues userData = new ContentValues();
        String name = registerBinding.etName.getText().toString();
        String identification = registerBinding.etIdentification.getText().toString();
        String email = registerBinding.etEmail.getText().toString();
        String password = registerBinding.etPassword.getText().toString();
        userData.put("name", name);
        userData.put("identification", identification);
        userData.put("email", email);
        userData.put("password", password);
        long newUser = db.insert("users",null, userData);
        Toast.makeText(this, "usuaio registrado ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}