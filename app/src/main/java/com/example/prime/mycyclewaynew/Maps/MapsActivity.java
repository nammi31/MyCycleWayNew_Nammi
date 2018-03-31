package com.example.prime.mycyclewaynew.Maps;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


import com.example.prime.mycyclewaynew.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

//    public String getAddress(double lat, double lng) {
//        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
//        String add = new String();
//        try {
//            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
//            Address obj = addresses.get(0);
//            add = obj.getAddressLine(0);
//            add = add + "\n" + obj.getCountryName();
//            add = add + "\n" + obj.getCountryCode();
//            add = add + "\n" + obj.getAdminArea();
//            //add = add + "\n" + obj.getPostalCode();
//            add = add + "\n" + obj.getSubAdminArea();
//            //add = add + "\n" + obj.getLocality();
//            //add = add + "\n" + obj.getSubThoroughfare();
//
//            Log.v("IGA", "Address" + add);
//            // Toast.makeText(this, "Address=>" + add,
//            // Toast.LENGTH_SHORT).show();
//
//            // TennisAppActivity.showDialog(add);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//        return add;
//    }
}
