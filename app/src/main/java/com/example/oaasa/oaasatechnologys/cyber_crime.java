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
public class cyber_crime extends Fragment implements ValueEventListener{
    TextView Title,cyber_active,cyber_active1,cyber_active2,cyber_active3;
    ImageView cyber_image,cyber_Log1;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitleCyberReferences=mRootReference.child("Title_Crime");
    private DatabaseReference mCyberActiveReferences=mRootReference.child("Cyber_Active");
    private DatabaseReference mCyberActive2References=mRootReference.child("Cyber_Active1");
    private DatabaseReference mCyberActive3References=mRootReference.child("Cyber_Active2");
    private DatabaseReference mCyberActive1References=mRootReference.child("Cyber_Active3");
    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();


    public cyber_crime() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_cyber_crime, container, false);
        Title=(TextView)view.findViewById(R.id.title_Cyber);
        cyber_active=(TextView)view.findViewById(R.id.cyber_active);
        cyber_active1=(TextView)view.findViewById(R.id.cyber_active1);
        cyber_image=(ImageView)view.findViewById(R.id.cyber_img);
        cyber_Log1=(ImageView) view.findViewById(R.id.cyber_logo);
        cyber_active2=(TextView)view.findViewById(R.id.cyber_Active2);
        cyber_active3=(TextView)view.findViewById(R.id.cyber_Active3);
        mTitleCyberReferences.addValueEventListener(this);
        mCyberActiveReferences.addValueEventListener(this);
        mCyberActive1References.addValueEventListener(this);
        mCyberActive2References.addValueEventListener(this);
        mCyberActive3References.addValueEventListener(this);
        mImageReference.child("cyber crime head.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(cyber_image);
            }
        });
        mImageReference.child("cyber_crime_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(cyber_Log1);
            }
        });

        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("Title_Crime")){
                String TitleSox=dataSnapshot.getValue(String.class);
                Title.setText(TitleSox);
            }
            else if(key.equals("Cyber_Active")){
                String Active=dataSnapshot.getValue(String.class);
                cyber_active.setText(Active);
            }
            else if(key.equals("Cyber_Active1")){
                String Active1=dataSnapshot.getValue(String.class);
                cyber_active1.setText(Active1);
            }
            else if(key.equals("Cyber_Active2")){
                String Active2=dataSnapshot.getValue(String.class);
                cyber_active2.setText(Active2);
            }
            else if(key.equals("Cyber_Active3")){
                String Active3=dataSnapshot.getValue(String.class);
                cyber_active3.setText(Active3);
            }

        }

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
