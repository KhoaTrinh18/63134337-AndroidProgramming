package com.edu.ex4_addsubmuldiv_onclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        editTextSo2 = (EditText) findViewById(R.id.edtSo2);
        editTextKQ = (EditText) findViewById(R.id.edtKQ);
    }

    public void XuLyCong(View view){
        int so1 = Integer.parseInt(editTextSo1.getText().toString());
        int so2 = Integer.parseInt(editTextSo2.getText().toString());
        int tong = so1 + so2;
        editTextKQ.setText(String.valueOf(tong));
    }

    public void XuLyTru(View view){
        int so1 = Integer.parseInt(editTextSo1.getText().toString());
        int so2 = Integer.parseInt(editTextSo2.getText().toString());
        int hieu = so1 - so2;
        editTextKQ.setText(String.valueOf(hieu));
    }

    public void XuLyNhan(View view){
        int so1 = Integer.parseInt(editTextSo1.getText().toString());
        int so2 = Integer.parseInt(editTextSo2.getText().toString());
        int tich = so1 * so2;
        editTextKQ.setText(String.valueOf(tich));
    }

    public void XuLyChia(View view){
        int so1 = Integer.parseInt(editTextSo1.getText().toString());
        int so2 = Integer.parseInt(editTextSo2.getText().toString());
        float thuong = (float)so1 / so2;
        editTextKQ.setText(String.valueOf(thuong));
    }
}