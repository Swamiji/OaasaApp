package com.example.oaasa.oaasatechnologys;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class HomeScreenPage extends AppCompatActivity {
Toolbar toolbar;
BottomBar bottomBar;
GridView gridView;
private int img[]={R.drawable.house,R.drawable.training,R.drawable.servicesimage,
R.drawable.tech_service,R.drawable.tech_service,R.drawable.tech_service,R.drawable.tech_service,
R.drawable.tech_service,R.drawable.tech_service};

private String title[]={"Home","Training","Services","Career","Order","Services","Services","Services"
,"Services"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screenpage);
        bottomBar=(BottomBar)findViewById(R.id.bottom_bar);
        gridView=(GridView)findViewById(R.id.gridView);
        GridviewAdapter gridviewAdapter=new GridviewAdapter(img,title,getApplicationContext());
        gridView.setAdapter(gridviewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Clicked on Position:"+position,Toast.LENGTH_SHORT).show();
                if(position==0){
                    Intent intent=new Intent(HomeScreenPage.this,Services.class);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent=new Intent(HomeScreenPage.this,Trainings.class);
                    startActivity(intent);

                }
                else if(position==2){
                    Intent intent=new Intent(HomeScreenPage.this,Services.class);
                    startActivity(intent);
                }
                else if(position==3){

                }
                else if(position==4){

                }
                else if(position==5){

                }
            }
        });
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                if(tabId==R.id.tab_home){
                    Toast.makeText(HomeScreenPage.this,"Select On Home",Toast.LENGTH_SHORT).show();
                }
                else if(tabId==R.id.tab_services){
                    Toast.makeText(HomeScreenPage.this,"Select On Services",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(HomeScreenPage.this,Services.class);
                    startActivity(intent);
                }
                else if(tabId==R.id.tab_training){
                    Toast.makeText(HomeScreenPage.this,"Select On Trainings",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(HomeScreenPage.this,Trainings.class);
                    startActivity(intent);
                }
                else if(tabId==R.id.tab_career){
                    Toast.makeText(HomeScreenPage.this,"Select On Career",Toast.LENGTH_SHORT).show();
                }
                else if(tabId==R.id.tab_order){
                    Toast.makeText(HomeScreenPage.this,"Select On Order",Toast.LENGTH_SHORT).show();
                }
            }
        });
        toolbar=(Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            Drawable backArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
            backArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(backArrow);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        Context context=this;
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(context,R.color.colorPrimary));
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(context,R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#ffffff"));
        collapsingToolbarLayout.setTitle("Home");

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
