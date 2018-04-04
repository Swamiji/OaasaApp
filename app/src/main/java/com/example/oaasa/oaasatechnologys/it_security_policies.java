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
public class it_security_policies extends Fragment implements ValueEventListener {
TextView ItTitle,ItActivities,ItActivities1,ItContent,ItActivities2;
ImageView ItImage,ItLogo;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitleReferences=mRootReference.child("ItTitle");
    private DatabaseReference mActivitiesItRef=mRootReference.child("ItActivities");
    private DatabaseReference mActivitiesIt1Ref=mRootReference.child("ItActivities1");
    private DatabaseReference mActivitiesIt2Ref=mRootReference.child("ItActivities2");
    private DatabaseReference mItContentRef=mRootReference.child("ItContent");
    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();

    public it_security_policies() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_it_security_policies, container, false);
        ItTitle=(TextView)view.findViewById(R.id.title_itSecurity);
        ItActivities=(TextView)view.findViewById(R.id.Itactivities);
        ItActivities1=(TextView)view.findViewById(R.id.Itactivities1);
        ItContent=(TextView)view.findViewById(R.id.itSecurityContent);
        ItImage=(ImageView)view.findViewById(R.id.itSecurity_img);
        ItLogo=(ImageView)view.findViewById(R.id.itSecurity_logo);
        ItActivities2=(TextView)view.findViewById(R.id.Itactivities2);
        mTitleReferences.addValueEventListener(this);
        mActivitiesItRef.addValueEventListener(this);
        mActivitiesIt1Ref.addValueEventListener(this);
        mItContentRef.addValueEventListener(this);
        mActivitiesIt2Ref.addValueEventListener(this);
        mImageReference.child("ItSecurityPolicies_head.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(ItImage);
            }
        });
        mImageReference.child("ItSecurityPolicies_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(ItLogo);
            }
        });

        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("ItTitle")){
                String Title=dataSnapshot.getValue(String.class);
                ItTitle.setText(Title);
            }
            else if(key.equals("ItActivities")){
                String ItActivity=dataSnapshot.getValue(String.class);
                ItActivities.setText(ItActivity);
            }
            else if(key.equals("ItActivities1")){
                String ItActivity1=dataSnapshot.getValue(String.class);
                ItActivities1.setText(ItActivity1);
            }
            else if(key.equals("ItContent")){
                String ItContent1=dataSnapshot.getValue(String.class);
                ItContent.setText(ItContent1);
            }
            else if(key.equals("ItActivities2")){
                String ItContent2=dataSnapshot.getValue(String.class);
                ItActivities2.setText(ItContent2);
            }
        }

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
