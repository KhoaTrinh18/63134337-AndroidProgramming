package com.edu.ex5_addsubmuldiv_var;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextSo1;
    EditText editTextSo2;
    TextView textViewKQ;
    Button buttonCong;
    Button buttonTru;
    Button buttonNhan;
    Button buttonChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layDieuKhien();
        buttonCong.setOnClickListener(BoLangNghe_XyLyCong);
        buttonTru.setOnClickListener(BoLangNghe_XyLyTru);
        buttonNhan.setOnClickListener(BoLangNghe_XyLyNhan);
        buttonChia.setOnClickListener(BoLangNghe_XyLyChia);
    }

    private void layDieuKhien(){
        editTextSo1 = (EditText) findViewById(R.id.edtA);
        editTextSo2 = (EditText) findViewById(R.id.edtB);
        textViewKQ = (TextView) findViewById(R.id.txtKQ);
        buttonCong = (Button) findViewById(R.id.btnCong);
        buttonTru = (Button) findViewById(R.id.btnTru);
        buttonNhan = (Button) findViewById(R.id.btnNhan);
        buttonChia = (Button) findViewById(R.id.btnChia);
    }

    View.OnClickListener BoLangNghe_XyLyCong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int so1 = Integer.parseInt(editTextSo1.getText().toString());
            int so2 = Integer.parseInt(editTextSo2.getText().toString());
            int tong = so1 + so2;
            textViewKQ.setText(String.valueOf(tong));
        }
    };

    View.OnClickListener BoLangNghe_XyLyTru = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int so1 = Integer.parseInt(editTextSo1.getText().toString());
            int so2 = Integer.parseInt(editTextSo2.getText().toString());
            int hieu = so1 - so2;
            textViewKQ.setText(String.valueOf(hieu));
        }
    };

    View.OnClickListener BoLangNghe_XyLyNhan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int so1 = Integer.parseInt(editTextSo1.getText().toString());
            int so2 = Integer.parseInt(editTextSo2.getText().toString());
            int tich = so1 * so2;
            textViewKQ.setText(String.valueOf(tich));
        }
    };

    View.OnClickListener BoLangNghe_XyLyChia = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int so1 = Integer.parseInt(editTextSo1.getText().toString());
            int so2 = Integer.parseInt(editTextSo2.getText().toString());
            float thuong = (float)so1 / so2;
            textViewKQ.setText(String.valueOf(thuong));
        }
    };
}