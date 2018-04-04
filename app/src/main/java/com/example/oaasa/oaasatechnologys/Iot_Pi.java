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

public class Iot_Pi extends AppCompatActivity implements ValueEventListener {
    CircleImageView circleImageViewpi;
    TextView Iot_pi_title,Eligibility,Duration,Fee,iot_pi_head,iot_pi_description,
            iot_pi_description1,bank,branch;
    Toolbar toolbar;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference mRootReference=firebaseDatabase.getReference();
    DatabaseReference mIotpiTitle=mRootReference.child("IotpiTitle");
    DatabaseReference mEligibilitypi=mRootReference.child("IotEligibility");
    DatabaseReference mDurationpi=mRootReference.child("IotDuration");
    DatabaseReference mFeepi=mRootReference.child("IotFeepi");
    DatabaseReference mpiDesHead=mRootReference.child("IotpiDesHead");
    DatabaseReference mpiDescription=mRootReference.child("IotpiDescription");
    DatabaseReference mpiDescription1=mRootReference.child("IotpiDescription1");
    DatabaseReference mpiBankDetails=mRootReference.child("BankDetails");
    DatabaseReference mpiBranch=mRootReference.child("BranchDetails");
    FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    StorageReference mImageStorageReference=firebaseStorage.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iot__pi);
        toolbar=(Toolbar)findViewById(R.id.toolbar2);
        toolbar.setTitle("IoT Pi");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        circleImageViewpi=(CircleImageView)findViewById(R.id.iot_pi_circularimg);
        Iot_pi_title=(TextView)findViewById(R.id.iot_pi_title);
        Eligibility=(TextView)findViewById(R.id.pi_eligibility);
        Duration=(TextView)findViewById(R.id.Course_pi_Duration);
        Fee=(TextView)findViewById(R.id.Course_pi_Fee);
        iot_pi_head=(TextView)findViewById(R.id.Iot_pi_des_head);
        iot_pi_description=(TextView)findViewById(R.id.Iot_pi_description);
        iot_pi_description1=(TextView)findViewById(R.id.Iot_pi_description1);
        bank=(TextView)findViewById(R.id.Iot_pi_bank_details);
        branch=(TextView)findViewById(R.id.Iot_pi_bank_branch);
        mIotpiTitle.addValueEventListener(this);
        mEligibilitypi.addValueEventListener(this);
        mDurationpi.addValueEventListener(this);
        mFeepi.addValueEventListener(this);
        mpiDesHead.addValueEventListener(this);
        mpiDescription.addValueEventListener(this);
        mpiBankDetails.addValueEventListener(this);
        mpiBranch.addValueEventListener(this);
        mpiDescription1.addValueEventListener(this);
        mImageStorageReference.child("iot_pi.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).fitCenter().into(circleImageViewpi);
            }
        });
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        if(dataSnapshot.getValue(String.class)!=null){
            String Key=dataSnapshot.getKey();
            if(Key.equals("IotpiTitle")){
                String Title=dataSnapshot.getValue(String.class);
                Iot_pi_title.setText(Title);
            }
            else if(Key.equals("IotEligibility")){
                String eligibility=dataSnapshot.getValue(String.class);
                Eligibility.setText(eligibility);
            }
            else if(Key.equals("IotDuration")){
                String duration=dataSnapshot.getValue(String.class);
                Duration.setText(duration);
            }
            else if(Key.equals("IotFeepi")){
                String fee=dataSnapshot.getValue(String.class);
                Fee.setText(fee);
            }
            else if(Key.equals("IotpiDesHead")){
                String head_des=dataSnapshot.getValue(String.class);
                iot_pi_head.setText(head_des);
            }
            else if(Key.equals("IotpiDescription")){
                String description=dataSnapshot.getValue(String.class);
                iot_pi_description.setText(description);
            }
            else if(Key.equals("IotpiDescription1")){
                String description1=dataSnapshot.getValue(String.class);
                iot_pi_description1.setText(description1);
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
