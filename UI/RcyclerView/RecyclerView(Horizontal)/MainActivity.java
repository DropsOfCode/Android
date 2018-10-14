package com.example.bin.hell2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> people = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        init();
        /*
        * ListView 是自己处理布局排列的
        * 但是RecyclerView得交由LinearLayoutManager来处理*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        PeopleAdapter adapter = new PeopleAdapter(people);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.first_recyclerview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void init(){
        for(int i=0;i<2;i++){
            Person p = new Person("Mike",R.mipmap.ic_launcher_round);
            people.add(p);
            p = new Person("John",R.mipmap.ic_launcher_round);
            people.add(p);
            p = new Person("Halen",R.mipmap.ic_launcher_round);
            people.add(p);
            p = new Person("Taylor",R.mipmap.ic_launcher_round);
            people.add(p);
            p = new Person("Michacle",R.mipmap.ic_launcher_round);
            people.add(p);
            p = new Person("Billy",R.mipmap.ic_launcher_round);
            people.add(p);
        }
    }
}
