
package com.moviles1.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moviles1.loginui.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mainBinding;
    private DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
        mainBinding.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                String email = mainBinding.etEmail.getText().toString();
                String password = mainBinding.etPassword.getText().toString();
                Toast.makeText(this, email + password, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                String temail = mainBinding.etEmail.getText().toString();
                String tpassword = mainBinding.etPassword.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String query = String.format("SELECT * FROM users WHERE email='%s' and password='%s'",temail,tpassword);
                Cursor cursor = db.rawQuery(query, null);
                // verifica si el usuario existe
                if(cursor.getCount() > 0){
                    Toast.makeText(this, "El usuario existe", Toast.LENGTH_SHORT).show();
                    cursor.moveToNext();
                    String emailResult = cursor.getString(2);
                    int id = cursor.getInt(3);
                    mainBinding.tvLoginName.setText(emailResult);
                    mainBinding.tvLoginId.setText(String.valueOf(id));
                }
                else{
                    Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}