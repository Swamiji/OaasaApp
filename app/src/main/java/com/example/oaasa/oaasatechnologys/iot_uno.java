package com.example.oaasa.oaasatechnologys;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
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

public class iot_uno extends AppCompatActivity implements ValueEventListener {
    CircleImageView circleImageViewuno;
    TextView Iot_uno_title,Eligibility,Duration,Fee,iot_uno_head,iot_uno_description,
            iot_uno_description1,bank,branch;
    Toolbar toolbar;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference mRootReference=firebaseDatabase.getReference();
    DatabaseReference mIotUnoTitle=mRootReference.child("IotUnoTitle");
    DatabaseReference mEligibilityAnalytics=mRootReference.child("IotEligibility");
    DatabaseReference mDurationAnalytics=mRootReference.child("IotDuration");
    DatabaseReference mFeeUno=mRootReference.child("IotFeeUno");
    DatabaseReference mUnoDesHead=mRootReference.child("IotUnoDesHead");
    DatabaseReference mUnoDescription=mRootReference.child("IotUnoDescription");
    DatabaseReference mUnoDescription1=mRootReference.child("IotUnoDescription1");
    DatabaseReference mUnoBankDetails=mRootReference.child("BankDetails");
    DatabaseReference mUnoBranch=mRootReference.child("BranchDetails");
    FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    StorageReference mImageStorageReference=firebaseStorage.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iot_uno);
        toolbar=(Toolbar)findViewById(R.id.toolbar2);
        toolbar.setTitle("IoT Uno");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        circleImageViewuno=(CircleImageView)findViewById(R.id.iot_uno_circularimg);
        Iot_uno_title=(TextView)findViewById(R.id.iot_uno_title);
        Eligibility=(TextView)findViewById(R.id.uno_eligibility);
        Duration=(TextView)findViewById(R.id.Course_uno_Duration);
        Fee=(TextView)findViewById(R.id.Course_uno_Fee);
        iot_uno_head=(TextView)findViewById(R.id.Iot_uno_des_head);
        iot_uno_description=(TextView)findViewById(R.id.Iot_uno_description);
        iot_uno_description1=(TextView)findViewById(R.id.Iot_uno_description1);
        bank=(TextView)findViewById(R.id.Iot_uno_bank_details);
        branch=(TextView)findViewById(R.id.Iot_uno_bank_branch);
        mIotUnoTitle.addValueEventListener(this);
        mEligibilityAnalytics.addValueEventListener(this);
        mDurationAnalytics.addValueEventListener(this);
        mFeeUno.addValueEventListener(this);
        mUnoDesHead.addValueEventListener(this);
        mUnoDescription.addValueEventListener(this);
        mUnoBankDetails.addValueEventListener(this);
        mUnoBranch.addValueEventListener(this);
        mUnoDescription1.addValueEventListener(this);
        mImageStorageReference.child("iot_uno.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).fitCenter().into(circleImageViewuno);
            }
        });
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String Key=dataSnapshot.getKey();
            if(Key.equals("IotUnoTitle")){
                String Title=dataSnapshot.getValue(String.class);
                Iot_uno_title.setText(Title);
            }
            else if(Key.equals("IotEligibility")){
                String eligibility=dataSnapshot.getValue(String.class);
                Eligibility.setText(eligibility);
            }
            else if(Key.equals("IotDuration")){
                String duration=dataSnapshot.getValue(String.class);
                Duration.setText(duration);
            }
            else if(Key.equals("IotFeeUno")){
                String fee=dataSnapshot.getValue(String.class);
                Fee.setText(fee);
            }
            else if(Key.equals("IotUnoDesHead")){
                String head_des=dataSnapshot.getValue(String.class);
                iot_uno_head.setText(head_des);
            }
            else if(Key.equals("IotUnoDescription")){
                String description=dataSnapshot.getValue(String.class);
                iot_uno_description.setText(description);
            }
            else if(Key.equals("IotUnoDescription1")){
                String description1=dataSnapshot.getValue(String.class);
                iot_uno_description1.setText(description1);
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

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
