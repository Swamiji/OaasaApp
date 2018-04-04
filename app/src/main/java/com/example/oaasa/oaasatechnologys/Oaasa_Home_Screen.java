package com.example.oaasa.oaasatechnologys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Oaasa_Home_Screen extends AppCompatActivity {
DrawerLayout drawerLayout;
ActionBarDrawerToggle drawerToggle;
Toolbar toolbar;
NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oaasa__screen);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id){
                    case R.id.home:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.services:
                        Intent intent=new Intent(Oaasa_Home_Screen.this,Services.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.trainings:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.career:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.reg_login:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.order:
                        drawerLayout.closeDrawers();
                        break;
                }
                return false;
            }
        });
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayShowCustomEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.drawermenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
    if(drawerToggle.onOptionsItemSelected(item)){
        return true;
    }
    switch (id){
        case R.id.services:
            Intent intent=new Intent(Oaasa_Home_Screen.this,Services.class);
            startActivity(intent);
    }
       return super.onOptionsItemSelected(item);
    }
}
