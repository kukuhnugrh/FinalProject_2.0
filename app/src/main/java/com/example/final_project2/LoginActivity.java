package com.example.final_project2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private TextView signup;
    private EditText usernameEditText;
    private EditText passwordEditText;
    Validation valid = new Validation();
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static String flag = "flag";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String uname = String.valueOf(usernameEditText.getText());
                String password = String.valueOf(passwordEditText.getText());
                if(valid.isValid(uname, password)){
                    setContentView(R.layout.main_activity);
                    Intent home = new Intent(LoginActivity.this, MainActivity.class);
                    Bundle b = new Bundle();
                    home.putExtra(flag, "Velvetaco");
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Name, uname);
                    editor.commit();
                    System.out.println("available LOGIN Email : "+sharedpreferences.getString(Name, new String()));
                    startActivity(home);
                }
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
    }
}
