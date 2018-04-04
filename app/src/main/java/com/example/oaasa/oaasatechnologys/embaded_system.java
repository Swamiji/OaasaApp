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
public class embaded_system extends Fragment implements ValueEventListener {
    TextView Title,embaded_active,embaded_active1,embaded_active2,embaded_active3;
    ImageView embaded_image,embaded_Log1;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitleServerReferences=mRootReference.child("Title_Embaded");
    private DatabaseReference mEmbadedActiveReferences=mRootReference.child("Embaded_Active");
    private DatabaseReference mEmbadedActive2References=mRootReference.child("Embaded_Active1");
    private DatabaseReference mEmbadedActive3References=mRootReference.child("Embaded_Active2");
    private DatabaseReference mEmbadedActive1References=mRootReference.child("Embaded_Active3");
    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();

    public embaded_system() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_embaded_system, container, false);
        Title=(TextView)view.findViewById(R.id.title_embaded);
        embaded_active=(TextView)view.findViewById(R.id.embaded_active);
       embaded_active1=(TextView)view.findViewById(R.id.embaded_active1);
        embaded_image=(ImageView)view.findViewById(R.id.embaded_img);
       embaded_Log1=(ImageView) view.findViewById(R.id.embaded_logo);
       embaded_active2=(TextView)view.findViewById(R.id.embaded_Active2);
        embaded_active3=(TextView)view.findViewById(R.id.embaded_Active3);
        mTitleServerReferences.addValueEventListener(this);
        mEmbadedActiveReferences.addValueEventListener(this);
        mEmbadedActive1References.addValueEventListener(this);
        mEmbadedActive2References.addValueEventListener(this);
        mEmbadedActive3References.addValueEventListener(this);
        mImageReference.child("embaded_head.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(embaded_image);
            }
        });
        mImageReference.child("embaded_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(embaded_Log1);
            }
        });
        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("Title_Embaded")){
                String TitleSox=dataSnapshot.getValue(String.class);
                Title.setText(TitleSox);
            }
            else if(key.equals("Embaded_Active")){
                String Active=dataSnapshot.getValue(String.class);
                embaded_active.setText(Active);
            }
            else if(key.equals("Embaded_Active1")){
                String Active1=dataSnapshot.getValue(String.class);
                embaded_active1.setText(Active1);
            }
            else if(key.equals("Embaded_Active2")){
                String Active2=dataSnapshot.getValue(String.class);
                embaded_active2.setText(Active2);
            }
            else if(key.equals("Embaded_Active3")){
                String Active3=dataSnapshot.getValue(String.class);
                embaded_active3.setText(Active3);
            }

        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
