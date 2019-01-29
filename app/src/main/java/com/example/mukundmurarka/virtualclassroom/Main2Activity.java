package com.example.mukundmurarka.virtualclassroom;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
     Button chating , vedio, notes, contact, button;
   // private Object Context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        chating=findViewById(R.id.cht);
        vedio=findViewById(R.id.vdo);
        notes=findViewById(R.id.note);
        contact=findViewById(R.id.cont);
        button=findViewById(R.id.button5);



        if (!isConnected(Main2Activity.this)) buildDialog(Main2Activity.this).show();
        else {
            Toast.makeText(Main2Activity.this, "Welcome", Toast.LENGTH_SHORT).show();
        }
        }


        public boolean isConnected (Context context){

            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netinfo = cm.getActiveNetworkInfo();

            if ( netinfo != null){
                android.net.NetworkInfo wifi=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
               // android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

                if ( (mobile != null & mobile.isConnectedOrConnecting()) ||(wifi != null & wifi.isConnectedOrConnecting()))
                {
                    return true;
                }
        else {
                    return false;
                }

            } else
            return false;
        }

        public AlertDialog.Builder buildDialog (Context c){

            AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setTitle("No Internet Connection");
            builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            });

            return builder;
        }








        }

