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
        ViewHolder viewHolder;
        if(convertView==null){

            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)view.findViewById(R.id.names_image);
            viewHolder.textView = (TextView)view.findViewById(R.id.names_text);
            view.setTag(viewHolder);

        }else{

            view = convertView;
            viewHolder = (ViewHolder)view.getTag();

        }
        viewHolder.imageView.setImageResource(p.getImageId());
        viewHolder.textView.setText(p.getName());
        return view;
    }

    class ViewHolder{
        ImageView imageView;

        TextView textView;
    }
}
