package com.example.bin.hell3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter; //意图过滤器，这个有筛选广播action的作用
    private NetWorkChangeReceiver netWorkChangeReceiver; //自定义一个广播接收器，然后重写里面的onReceiver方法

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTITY_CHANGE"); //如果改变网络状态的话，系统会发出android.net.conn.CONNECTITY_CHANGE的广播
        registerReceiver(netWorkChangeReceiver,intentFilter); //注册接收器，第一个参数表明用什么样的接收器，第二个参数表明要接收什么样的广播
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkChangeReceiver); //注销接收器，不再使用指定的接收器
    }

    class NetWorkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "注意，你现在正在使用网络", Toast.LENGTH_SHORT).show();
        }
    }
}
