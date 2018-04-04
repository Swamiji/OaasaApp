package com.example.oaasa.oaasatechnologys;


import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class erp_consultancy extends Fragment implements ValueEventListener {
    View view;
    private ImageView Service_img,Erp_logo;
    private Context context;
    private TextView service_title,service_shortDescrip,service_longDescrip,short_des;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitleReferences=mRootReference.child("Title");
    //private DatabaseReference mPostdateReferences=mRootReference.child("PostDate");
    private DatabaseReference mShortDescripReferences=mRootReference.child("ShortDescription");
    private DatabaseReference mLongDescripReferences=mRootReference.child("LongDescription");
    private DatabaseReference mShortDesReference=mRootReference.child("ShortDes");
    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();

    public erp_consultancy() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_erp_consultancy, container, false);

        Service_img=(ImageView)view.findViewById(R.id.service_img);
        Erp_logo=(ImageView)view.findViewById(R.id.erp_logo);
        service_title=(TextView)view.findViewById(R.id.title);
        service_shortDescrip=(TextView)view.findViewById(R.id.text_short_descrip);
        service_longDescrip=(TextView)view.findViewById(R.id.text_long_descrip);
        short_des=(TextView)view.findViewById(R.id.short_des);

        mTitleReferences.addValueEventListener(this);
        mShortDescripReferences.addValueEventListener(this);
        mLongDescripReferences.addValueEventListener(this);
        mShortDesReference.addValueEventListener(this);
        mImageReference.child("erp_header.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(Service_img);
            }
        });
        mImageReference.child("erp_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(Erp_logo);
            }
        });
        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("Title")){
                String Title=dataSnapshot.getValue(String.class);
                service_title.setText(Title);
            }
            else if(key.equals("ShortDescription")){
                String Short_descrip=dataSnapshot.getValue(String.class);
                service_shortDescrip.setText(Short_descrip);
            }
            else if(key.equals("LongDescription")){
                String Long_descrip=dataSnapshot.getValue(String.class);
                service_longDescrip.setText(Long_descrip);
            }
            else if(key.equals("ShortDes")){
                String ShortDescrip_header=dataSnapshot.getValue(String.class);
                short_des.setText(ShortDescrip_header);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
