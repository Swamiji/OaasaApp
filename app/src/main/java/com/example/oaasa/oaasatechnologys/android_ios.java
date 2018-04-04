package com.example.oaasa.oaasatechnologys;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class android_ios extends Fragment implements ValueEventListener {
    View view;
    private ImageView Service_img,Android_logo;

    private TextView service_title,service_shortDescrip,android_title,android_title_description,
            ios_title,ios_title_description,short_descrip;
    private FirebaseDatabase firebaseDatabase1=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference1=firebaseDatabase1.getReference();
    private DatabaseReference mTitleReferences1=mRootReference1.child("Title1");
    private DatabaseReference mAndroidTitleDescripReference=mRootReference1.child("Android_Title_Des");
    private DatabaseReference mIosTitleDescriptionReference=mRootReference1.child("Ios_Title_Des");
    private DatabaseReference mShortDescripReferences=mRootReference1.child("ShortDescription1");
    private DatabaseReference mShortDescripDemo=mRootReference1.child("ShortDescription1_demo");
    private FirebaseStorage firebaseStorage1=FirebaseStorage.getInstance();
    private StorageReference mImageReference1=firebaseStorage1.getReference();


    public android_ios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_android_ios, container, false);
        Service_img=(ImageView)view.findViewById(R.id.android_img);
        Android_logo=(ImageView)view.findViewById(R.id.android_logo);
        service_title=(TextView)view.findViewById(R.id.title1);
        short_descrip=(TextView)view.findViewById(R.id.short_descrip2);
        service_shortDescrip=(TextView)view.findViewById(R.id.text_short_descrip1);
        android_title=(TextView)view.findViewById(R.id.android_title);
        ios_title=(TextView)view.findViewById(R.id.ios_title);
        android_title_description=(TextView)view.findViewById(R.id.android_title_description);
        ios_title_description=(TextView)view.findViewById(R.id.ios_title_description);
        android_title.setPaintFlags(android_title.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        ios_title.setPaintFlags(ios_title.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        mTitleReferences1.addValueEventListener(this);
        mShortDescripReferences.addValueEventListener(this);
        mAndroidTitleDescripReference.addValueEventListener(this);
        mIosTitleDescriptionReference.addValueEventListener(this);
        mShortDescripDemo.addValueEventListener(this);

        mImageReference1.child("android_header.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(Service_img);
            }
        });
        mImageReference1.child("android_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(Android_logo);
            }
        });
        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("Title1")){
                String Title=dataSnapshot.getValue(String.class);
                service_title.setText(Title);
            }
            else if(key.equals("ShortDescription1")){
                String Short_descrip=dataSnapshot.getValue(String.class);
                service_shortDescrip.setText(Short_descrip);
            }
            else if(key.equals("Android_Title_Des")){
                String Android_Title_Des=dataSnapshot.getValue(String.class);
                android_title_description.setText(Android_Title_Des);
            }
            else if(key.equals("Ios_Title_Des")){
                String Ios_Title_Des=dataSnapshot.getValue(String.class);
                ios_title_description.setText(Ios_Title_Des);
            }
            else if(key.equals("ShortDescription1_demo")){
                String ShortDescriptionDemo=dataSnapshot.getValue(String.class);
                short_descrip.setText(ShortDescriptionDemo);
            }

        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    }
