package com.edu.cesde.Refgistrar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import com.edu.cesde.R;
import com.edu.cesde.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Activity register;
    private ActivityMainBinding mainBinding;
    private DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
        mainBinding.BtnlogIn.setOnClickListener(this);
        mainBinding.BtnSingUP.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.BtnlogIn:
                String temail = mainBinding.EtEmail.getText().toString();
                String tpassword = mainBinding.EtPasword.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String query = String.format("SELECT * FROM users WHERE email='%s' and password='%s'",temail,tpassword);
                Cursor cursor = db.rawQuery(query, null);
                // verifica si el usuario existe
                if(cursor.getCount() > 1){
                    Intent productos = new Intent(this, ProductActivity.class);
                    startActivity(productos);
                }
                else{
                    Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.BtnSingUP:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
        }
    }

}