package com.example.bin.hell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruits = new ArrayList<Fruit>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        init();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        FruitAdapter adapter = new FruitAdapter(fruits);
        RecyclerView listView = (RecyclerView)findViewById(R.id.recyclerview);
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);
    }

    public void init(){
        for(int i=0;i<2;i++){
            Fruit f = new Fruit("Mike",R.mipmap.ic_launcher_round);
            fruits.add(f);
            f = new Fruit("John",R.mipmap.ic_launcher_round);
            fruits.add(f);
            f = new Fruit("Halen",R.mipmap.ic_launcher_round);
            fruits.add(f);
            f = new Fruit("Taylor",R.mipmap.ic_launcher_round);
            fruits.add(f);
            f = new Fruit("Michacle",R.mipmap.ic_launcher_round);
            fruits.add(f);
            f = new Fruit("Billy",R.mipmap.ic_launcher_round);
            fruits.add(f);
        }
    }
}
