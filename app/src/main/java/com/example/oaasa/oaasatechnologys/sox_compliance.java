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
public class sox_compliance extends Fragment implements ValueEventListener{
TextView Title,Sox_active,Sox_active1,Sox_active2,Sox_active3;
ImageView Sox_image,Sox_Log1;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitleSOXReferences=mRootReference.child("Title_Sox");
    private DatabaseReference mSoxActiveReferences=mRootReference.child("SOX_Active");
    private DatabaseReference mSoxActive2References=mRootReference.child("SOX_Active1");
    private DatabaseReference mSoxActive3References=mRootReference.child("SOX_Active2");
    private DatabaseReference mSoxActive1References=mRootReference.child("SOX_Active3");
    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();
    public sox_compliance() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment

        view=inflater.inflate(R.layout.fragment_sox_compliance, container, false);
        Title=(TextView)view.findViewById(R.id.title_SOX);
        Sox_active=(TextView)view.findViewById(R.id.SOX_active);
        Sox_active1=(TextView)view.findViewById(R.id.SOX_active1);
        Sox_image=(ImageView)view.findViewById(R.id.SOX_img);
        Sox_Log1=(ImageView) view.findViewById(R.id.SOX_logo);
        Sox_active2=(TextView)view.findViewById(R.id.Sox_Active2);
        Sox_active3=(TextView)view.findViewById(R.id.Sox_Active3);
        mTitleSOXReferences.addValueEventListener(this);
        mSoxActiveReferences.addValueEventListener(this);
        mSoxActive1References.addValueEventListener(this);
        mSoxActive2References.addValueEventListener(this);
        mSoxActive3References.addValueEventListener(this);
        mImageReference.child("Sox_Compliance_head.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(Sox_image);
            }
        });
        mImageReference.child("Sox_compliance_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(Sox_Log1);
            }
        });


        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
           if(dataSnapshot.getValue(String.class)!=null){
               String key=dataSnapshot.getKey();

               if(key.equals("Title_Sox")){
                   String TitleSox=dataSnapshot.getValue(String.class);
                   Title.setText(TitleSox);
               }
               else if(key.equals("SOX_Active")){
                   String Active=dataSnapshot.getValue(String.class);
                   Sox_active.setText(Active);
               }
               else if(key.equals("SOX_Active1")){
                   String Active1=dataSnapshot.getValue(String.class);
                   Sox_active1.setText(Active1);
               }
               else if(key.equals("SOX_Active2")){
                   String Active2=dataSnapshot.getValue(String.class);
                   Sox_active2.setText(Active2);
               }
               else if(key.equals("SOX_Active3")){
                   String Active3=dataSnapshot.getValue(String.class);
                   Sox_active3.setText(Active3);
               }

           }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
