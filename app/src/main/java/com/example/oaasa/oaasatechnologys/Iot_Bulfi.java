package com.example.oaasa.oaasatechnologys;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import de.hdodenhof.circleimageview.CircleImageView;

public class Iot_Bulfi extends AppCompatActivity implements ValueEventListener {
    CircleImageView circleImageViewbulfi;
    TextView Iot_bulfi_title,Eligibility,Duration,Fee,iot_bulfi_head,iot_bulfi_description,iot_bulfi_description1,
    iot_bulfi_bank,iot_bulfi_branch,netbanking;
    Toolbar toolbar;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference mRootReference=firebaseDatabase.getReference();
    DatabaseReference mIotBulfiTitle=mRootReference.child("IotBulfiTitle");
    DatabaseReference mEligibilityBulfi=mRootReference.child("IotEligibility");
    DatabaseReference mDurationBulfi=mRootReference.child("IotDurationMedical");
    DatabaseReference mFeeBulfi=mRootReference.child("IotFeeBulfi");
    DatabaseReference mBulfiDesHead=mRootReference.child("IotBulfiDesHead");
    DatabaseReference mBulfiDescription1=mRootReference.child("IotBulfiDescription");
    DatabaseReference mBulfiDescription=mRootReference.child("IotBulfiDescription1");
    DatabaseReference mBulfiBankDetails=mRootReference.child("BankDetails");
    DatabaseReference mBulfiBranch=mRootReference.child("BranchDetails");
    FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    StorageReference mImageStorageReference=firebaseStorage.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iot__bulfi);
        toolbar=(Toolbar)findViewById(R.id.toolbar2);
        toolbar.setTitle("IoT Bulfi");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        circleImageViewbulfi=(CircleImageView)findViewById(R.id.iot_bulfi_circularimg);
        Iot_bulfi_title=(TextView)findViewById(R.id.iot_bulfi_title);
        Eligibility=(TextView)findViewById(R.id.eligibility1);
        Duration=(TextView)findViewById(R.id.Course_Duration1);
        Fee=(TextView)findViewById(R.id.Course_Fee1);
        iot_bulfi_head=(TextView)findViewById(R.id.Iot_bulfi_des_head);
        iot_bulfi_description=(TextView)findViewById(R.id.Iot_bulfi_description);
        iot_bulfi_description1=(TextView)findViewById(R.id.Iot_bulfi_description1);
        iot_bulfi_bank=(TextView)findViewById(R.id.Iot_bulfi_bank_details);
        iot_bulfi_branch=(TextView)findViewById(R.id.Iot_bulfi_bank_branch);
        /*netbanking=(TextView)findViewById(R.id.titleNetBanking);
        netbanking.setPaintFlags(netbanking.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);*/
        mIotBulfiTitle.addValueEventListener(this);
        mEligibilityBulfi.addValueEventListener(this);
        mDurationBulfi.addValueEventListener(this);
        mFeeBulfi.addValueEventListener(this);
        mBulfiDesHead.addValueEventListener(this);
        mBulfiDescription.addValueEventListener(this);
        mBulfiDescription1.addValueEventListener(this);
        mBulfiBankDetails.addValueEventListener(this);
        mBulfiBranch.addValueEventListener(this);
        mImageStorageReference.child("iot_bulfi.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).fitCenter().into(circleImageViewbulfi);
            }
        });

    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String Key=dataSnapshot.getKey();
            if(Key.equals("IotBulfiTitle")){
                String Title=dataSnapshot.getValue(String.class);
                Iot_bulfi_title.setText(Title);
            }
            else if(Key.equals("IotEligibility")){
                String eligibility=dataSnapshot.getValue(String.class);
                Eligibility.setText(eligibility);
            }
            else if(Key.equals("IotDurationMedical")){
                String duration=dataSnapshot.getValue(String.class);
                Duration.setText(duration);
            }
            else if(Key.equals("IotFeeBulfi")){
                String fee=dataSnapshot.getValue(String.class);
                Fee.setText(fee);
            }
            else if(Key.equals("IotBulfiDesHead")){
                String head_des=dataSnapshot.getValue(String.class);
                iot_bulfi_head.setText(head_des);
            }
            else if(Key.equals("IotBulfiDescription")){
                String description=dataSnapshot.getValue(String.class);
                iot_bulfi_description.setText(description);
            }
            else if(Key.equals("IotBulfiDescription1")){
                String description=dataSnapshot.getValue(String.class);
                iot_bulfi_description1.setText(description);
            }
            else if(Key.equals("BankDetails")){
                String bank=dataSnapshot.getValue(String.class);
                iot_bulfi_bank.setText(bank);
            }
            else if(Key.equals("BranchDetails")){
                String branch=dataSnapshot.getValue(String.class);
                iot_bulfi_branch.setText(branch);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.training_service1,menu);
        Drawable drawable=menu.getItem(0).getIcon();
        Drawable drawable1=menu.getItem(2).getIcon();
        drawable.mutate();
        drawable1.mutate();
        drawable.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        drawable1.setColorFilter(getResources().getColor(R.color.white),PorterDuff.Mode.SRC_IN);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        int id=item.getItemId();
        switch (id){
            case R.id.trainging_service1:
                Toast.makeText(getApplicationContext(),"Click On Service",Toast.LENGTH_SHORT).show();
                break;

            case R.id.enquiry1:
                break;

            case R.id.contact:
                Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}
