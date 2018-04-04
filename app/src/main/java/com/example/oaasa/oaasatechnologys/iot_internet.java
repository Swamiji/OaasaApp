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
public class iot_internet extends Fragment implements ValueEventListener {

    TextView Title,iot_active,iot_active1,iot_active2,iot_active3;
    ImageView iot_image,iot_Log1;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitleIotReferences=mRootReference.child("Title_IOT");
    private DatabaseReference mIotActiveReferences=mRootReference.child("Iot_Active");
    private DatabaseReference mIotActive2References=mRootReference.child("Iot_Active1");
    private DatabaseReference mIotActive3References=mRootReference.child("Iot_Active2");
    private DatabaseReference mIotActive1References=mRootReference.child("Iot_Active3");
    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();
    public iot_internet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.fragment_iot_internet, container, false);
        // Inflate the layout for this fragment
        Title=(TextView)view.findViewById(R.id.title_iot);
        iot_active=(TextView)view.findViewById(R.id.iot_active);
        iot_active1=(TextView)view.findViewById(R.id.iot_active1);
        iot_image=(ImageView)view.findViewById(R.id.iot_img);
        iot_Log1=(ImageView) view.findViewById(R.id.iot_logo);
        iot_active2=(TextView)view.findViewById(R.id.iot_Active2);
        iot_active3=(TextView)view.findViewById(R.id.iot_Active3);
        mTitleIotReferences.addValueEventListener(this);
        mIotActiveReferences.addValueEventListener(this);
        mIotActive1References.addValueEventListener(this);
        mIotActive2References.addValueEventListener(this);
        mIotActive3References.addValueEventListener(this);
        mImageReference.child("IOT.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(iot_image);
            }
        });
        mImageReference.child("IOT_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(iot_Log1);
            }
        });
        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("Title_IOT")){
                String TitleSox=dataSnapshot.getValue(String.class);
                Title.setText(TitleSox);
            }
            else if(key.equals("Iot_Active")){
                String Active=dataSnapshot.getValue(String.class);
                iot_active.setText(Active);
            }
            else if(key.equals("Iot_Active1")){
                String Active1=dataSnapshot.getValue(String.class);
                iot_active1.setText(Active1);
            }
            else if(key.equals("Iot_Active2")){
                String Active2=dataSnapshot.getValue(String.class);
                iot_active2.setText(Active2);
            }
            else if(key.equals("Iot_Active3")){
                String Active3=dataSnapshot.getValue(String.class);
               iot_active3.setText(Active3);
            }

        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
