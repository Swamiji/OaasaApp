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
public class Robotics extends Fragment implements ValueEventListener{
    TextView Title,Robotics_active,Robotics_active1,Robotics_active2,Robotics_active3;
    ImageView Robotics_image,Robotics_Log1;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitleRoboticsReferences=mRootReference.child("Title_Robotics");
    private DatabaseReference mRoboticsActiveReferences=mRootReference.child("Robotics_Active");
    private DatabaseReference mRoboticsActive2References=mRootReference.child("Robotics_Active1");
    private DatabaseReference mRoboticsActive3References=mRootReference.child("Robotics_Active2");
    private DatabaseReference mRoboticsActive1References=mRootReference.child("Robotics_Active3");
    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();


    public Robotics() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_robotics, container, false);
        Title=(TextView)view.findViewById(R.id.title_robotics);
        Robotics_active=(TextView)view.findViewById(R.id.robotics_active);
        Robotics_active1=(TextView)view.findViewById(R.id.robotics_active1);
        Robotics_image=(ImageView)view.findViewById(R.id.robotics_img);
        Robotics_Log1=(ImageView) view.findViewById(R.id.robotics_logo);
        Robotics_active2=(TextView)view.findViewById(R.id.robotics_Active2);
        Robotics_active3=(TextView)view.findViewById(R.id.robotics_Active3);
        mTitleRoboticsReferences.addValueEventListener(this);
        mRoboticsActiveReferences.addValueEventListener(this);
        mRoboticsActive1References.addValueEventListener(this);
        mRoboticsActive2References.addValueEventListener(this);
        mRoboticsActive3References.addValueEventListener(this);
        mImageReference.child("Robotics_head.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(Robotics_image);
            }
        });
        mImageReference.child("Robotics_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(Robotics_Log1);
            }
        });
        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("Title_Robotics")){
                String TitleSox=dataSnapshot.getValue(String.class);
                Title.setText(TitleSox);
            }
            else if(key.equals("Robotics_Active")){
                String Active=dataSnapshot.getValue(String.class);
                Robotics_active.setText(Active);
            }
            else if(key.equals("Robotics_Active1")){
                String Active1=dataSnapshot.getValue(String.class);
                Robotics_active1.setText(Active1);
            }
            else if(key.equals("Robotics_Active2")){
                String Active2=dataSnapshot.getValue(String.class);
                Robotics_active2.setText(Active2);
            }
            else if(key.equals("Robotics_Active3")){
                String Active3=dataSnapshot.getValue(String.class);
                Robotics_active3.setText(Active3);
            }

        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
