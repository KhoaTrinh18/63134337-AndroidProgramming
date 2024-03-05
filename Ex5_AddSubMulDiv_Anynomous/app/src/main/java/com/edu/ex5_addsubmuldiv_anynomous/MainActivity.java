package com.edu.ex5_addsubmuldiv_anynomous;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button buttonCong;
    Button buttonTru;
    Button buttonNhan;
    Button buttonChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layDieuKhien();
        buttonCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyCong(v);
            }
        });

        buttonTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyTru(v);
            }
        });

        buttonNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNhan(v);
            }
        });

        buttonChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChia(v);
            }
        });
    }

    private void layDieuKhien(){
        editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        editTextSo2 = (EditText) findViewById(R.id.edtSo2);
        editTextKQ = (EditText) findViewById(R.id.edtKQ);
        buttonCong = (Button) findViewById(R.id.btnCong);
        buttonTru = (Button) findViewById(R.id.btnTru);
        buttonNhan = (Button) findViewById(R.id.btnNhan);
        buttonChia = (Button) findViewById(R.id.btnChia);
    }

    public void xuLyCong(View view){
        int so1 = Integer.parseInt(editTextSo1.getText().toString());
        int so2 = Integer.parseInt(editTextSo2.getText().toString());
        int tong = so1 + so2;
        editTextKQ.setText(String.valueOf(tong));
    }

    public void xuLyTru(View view){
        int so1 = Integer.parseInt(editTextSo1.getText().toString());
        int so2 = Integer.parseInt(editTextSo2.getText().toString());
        int hieu = so1 - so2;
        editTextKQ.setText(String.valueOf(hieu));
    }

    public void xuLyNhan(View view){
        int so1 = Integer.parseInt(editTextSo1.getText().toString());
        int so2 = Integer.parseInt(editTextSo2.getText().toString());
        int tich = so1 * so2;
        editTextKQ.setText(String.valueOf(tich));
    }

    public void xuLyChia(View view){
        int so1 = Integer.parseInt(editTextSo1.getText().toString());
        int so2 = Integer.parseInt(editTextSo2.getText().toString());
        float thuong = (float)so1 / so2;
        editTextKQ.setText(String.valueOf(thuong));
    }
}