package com.sorapp.run_time_permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Request For User
        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},200);
    }


    //Response From User Start
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if(requestCode==200)
        {
            boolean check = true;
            for (int i = 0; i < grantResults.length; i++)
            {
                if (PackageManager.PERMISSION_DENIED==grantResults[i])
                {
                    check=false;
                }
            }

            if(check)
            {
                Log.i("Errt","Permissions is OK");
            }
            else
            {
                Log.i("Errt","Permissions is Not OK");
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    //Response From User End


}