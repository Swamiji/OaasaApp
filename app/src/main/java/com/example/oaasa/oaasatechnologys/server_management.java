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
public class server_management extends Fragment implements ValueEventListener{

    TextView Title,server_active,server_active1,server_active2,server_active3;
    ImageView server_image,server_Log1;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitleServerReferences=mRootReference.child("Title_Server");
    private DatabaseReference mServerActiveReferences=mRootReference.child("Server_Active");
    private DatabaseReference mServerActive2References=mRootReference.child("Server_Active1");
    private DatabaseReference mServerActive3References=mRootReference.child("Server_Active2");
    private DatabaseReference mServerActive1References=mRootReference.child("Server_Active3");
    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();
    public server_management() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_server_management, container, false);
        Title=(TextView)view.findViewById(R.id.title_server);
        server_active=(TextView)view.findViewById(R.id.server_active);
        server_active1=(TextView)view.findViewById(R.id.server_active1);
        server_image=(ImageView)view.findViewById(R.id.server_img);
        server_Log1=(ImageView) view.findViewById(R.id.server_logo);
        server_active2=(TextView)view.findViewById(R.id.server_Active2);
        server_active3=(TextView)view.findViewById(R.id.server_Active3);
        mTitleServerReferences.addValueEventListener(this);
        mServerActiveReferences.addValueEventListener(this);
        mServerActive1References.addValueEventListener(this);
        mServerActive2References.addValueEventListener(this);
        mServerActive3References.addValueEventListener(this);
        mImageReference.child("serverManagement_head.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(server_image);
            }
        });
        mImageReference.child("serverManagement_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into(server_Log1);
            }
        });
        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("Title_Server")){
                String TitleSox=dataSnapshot.getValue(String.class);
                Title.setText(TitleSox);
            }
            else if(key.equals("Server_Active")){
                String Active=dataSnapshot.getValue(String.class);
                server_active.setText(Active);
            }
            else if(key.equals("Server_Active1")){
                String Active1=dataSnapshot.getValue(String.class);
                server_active1.setText(Active1);
            }
            else if(key.equals("Server_Active2")){
                String Active2=dataSnapshot.getValue(String.class);
                server_active2.setText(Active2);
            }
            else if(key.equals("Server_Active3")){
                String Active3=dataSnapshot.getValue(String.class);
                server_active3.setText(Active3);
            }

        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
