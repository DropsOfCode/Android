package com.example.bin.hell3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();
        /*系统网络状态发生变化时，系统发出的是android.net.conn.CONNECTIVITY_CHANGE的广播
        * 要监听什么样的广播，就要添加相应的action*/
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        networkChangeReceiver = new NetworkChangeReceiver();
        /*注册广播，第一个参数是要接收的接收器，第二个参数是指要监听的内容*/
        registerReceiver(networkChangeReceiver,intentFilter);
    }


    /*
    * 动态注册的广播一定都要取消注册，取消注册采用unregisterReceiver方法
    * */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            /*
            * ConnectivityManager是专门管理网络的一个类
            * ConnectivityManager是可以通过getSystemService获得相应的实例，获得的条件是getSystemService参数设置为CONNECTIVITY_SERVICE
            * */
            ConnectivityManager connectionManager =  (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo(); //之后通过NetworkInfo来获得系统网络的信息（要注意去Manifest去开启权限）
            if(networkInfo!=null&&networkInfo.isAvailable()){ //当不为空且信息可用时
                Toast.makeText(context, "Network is working", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Network is shut down", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
