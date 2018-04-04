package com.example.oaasa.oaasatechnologys;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity implements ValueEventListener{
    Context context;
    private ImageView Service_img;
    private TextView service_title,service_date,service_shortDescrip,service_longDescrip,
            short_descrip,long_descrip,Post_Date;
    Toolbar toolbar;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitleReferences=mRootReference.child("Title");
    private DatabaseReference mPostdateReferences=mRootReference.child("PostDate");
    private DatabaseReference mShortDescripReferences=mRootReference.child("ShortDescription");
    private DatabaseReference mLongDescripReferences=mRootReference.child("LongDescription");
    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Service_img=(ImageView)findViewById(R.id.service_img);
        service_title=(TextView)findViewById(R.id.title);
        service_date=(TextView)findViewById(R.id.text_date);
        service_shortDescrip=(TextView)findViewById(R.id.text_short_descrip);
        service_longDescrip=(TextView)findViewById(R.id.text_long_descrip);
        short_descrip=(TextView)findViewById(R.id.short_descrip);
        long_descrip=(TextView)findViewById(R.id.Long_Descrip);
        Post_Date=(TextView)findViewById(R.id.date_Posted);
        Post_Date.setPaintFlags(Post_Date.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        short_descrip.setPaintFlags(short_descrip.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        long_descrip.setPaintFlags(long_descrip.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        service_title.setPaintFlags(service_title.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        service_title.setText("");
        service_date.setText("");
        service_shortDescrip.setText("");
        service_longDescrip.setText("");
        mTitleReferences.addValueEventListener(this);
        mPostdateReferences.addValueEventListener(this);
        mShortDescripReferences.addValueEventListener(this);
        mLongDescripReferences.addValueEventListener(this);
        mImageReference.child("annymart.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).fitCenter().into(Service_img);
            }
        });
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
       /* for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
            Detail detail=postSnapshot.getValue(Detail.class);
            String Title=detail.getTitle();
            String PostDate=detail.getPostDate();
            String ShortDescription=detail.getShortDescription();
            String LongDescription=detail.getLongDescription();

            service_title.setText(Title);
            service_date.setText(PostDate);
            service_shortDescrip.setText(ShortDescription);
            service_longDescrip.setText(LongDescription);

        }*/
       if(dataSnapshot.getValue(String.class)!=null){
           String key=dataSnapshot.getKey();

           if(key.equals("Title")){
               String Title=dataSnapshot.getValue(String.class);
               service_title.setText(Title);
           }
           else if(key.equals("PostDate")){
               String PostDate=dataSnapshot.getValue(String.class);
               service_date.setText(PostDate);
           }
           else if(key.equals("ShortDescription")){
               String Short_descrip=dataSnapshot.getValue(String.class);
               service_shortDescrip.setText(Short_descrip);
           }
           else if(key.equals("LongDescription")){
               String Long_descrip=dataSnapshot.getValue(String.class);
               service_longDescrip.setText(Long_descrip);
           }
       }


        }


    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

   /* @Override
    protected void onStart() {

        super.onStart();
        mTitleReferences.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String message=dataSnapshot.getValue(String.class);
                service_title.setText(message);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }*/
}
