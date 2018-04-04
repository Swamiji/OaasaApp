package com.example.oaasa.oaasatechnologys;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class web_development extends Fragment implements ValueEventListener {
    View view;
    private ImageView webdevelopment_img,webdevelopment_logo;
    private TextView web_title,web_activities,web_activities1,web_metaDescription,
    web_management,web_contentManagement,website,websiteContent;
    private FirebaseDatabase firebaseDatabase2=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference2=firebaseDatabase2.getReference();
    private DatabaseReference mTitleReferences2=mRootReference2.child("Title2");
    private DatabaseReference mActivitiesReference=mRootReference2.child("WebActivities");
    private DatabaseReference mActivities1Reference=mRootReference2.child("WebActivities1");
    private DatabaseReference mMetaDescriptionReference=mRootReference2.child("WebMetaDescription");
    private DatabaseReference mWebManagementReference=mRootReference2.child("WebManagement");
    private DatabaseReference mWebManagementContentReference=mRootReference2.child("WebManagementContent");
    private DatabaseReference mWebsiteReference=mRootReference2.child("Website");
    private DatabaseReference mWebsiteContentReference=mRootReference2.child("WebsiteContent");
    private FirebaseStorage firebaseStorage2=FirebaseStorage.getInstance();
    private StorageReference mImageReference2=firebaseStorage2.getReference();

    public web_development() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view=inflater.inflate(R.layout.fragment_web_development, container, false);
        webdevelopment_img=(ImageView)view.findViewById(R.id.web_img);
        webdevelopment_logo=(ImageView)view.findViewById(R.id.web_logo);
        web_title=(TextView)view.findViewById(R.id.title_web);
        web_activities=(TextView)view.findViewById(R.id.activities);
        web_activities1=(TextView)view.findViewById(R.id.activities1);
        web_metaDescription=(TextView)view.findViewById(R.id.meta_description);
        web_management=(TextView)view.findViewById(R.id.management);
        web_contentManagement=(TextView)view.findViewById(R.id.contentManagement);
        website=(TextView)view.findViewById(R.id.website);
        websiteContent=(TextView)view.findViewById(R.id.websiteContent);
        mTitleReferences2.addValueEventListener(this);
        mActivitiesReference.addValueEventListener(this);
        mActivities1Reference.addValueEventListener(this);
        mMetaDescriptionReference.addValueEventListener(this);
        mWebManagementReference.addValueEventListener(this);
        mWebManagementContentReference.addValueEventListener(this);
        mWebsiteReference.addValueEventListener(this);
        mWebsiteContentReference.addValueEventListener(this);
        mImageReference2.child("webdevelopment_head.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(web_development.this).load(uri).fitCenter().into(webdevelopment_img);
            }
        });

        mImageReference2.child("webDevelopment_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(web_development.this).load(uri).fitCenter().into(webdevelopment_logo);
            }
        });



       return view;


    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
      if(dataSnapshot.getValue(String.class)!=null){
         String key=dataSnapshot.getKey();
          if(key.equals("Title2")){
              String Title=dataSnapshot.getValue(String.class);
              web_title.setText(Title);
          }
          else if(key.equals("WebActivities")){
              String Activities=dataSnapshot.getValue(String.class);
              web_activities.setText(Activities);
          }
          else if(key.equals("WebActivities1")){
              String Activities1=dataSnapshot.getValue(String.class);
              web_activities1.setText(Activities1);
          }
          else if(key.equals("WebMetaDescription")){
              String Activities2=dataSnapshot.getValue(String.class);
              web_metaDescription.setText(Activities2);
          }
          else if(key.equals("WebManagement")){
              String Activities2=dataSnapshot.getValue(String.class);
              web_management.setText(Activities2);
          }
          else if(key.equals("WebManagementContent")){
              String Activities2=dataSnapshot.getValue(String.class);
              web_contentManagement.setText(Activities2);
          }
          else if(key.equals("Website")){
              String Activities2=dataSnapshot.getValue(String.class);
              website.setText(Activities2);
          }
          else if(key.equals("WebsiteContent")){
              String Activities2=dataSnapshot.getValue(String.class);
              websiteContent.setText(Activities2);
          }
      }

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
