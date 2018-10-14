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

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.first_recyclerview);

        /*StaggeredGridLayoutManager是瀑布流布局，使用这个可以使RecyclerView有瀑布流布局的效果*/
        StaggeredGridLayoutManager layoutmanager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL); //第一个参数是每列空出三个字符，第二参数是规定打印方向
        recyclerView.setLayoutManager(layoutmanager);

        PeopleAdapter adapter = new PeopleAdapter(people);
        recyclerView.setAdapter(adapter);


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
