package com.example.final_project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class About extends AppCompatActivity {
    Button b;
    public static String flag = "flag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        b = findViewById(R.id.kembali);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(About.this, MainActivity.class);
                Bundle b = new Bundle();
                main.putExtra(flag, "Velvetaco");
                startActivity(main);
            }
        });
    }

}
