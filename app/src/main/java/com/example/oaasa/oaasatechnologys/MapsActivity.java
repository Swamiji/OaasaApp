package com.example.oaasa.oaasatechnologys;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,ValueEventListener{
    private GoogleMap mMap;
    List<Address> addresses;
    double latitude=22.6029973;
    double logitude=88.424218;
    private static final LatLng Baisaki_khal = new LatLng(22.601900, 88.422555);
    private static final LatLng oaasa_technologys = new LatLng(22.6029973, 88.424218);
    TextView gettouch,Titlevisit,TextVisit,TextVisitAlternate,Contact,Contact1,titlecontact,
    titleEmail,Email,Email1,titleWeb,Web;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference mRootReference=firebaseDatabase.getReference();
    DatabaseReference mTextVisitReference=mRootReference.child("OaasaAddress");
    DatabaseReference mAlternateReference=mRootReference.child("OaasaAlternateAddress");
    DatabaseReference mContactReference=mRootReference.child("OaasaContact");
    DatabaseReference mContact1Reference=mRootReference.child("OaasaContact1");
    DatabaseReference mEmailReference=mRootReference.child("OaasaEmail");
    DatabaseReference mEmail11Reference=mRootReference.child("OaasaEmail1");
    DatabaseReference mWebReference=mRootReference.child("OaasaWeb");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        gettouch=(TextView)findViewById(R.id.touch);
        Titlevisit=(TextView)findViewById(R.id.TitleVisit);
        TextVisit=(TextView)findViewById(R.id.textVisit);
        TextVisitAlternate=(TextView)findViewById(R.id.textVisitalternate);
        Contact=(TextView)findViewById(R.id.textContact);
        Contact1=(TextView)findViewById(R.id.textContact1);
        titlecontact=(TextView)findViewById(R.id.TitleContact);
        titleEmail=(TextView)findViewById(R.id.TitleEmail);
        Email=(TextView)findViewById(R.id.textEmail);
        Email1=(TextView)findViewById(R.id.textEmail1);
        titleWeb=(TextView)findViewById(R.id.TitleWeb);
        Web=(TextView)findViewById(R.id.textWeb);
        titleWeb.setPaintFlags(titleWeb.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        titleEmail.setPaintFlags(titleEmail.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        Titlevisit.setPaintFlags(Titlevisit.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        gettouch.setPaintFlags(gettouch.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        titlecontact.setPaintFlags(titlecontact.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);

        mTextVisitReference.addValueEventListener(this);
        mAlternateReference.addValueEventListener(this);
        mContact1Reference.addValueEventListener(this);
        mContactReference.addValueEventListener(this);
        mEmailReference.addValueEventListener(this);
        mEmail11Reference.addValueEventListener(this);
        mWebReference.addValueEventListener(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ActionBar actionBar=getActionBar();

       if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        final LatLng oaasa = new LatLng(latitude, logitude);
        mMap.addMarker(new MarkerOptions().position(oaasa).title("Oaasa Technologys"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(oaasa));
        CameraPosition myPosition = new CameraPosition.Builder()
                .target(oaasa).zoom(17).bearing(90).tilt(30).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(myPosition));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.getDefault());
                try {
                    addresses=geocoder.getFromLocation(marker.getPosition().latitude,marker.getPosition().longitude,1);
                    String address=addresses.get(0).getAddressLine(0);
                    String city=addresses.get(0).getLocality();
                    String state=addresses.get(0).getAdminArea();
                    String postalcode=addresses.get(0).getPostalCode();

                    /***Polyline in google map***/

                    mMap.addPolyline(new PolylineOptions().add(oaasa_technologys,Baisaki_khal).width(5).color(Color.BLUE).geodesic(true));
                    MarkerOptions markerOptions=new MarkerOptions().position(oaasa).title("Oaasa Technologys");
                    marker=mMap.addMarker(markerOptions);
                    marker.showInfoWindow();
                    Toast.makeText(getApplicationContext(),"Address :"+address+"\n"+"City :"+city+"\n"
                            +"State :"+state+"\n"+"Postal Code :"+postalcode,Toast.LENGTH_LONG).show();
                } catch (IOException e) {

                }

                return true;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.home){
            finish();
        }
        return onOptionsItemSelected(item);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();
            if(key.equals("OaasaAddress")){
                String address=dataSnapshot.getValue(String.class);
                TextVisit.setText(address);
            }
            else if(key.equals("OaasaAlternateAddress")){
                String alternateAddress=dataSnapshot.getValue(String.class);
                TextVisitAlternate.setText(alternateAddress);
            }
            else if(key.equals("OaasaContact")){
                String contact=dataSnapshot.getValue(String.class);
                Contact.setText(contact);
            }
            else if(key.equals("OaasaContact1")){
                String contact1=dataSnapshot.getValue(String.class);
                Contact1.setText(contact1);
            }
            else if(key.equals("OaasaEmail")){
                String email=dataSnapshot.getValue(String.class);
                Email.setText(email);
            }
            else if(key.equals("OaasaEmail1")){
                String email1=dataSnapshot.getValue(String.class);
                Email1.setText(email1);
            }
            else if(key.equals("OaasaWeb")){
                String web=dataSnapshot.getValue(String.class);
                Web.setText(web);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
