package com.example.oaasa.oaasatechnologys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class LogIn_Register_Page extends AppCompatActivity {
    Toolbar toolbar;
    TextView Register;
    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in__register__page);
        toolbar=(Toolbar)findViewById(R.id.toolbar1);
        toolbar.setTitle("Sign In");
        //toolbar.setTitleTextColor(R.color.white);
        setSupportActionBar(toolbar);
        Register=(TextView)findViewById(R.id.register_text);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogIn_Register_Page.this,RegistrationPage.class);
                startActivity(intent);

            }
        });


    }
}
