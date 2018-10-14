package com.example.bin.hell1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Person> names = new ArrayList<Person>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        init();
        PersonAdapter adapter = new PersonAdapter(this,R.layout.names_item,names);
        ListView listView = (ListView)findViewById(R.id.first_list_view1);
        listView.setAdapter(adapter);

        /*ListView中的点击事件*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Person p = names.get(i);
                Toast.makeText(MainActivity.this, p.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void init(){
        for(int i=0;i<2;i++){
            Person p = new Person("Mike",R.mipmap.ic_launcher_round);
            names.add(p);
            p = new Person("John",R.mipmap.ic_launcher_round);
            names.add(p);
            p = new Person("Uzi",R.mipmap.ic_launcher_round);
            names.add(p);
            p = new Person("XiaoHu",R.mipmap.ic_launcher_round);
            names.add(p);
            p = new Person("Karsa",R.mipmap.ic_launcher_round);
            names.add(p);
            p = new Person("Ming",R.mipmap.ic_launcher_round);
            names.add(p);
            p = new Person("LetMe",R.mipmap.ic_launcher_round);
            names.add(p);
        }
    }
}
