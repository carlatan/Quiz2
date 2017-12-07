package com.tan.quiz2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_user;
    EditText et_pass;
    Button remember;
    Button login;
    SharedPreferences preferences;
    private SharedPreferences.Editor loginPrefsEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_user = (EditText) findViewById(R.id.et_user);
        et_pass = (EditText) findViewById(R.id.et_pass);
        remember = (Button) findViewById(R.id.btn_rem);
        login = (Button) findViewById(R.id.btn_login);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void rememberMe(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", et_user.getText().toString());
        editor.putString("password", et_pass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
    }

    public void nextActivity(View view) {
        String username = String.valueOf(et_user.getText());
        String password = String.valueOf(et_pass.getText());

        if (username.equals("username") && password.equals("password")) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Error Logging in. Invalid username and password!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}