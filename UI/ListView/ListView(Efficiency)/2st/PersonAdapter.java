package com.example.bin.hell1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends ArrayAdapter {
    private int resourceId;

    //重写构造函数，将resourceId引进来
    public PersonAdapter(Context context,int resourceId,List<Person> people){
        super(context,resourceId,people);
        this.resourceId = resourceId;
    }

    //重写getView方法
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Person p = (Person)getItem(position);
        View view;
        if(convertView == null){ //如果先前的convertView为空的话，则加载布局

            view = LayoutInflater.from(getContext()).inflate(this.resourceId,parent,false);


        }else{

            view = convertView; //如果先前已经加载了布局了话，直接引用加载过的布局，这样做效率更高s

        }
        ImageView imagevIew = (ImageView)view.findViewById(R.id.names_image);
        TextView textView = (TextView)view.findViewById(R.id.names_text);
        imagevIew.setImageResource(p.getImageId());
        textView.setText(p.getName());
        return view;
    }
}
