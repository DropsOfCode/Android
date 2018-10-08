package com.example.a01.androidtest;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class FileSavaQQ {
    public static  boolean setInfomation(Context context,String number,String password){
        try{
            FileOutputStream fos = context.openFileOutput("data.txt",Context.MODE_PRIVATE);
            fos.write((number+":"+password).getBytes());
            fos.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static Map<String,String> getInfomation(Context context){
        String str = null;
        try{
            FileInputStream fis = context.openFileInput("data.txt");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            str = new String(buffer);
            String[] datas = str.split(":");
            Map<String,String> infos = new HashMap<String,String>();
            infos.put("number",datas[0]);
            infos.put("password",datas[1]);
            fis.close();
            return infos;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
