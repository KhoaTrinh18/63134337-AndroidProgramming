package com.edu.ex3_simplesumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tinhCong(View view){
        //Lấy đối tượng edit text
        EditText a = (EditText) findViewById(R.id.edtA);
        EditText b = (EditText) findViewById(R.id.edtB);
        EditText kq = (EditText) findViewById(R.id.edtKQ);

        //Lấy dữ liệu từ edit text
        int soA = Integer.parseInt(a.getText().toString());
        int soB = Integer.parseInt(b.getText().toString());

        //Cộng 2 số a,
        int tong = soA + soB;
        String strTong = String.valueOf(tong);

        //Hiển thị dữ liệu lên edit text kết quà
        kq.setText(strTong);
    }
}