package com.example.bin.hell;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> fruits = new ArrayList<Fruit>();

    //新建一个静态内部类
    static class ViewHolder  extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.fruit_imageView);
            textView = (TextView)itemView.findViewById(R.id.fruit_testview);
        }
    }

    //在构造函数中导入数据
    public FruitAdapter(List<Fruit> fruits){
        this.fruits = fruits;
    }

    //载入布局，新建ViewHolder实例导入布局，返回ViewHolder实例
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    //将数据导入到布局的每一个子项中，显示出来
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit f = fruits.get(position);
        holder.imageView.setImageResource(f.getImageId());
        holder.textView.setText(f.getName());
    }

    //获得集合的长度
    @Override
    public int getItemCount() {
        return fruits.size();
    }
}