package com.hypech.case16_listview_simple_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String[] names = new String[]{"Megan Fox", "Scarlett Johansson", "Jessica Alba", "Charlize Theron", "Kate Upton", "Natalie Portman", "Mila Kunis", "Adriana Lima", "Gabriel Union","Selena Gomez"};
    int[]   images = new int[]{R.mipmap.megan, R.mipmap.scarlett, R.mipmap.jessica, R.mipmap.charlie, R.mipmap.kate, R.mipmap.natalie, R.mipmap.mila, R.mipmap.adrinana, R.mipmap.gabrille, R.mipmap.sellina};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("text", names[i]);
            map.put("image", images[i]);
            lists.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lists, R.layout.item,
                new String[]{"text", "image"}, new int[]{R.id.text, R.id.image});

        ListView list = findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toastCenter = Toast.makeText(getApplicationContext(), names[position], Toast.LENGTH_SHORT);
                toastCenter.show();
            }
        });
    }
}
