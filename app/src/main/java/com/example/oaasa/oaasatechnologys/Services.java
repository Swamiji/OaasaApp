package com.example.oaasa.oaasatechnologys;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.oaasa.oaasatechnologys.R.id.view;

public class Services extends AppCompatActivity {
    Spinner spinner;
    EditText text_title,text_requirements,text_url;
    Button submit;
    ArrayAdapter<CharSequence> adapter;
Toolbar toolbar;
ViewPager viewPager;
ViewPagerAdapter viewPagerAdapter;
TabLayout tabLayout;
private int tabheight=8;
    FloatingActionButton Fab_plus,Fab_service;
    Animation Fab_open,Fab_close,Fab_clockwise,Fab_anticlockwise;
    boolean isOpen=false;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Technologys");
        toolbar.setSubtitle("Services");
        toolbar.setSubtitleTextColor(Color.parseColor("#ffffff"));
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new erp_consultancy(),"ERP Consultancy");
        viewPagerAdapter.addFragments(new android_ios(),"ANDROID&IOS");
        viewPagerAdapter.addFragments(new web_development(),"WEB DEVELOPMENT");
        viewPagerAdapter.addFragments(new it_security_policies(),"IT SECURITY POLICIES");
        viewPagerAdapter.addFragments(new sox_compliance(),"SOX Compliance");
        viewPagerAdapter.addFragments(new cyber_crime(),"Cyber Crime Audit");
        viewPagerAdapter.addFragments(new web_hosting(),"Web Hosting Service");
        viewPagerAdapter.addFragments(new server_management(),"Server Management");
        viewPagerAdapter.addFragments(new embaded_system(),"Embaded System");
        viewPagerAdapter.addFragments(new iot_internet(),"IOT(Internet Of Things)");
        viewPagerAdapter.addFragments(new Robotics(),"Robotics");
        viewPagerAdapter.addFragments(new PCB(),"PCB");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffffff"));
        tabLayout.setSelectedTabIndicatorHeight(tabheight);
        tabLayout.setupWithViewPager(viewPager);

        /*********Fab Initialization*****///

        Fab_plus=(FloatingActionButton)findViewById(R.id.fab_plus);
        Fab_service=(FloatingActionButton)findViewById(R.id.fab_service);

        /****** Animation Initialization****////

        Fab_open=(Animation) AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        Fab_close=(Animation)AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        Fab_clockwise=(Animation)AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_clockwise);
        Fab_anticlockwise=(Animation)AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_anticlockwise);

        /**** Get Start Animation***////

        Fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOpen){
                    Fab_service.startAnimation(Fab_close);
                    Fab_plus.startAnimation(Fab_anticlockwise);
                    isOpen=false;
                    Fab_service.setClickable(false);

                }
                else
                {
                    Fab_service.startAnimation(Fab_open);
                    Fab_plus.startAnimation(Fab_clockwise);
                    Fab_service.setClickable(true);
                    isOpen=true;
                }
            }
        });

        Fab_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Services.this);
                View view;
                view=getLayoutInflater().inflate(R.layout.custom_dialog,null,false);
                builder.setView(view);
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
                spinner=(Spinner)view.findViewById(R.id.spinner);
                text_title=(EditText)view.findViewById(R.id.Title_project);
                text_requirements=(EditText)view.findViewById(R.id.requirement);
                text_url=(EditText)view.findViewById(R.id.url_link);
                submit=(Button)view.findViewById(R.id.btnsubmit);
                adapter = ArrayAdapter.createFromResource(Services.this,R.array.select_the_service,R.layout.support_simple_spinner_dropdown_item);
                adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" Selected",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });



            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
