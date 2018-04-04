package com.example.oaasa.oaasatechnologys;


import android.graphics.Paint;
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
public class PCB extends Fragment implements ValueEventListener {
    TextView Title,Pcb_active,Pcb_active1,Pcb_active2,Pcb_active3,fabrication,design,assembly,
            title_fabrication,title_design,title_assembly;
    ImageView Pcb_image,Pcb_Log1;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference();
    private DatabaseReference mTitlePcbReferences=mRootReference.child("Title_Pcb");
    private DatabaseReference mPcbActiveReferences=mRootReference.child("Pcb_Active");
    private DatabaseReference mPcbActive2References=mRootReference.child("Pcb_Active1");
    private DatabaseReference mPcbActive3References=mRootReference.child("Pcb_Active2");
    private DatabaseReference mPcbActive1References=mRootReference.child("Pcb_Active3");
    private DatabaseReference mPcbFabricaionReferences=mRootReference.child("Pcb_Fabrication");
    private DatabaseReference mPcbDesignReferences=mRootReference.child("Pcb_Design");
    private DatabaseReference mPcbAssemblyReferences=mRootReference.child("Pcb_Assembly");

    private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    private StorageReference mImageReference=firebaseStorage.getReference();

    public PCB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_pcb, container, false);
        Title=(TextView)view.findViewById(R.id.title_pcb);
        Pcb_active=(TextView)view.findViewById(R.id.pcb_active);
        Pcb_active1=(TextView)view.findViewById(R.id.pcb_active1);
        Pcb_image=(ImageView)view.findViewById(R.id.pcb_img);
        Pcb_Log1=(ImageView) view.findViewById(R.id.pcb_logo);
        Pcb_active2=(TextView)view.findViewById(R.id.pcb_Active2);
        Pcb_active3=(TextView)view.findViewById(R.id.pcb_Active3);
        fabrication=(TextView)view.findViewById(R.id.description_fabricaion);
        design=(TextView)view.findViewById(R.id.description_design);
        assembly=(TextView)view.findViewById(R.id.description_assembly);
        title_fabrication=(TextView)view.findViewById(R.id.title_fabricaion);
        title_design=(TextView)view.findViewById(R.id.title_design);
        title_assembly=(TextView)view.findViewById(R.id.title_assembly);
        title_fabrication.setPaintFlags(title_fabrication.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        title_design.setPaintFlags(title_design.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        title_assembly.setPaintFlags(title_assembly.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        mTitlePcbReferences.addValueEventListener(this);
        mPcbActiveReferences.addValueEventListener(this);
        mPcbActive1References.addValueEventListener(this);
        mPcbActive2References.addValueEventListener(this);
        mPcbActive3References.addValueEventListener(this);
        mPcbFabricaionReferences.addValueEventListener(this);
        mPcbDesignReferences.addValueEventListener(this);
        mPcbAssemblyReferences.addValueEventListener(this);
        mImageReference.child("PCB_Head.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into( Pcb_image);
            }
        });
        mImageReference.child("PCB_logo.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getActivity()).load(uri).fitCenter().into( Pcb_Log1);
            }
        });
        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("Title_Pcb")){
                String TitleSox=dataSnapshot.getValue(String.class);
                Title.setText(TitleSox);
            }
            else if(key.equals("Pcb_Active")){
                String Active=dataSnapshot.getValue(String.class);
                Pcb_active.setText(Active);
            }
            else if(key.equals("Pcb_Active1")){
                String Active1=dataSnapshot.getValue(String.class);
                Pcb_active1.setText(Active1);
            }
            else if(key.equals("Pcb_Active2")){
                String Active2=dataSnapshot.getValue(String.class);
                Pcb_active2.setText(Active2);
            }
            else if(key.equals("Pcb_Active3")){
                String Active3=dataSnapshot.getValue(String.class);
                Pcb_active3.setText(Active3);
            }
            else if(key.equals("Pcb_Fabrication")){
                String Active4=dataSnapshot.getValue(String.class);
                fabrication.setText(Active4);
            }
            else if(key.equals("Pcb_Design")){
                String Active5=dataSnapshot.getValue(String.class);
                design.setText(Active5);
            }
            else if(key.equals("Pcb_Assembly")){
                String Active6=dataSnapshot.getValue(String.class);
               assembly.setText(Active6);
            }


        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
