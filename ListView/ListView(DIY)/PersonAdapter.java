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
        Person p = (Person)getItem(position); //getItem方法可获得由构造函数拿到的数据
        /*
        * LayoutInflater中的inflate方法接收三种参数，其中最后一个参数是指只让我们在父布局声明的layout属性生效，但部位这个布局添加父布局
        * */
        View view = LayoutInflater.from(getContext()).inflate(this.resourceId,parent,false);
        ImageView img = (ImageView)view.findViewById(R.id.names_image);
        TextView txt = (TextView)view.findViewById(R.id.names_text);
        img.setImageResource(p.getImageId()); //设置图片
        txt.setText(p.getName()); //设置文本
        return view; //返回视图
    }
}
