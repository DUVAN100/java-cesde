package com.edu.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.edu.mainactivity.databinding.ActivityLooksersBinding;

import java.util.ArrayList;

public class LookUsers extends AppCompatActivity implements View.OnClickListener {
    private ActivityLooksersBinding lookUsersBinding;
    private  DBhelper dbhelper;
    private UserEntity user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lookUsersBinding = ActivityLooksersBinding.inflate(getLayoutInflater());
        View views = lookUsersBinding.getRoot();
        setContentView(views);
        dbhelper = new DBhelper (this);
        lookUsersBinding.search.setOnClickListener(this);
    }
    @Override
    public void onClick(View views) {
        switch (views.getId()) {
            case R.id.search:
                String Semail = lookUsersBinding.emailtosearch.getText().toString();
                SQLiteDatabase db = dbhelper.getWritableDatabase();
                String query = String.format("SELECT * FROM users WHERE email='%s'", Semail);
                Cursor cursor = db.rawQuery(query, null);
                    if(cursor.getCount() > 0) {
                        cursor.moveToNext();
                            int indexIdRow = Integer.parseInt(cursor.getString(0));
                            int indexNameRow = cursor.getColumnIndex("name");
                            int indexEmailRow = cursor.getColumnIndex("email");
                            int indexIdentificationRow = cursor.getColumnIndex("identification");
                            int indexPasswordRow = cursor.getColumnIndex("password");
                            String name = cursor.getString(indexNameRow).toString();
                            String email = cursor.getString(indexEmailRow).toString();
                            long identification = Long.parseLong(cursor.getString(indexIdentificationRow));
                            String password = cursor.getString(indexPasswordRow).toString();
                            user = new UserEntity();
                            user.setEmail(email);
                            user.setName(name);
                            user.setIdentification(identification);
                            user.setPassword(password);
                        }
                        if(user.getEmail() != null) {
                            showUser();
                        }else{
                        Toast.makeText(this, "usuario no existente", Toast.LENGTH_SHORT).show();
                        }
                    }
    }

    private void showUser(){
        try {
            lookUsersBinding.txtnameuser.setText(user.getName());
            lookUsersBinding.txtidentificationuser.setText( user.getIdentificationString());
            lookUsersBinding.txtemail.setText(user.getEmail());
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}