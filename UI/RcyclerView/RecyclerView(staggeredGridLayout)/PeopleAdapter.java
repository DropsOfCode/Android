package com.example.bin.hell2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {
    private List<Person> people = new ArrayList<Person>();

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        ImageView imageView;
        TextView textView;

        public ViewHolder(View view){
            super(view);
            this.view = view;
            imageView = (ImageView)view.findViewById(R.id.person_item_imageView);
            textView = (TextView)view.findViewById(R.id.person_item_textView);
        }
    }

    public PeopleAdapter(List<Person> people){
        this.people = people;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Person p = people.get(position);
                Toast.makeText(view.getContext(),"you've clicked the image of "+p.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position  = holder.getAdapterPosition();
                Person p = people.get(position);
                Toast.makeText(view.getContext(), "you've clicked the view of "+p.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person p = people.get(position);
        holder.imageView.setImageResource(p.getImageId());
        holder.textView.setText(p.getName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
