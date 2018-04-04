package com.example.oaasa.oaasatechnologys;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class Trainings extends AppCompatActivity {
 ViewPagerAdapter viewPagerAdapter;
 TabLayout tabLayout;
 ViewPager viewPager;
 Toolbar toolbar;
 private int tabheight=8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainings);
        toolbar=(Toolbar)findViewById(R.id.toolbar1);
        toolbar.setTitle("Trainings");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        viewPager=(ViewPager)findViewById(R.id.view_pager1);
        tabLayout=(TabLayout)findViewById(R.id.tab_layout1);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Advanced_IOT(),"Advanced IOT");
        viewPagerAdapter.addFragments(new AdvancedItWorkshop(),"Advance IT Workshop");
        viewPagerAdapter.addFragments(new Automation_Robotics(),"Automation & Robotics");
        viewPagerAdapter.addFragments(new Cyber_Security(),"Cyber Security");
        viewPagerAdapter.addFragments(new Design_Engineering(),"Design Engineering");
        viewPagerAdapter.addFragments(new Design_Industrial(),"Design-Industrial");
        viewPagerAdapter.addFragments(new Embadded_System(),"Embadded System-Microcontroller Based");
        viewPagerAdapter.addFragments(new Embadded_System_Software(),"Embadded Systems-Software Based");
        viewPagerAdapter.addFragments(new ERP_Sap_Trainings(),"ERP SAP Training");
        viewPagerAdapter.addFragments(new Hardware_Networking(),"Hardware & Networking");
        viewPagerAdapter.addFragments(new Java_Training(),"Java Training");
        viewPagerAdapter.addFragments(new Professional_IT_Training(),"Professional IT Training");
        viewPagerAdapter.addFragments(new web_android_technology(),"Web & Android Technology");


        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffffff"));
        tabLayout.setSelectedTabIndicatorHeight(tabheight);
        tabLayout.setupWithViewPager(viewPager);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.training_service,menu);
        Drawable drawable=menu.getItem(0).getIcon();
        drawable.mutate();
        drawable.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        int id=item.getItemId();
        switch (id){
            case R.id.trainging_service:
                Toast.makeText(getApplicationContext(),"Click On Service",Toast.LENGTH_SHORT).show();
                break;

            case R.id.enquiry:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
