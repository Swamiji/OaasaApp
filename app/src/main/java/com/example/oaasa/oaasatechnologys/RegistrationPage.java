package com.example.oaasa.oaasatechnologys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class RegistrationPage extends AppCompatActivity {
    Toolbar toolbar;
    TextView textView;
    Button SignUP;
    EditText name, email, password, mobile_no;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        textView = (TextView) findViewById(R.id.SignUp);
        name = (EditText) findViewById(R.id.edit_name);
        email = (EditText) findViewById(R.id.edit_email);
        password = (EditText) findViewById(R.id.edit_newPassword);
        mobile_no = (EditText) findViewById(R.id.edit_Mobile);
        SignUP = (Button) findViewById(R.id.signIn);
        SignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=name.getText().toString();
                String Email=email.getText().toString();
                String Password=password.getText().toString();
                String Mobile_No=mobile_no.getText().toString();
                String method="add_info";
                BackgroundTask_Registration backgroundTask=new BackgroundTask_Registration(RegistrationPage.this);
                backgroundTask.execute(method,Name,Email,Password,Mobile_No);
                finish();
                name.setText(" ");
                email.setText(" ");
                password.setText(" ");
                mobile_no.setText(" ");
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationPage.this, LogIn_Register_Page.class);
                startActivity(intent);
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar3);
        toolbar.setTitle("Registration");
        toolbar.setSubtitle("Fill The Details");
        toolbar.setSubtitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            Drawable backArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
            backArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(backArrow);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public class BackgroundTask_Registration extends AsyncTask<String,Void,String> {
        Context context;

        public BackgroundTask_Registration(Context context) {
            this.context=context;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... params) {
            //String add_Url="http://oaasa.com/oaasaapp/register";
            String add_Url="http://10.0.2.2/webapp/register.php";
            String method=params[0];
            if(method.equals("add_info")){
                String Name=params[1];
                String Email=params[2];
                String Password=params[3];
                String Mobile_No=params[4];
                try {
                    URL url=new URL(add_Url);
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    OutputStream OS=httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(OS,"UTF-8");
                    BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                    String data= URLEncoder.encode("name","UTF-8") + "=" +URLEncoder.encode(Name,"UTF-8")+ "&" +
                            URLEncoder.encode("email","UTF-8") + "=" +URLEncoder.encode(Email,"UTF-8")+ "&" +
                            URLEncoder.encode("password","UTF-8") + "=" +URLEncoder.encode(Password,"UTF-8")+ "&" +
                            URLEncoder.encode("mobile_number","UTF-8") + "=" +URLEncoder.encode(Mobile_No,"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    OS.close();
                    InputStream IS=httpURLConnection.getInputStream();
                    IS.close();

                } catch (MalformedURLException e) {
                } catch (IOException e) {

                }
            }
            return "Registration Successful....";
        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equals("Registration Successful....")){
                Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
            }

        }
    }


}

