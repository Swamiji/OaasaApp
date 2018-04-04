package com.example.oaasa.oaasatechnologys;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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

public class Iot_Medical extends AppCompatActivity implements ValueEventListener {
    CircleImageView circleImageViewmedi;
    TextView Iot_medical_title,Eligibility,Duration,Fee,iot_medical_head,iot_medical_description,
    bank,branch;
    Toolbar toolbar;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference mRootReference=firebaseDatabase.getReference();
    DatabaseReference mIotMedicalTitle=mRootReference.child("IotMedicalTitle");
    DatabaseReference mEligibilityMedical=mRootReference.child("IotEligibility");
    DatabaseReference mDurationMedical=mRootReference.child("IotDurationMedical");
    DatabaseReference mFeeMedical=mRootReference.child("IotFeeMedical");
    DatabaseReference mMedicalDesHead=mRootReference.child("IotMedicalDesHead");
    DatabaseReference mMedicalDescription=mRootReference.child("IotMedicalDescription");
    DatabaseReference mMedicalBankDetails=mRootReference.child("BankDetails");
    DatabaseReference mMedicalBranch=mRootReference.child("BranchDetails");
    FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    StorageReference mImageStorageReference=firebaseStorage.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iot__medical);
        toolbar=(Toolbar)findViewById(R.id.toolbar2);
        toolbar.setTitle("IoT Medical");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        circleImageViewmedi=(CircleImageView)findViewById(R.id.iot_medical_circularimg);
        Iot_medical_title=(TextView)findViewById(R.id.iot_clinic_title);
        Eligibility=(TextView)findViewById(R.id.eligibility);
        Duration=(TextView)findViewById(R.id.Course_Duration);
        Fee=(TextView)findViewById(R.id.Course_Fee);
        iot_medical_head=(TextView)findViewById(R.id.Iot_medical_des_head);
        iot_medical_description=(TextView)findViewById(R.id.Iot_medical_description);
        bank=(TextView)findViewById(R.id.Iot_medical_bank_details);
        branch=(TextView)findViewById(R.id.Iot_medical_bank_branch);
        mIotMedicalTitle.addValueEventListener(this);
        mEligibilityMedical.addValueEventListener(this);
        mDurationMedical.addValueEventListener(this);
        mFeeMedical.addValueEventListener(this);
        mMedicalDesHead.addValueEventListener(this);
        mMedicalDescription.addValueEventListener(this);
        mMedicalBankDetails.addValueEventListener(this);
        mMedicalBranch.addValueEventListener(this);
        mImageStorageReference.child("medical_iot.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).fitCenter().into(circleImageViewmedi);
            }
        });
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String Key=dataSnapshot.getKey();
            if(Key.equals("IotMedicalTitle")){
                String Title=dataSnapshot.getValue(String.class);
                Iot_medical_title.setText(Title);
            }
            else if(Key.equals("IotEligibility")){
                String eligibility=dataSnapshot.getValue(String.class);
                Eligibility.setText(eligibility);
            }
            else if(Key.equals("IotDurationMedical")){
                String duration=dataSnapshot.getValue(String.class);
                Duration.setText(duration);
            }
            else if(Key.equals("IotFeeMedical")){
                String fee=dataSnapshot.getValue(String.class);
                Fee.setText(fee);
            }
            else if(Key.equals("IotMedicalDesHead")){
                String head_des=dataSnapshot.getValue(String.class);
                iot_medical_head.setText(head_des);
            }
            else if(Key.equals("IotMedicalDescription")){
                String description=dataSnapshot.getValue(String.class);
                iot_medical_description.setText(description);
            }
            else if(Key.equals("BankDetails")){
                String Bank=dataSnapshot.getValue(String.class);
                bank.setText(Bank);
            }
            else if(Key.equals("BranchDetails")){
                String Branch=dataSnapshot.getValue(String.class);
                branch.setText(Branch);
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
        drawable1.mutate();
        drawable.mutate();
        drawable.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        drawable1.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
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
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
