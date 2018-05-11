package com.example.mystylezxcamera;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button btn_scanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_scanner= findViewById(R.id.btn_scanner);
        btn_scanner.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_scanner:  //扫一扫
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED){
                    //权限还没有授予 ，需要这里写申请权限的代码
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CAMERA},60);
                }else{  //权限授予，直接写要执行的相应方法


                }

                break;
        }
    }
}
