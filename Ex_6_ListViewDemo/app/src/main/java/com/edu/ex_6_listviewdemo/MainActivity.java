package com.edu.ex_6_listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> DSTinh;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timDK();
        DSTinh = new ArrayList<>();
        DSTinh.add("Khánh Hòa");
        DSTinh.add("Thanh Hóa");
        DSTinh.add("Quảng Nam");
        DSTinh.add("Lâm Đồng");
        DSTinh.add("Bình Định");
        DSTinh.add("Phú Yên");
        DSTinh.add("Ninh Thuận");
        DSTinh.add("Bình Thuận");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, DSTinh);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tenTinh = DSTinh.get(position);
                Toast.makeText(MainActivity.this, "Bạn vừa chọn " + tenTinh, Toast.LENGTH_SHORT).show();
            }
        });
    }

    void timDK(){
        lv = (ListView) findViewById(R.id.listView);
    }
}