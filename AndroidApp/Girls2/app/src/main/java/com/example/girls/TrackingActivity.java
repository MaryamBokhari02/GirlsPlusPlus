package com.example.girls;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

import androidx.core.content.ContextCompat;

public class TrackingActivity extends Service implements LocationListener {
    private final Context context;

    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;

    Location location;
    protected LocationManager locationManager;

    public TrackingActivity(Context context){
        this.context=context;
    }

    //Create a GetLocation Method
    public Location getLocation(){
        try{
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);
            isNetworkEnabled=locationManager.isProviderEnabled(locationManager.NETWORK_PROVIDER);

            if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                if(isGPSEnabled){
                    if(location==null){
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this);
                        if(locationManager!=null){
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        }
                    }
                }
                //if location is not found from GPS than it will found from network
                if(location==null){
                    if(isNetworkEnabled){
                        if(location==null){
                            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 10, this);
                            if(locationManager!=null){
                                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex){

        }
        return location;
    }
    //followings are the default method if we implement LocationListener
    public void onLocationChanged(Location location){

    }

    public void onStatusChanged(String Provider, int status, Bundle extras){

    }

    public void onProviderEnabled(String Provider){

    }

    public void onProviderDisabled(String Provider){

    }

    public IBinder onBind(Intent arg0){
        return null;
    }
}
