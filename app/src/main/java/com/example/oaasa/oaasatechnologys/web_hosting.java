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
public class web_hosting extends Fragment implements ValueEventListener {
    TextView Title,hosting_active,hosting_active1,hosting_active2,hosting_active3;
    ImageView hosting_image,hosting_Log1;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitleHostingReferences=mRootReference.child("Title_Hosting");
    private DatabaseReference mHostingActiveReferences=mRootReference.child("Hosting_Active");
    private DatabaseReference mHostingActive2References=mRootReference.child("Hosting_Active1");
    private DatabaseReference mHostingActive3References=mRootReference.child("Hosting_Active2");
    private DatabaseReference mHostingActive1References=mRootReference.child("Hosting_Active3");
    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();



    public web_hosting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_web_hosting, container, false);
        Title=(TextView)view.findViewById(R.id.title_hosting);
        hosting_active=(TextView)view.findViewById(R.id.hosting_active);
        hosting_active1=(TextView)view.findViewById(R.id.hosting_active1);
        hosting_image=(ImageView)view.findViewById(R.id.hosting_img);
        hosting_Log1=(ImageView) view.findViewById(R.id.hosting_logo);
        hosting_active2=(TextView)view.findViewById(R.id.hosting_Active2);
        hosting_active3=(TextView)view.findViewById(R.id.hosting_Active3);
        mTitleHostingReferences.addValueEventListener(this);
        mHostingActiveReferences.addValueEventListener(this);
        mHostingActive1References.addValueEventListener(this);
        mHostingActive2References.addValueEventListener(this);
        mHostingActive3References.addValueEventListener(this);
        mImageReference.child("hosting_head.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(hosting_image);
            }
        });
        mImageReference.child("hosting_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(hosting_Log1);
            }
        });
        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("Title_Hosting")){
                String TitleSox=dataSnapshot.getValue(String.class);
                Title.setText(TitleSox);
            }
            else if(key.equals("Hosting_Active")){
                String Active=dataSnapshot.getValue(String.class);
                hosting_active.setText(Active);
            }
            else if(key.equals("Hosting_Active1")){
                String Active1=dataSnapshot.getValue(String.class);
                hosting_active1.setText(Active1);
            }
            else if(key.equals("Hosting_Active2")){
                String Active2=dataSnapshot.getValue(String.class);
                hosting_active2.setText(Active2);
            }
            else if(key.equals("Hosting_Active3")){
                String Active3=dataSnapshot.getValue(String.class);
                hosting_active3.setText(Active3);
            }

        }

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
