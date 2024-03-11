package com.edu.ex_6cong_listviewthemxoasua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvSong;
    EditText edtSong, edtPos;
    Button btnAdd, btnDel, btnEdit;
    ArrayList<String> listSong;
    ArrayAdapter<String> adapter;
    int current_pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControl();
        listSong = new ArrayList<>();
        listSong.add("Nơi này có anh");
        listSong.add("Cơn mưa ngang qua");
        listSong.add("Em xinh");
        listSong.add("Không phải dạng vừa đâu");
        listSong.add("Chúng ta của hiện tại");
        listSong.add("Trốn tìm");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, listSong);

        lvSong.setAdapter(adapter);

        //Xu ly khi nhan vao tung item trong listview
        lvSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String song = listSong.get(position);
                edtSong.setText(song);
                edtPos.setText(String.valueOf(position + 1));
                current_pos = position;
                Toast.makeText(MainActivity.this, song, Toast.LENGTH_SHORT).show();
            }
        });

        //Xu ly nut them
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        //Xu ly nut xoa
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        //Xu ly nut sua
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });
    }

    void add() {
        String newSong = edtSong.getText().toString();
        int pos;
        if (newSong.equals("")) {
            Toast.makeText(MainActivity.this, "Cần nhập tên bài hát", Toast.LENGTH_SHORT).show();
            edtSong.requestFocus();
            return;
        }
        for(String s : listSong){
            if(newSong.equalsIgnoreCase(s)){
                Toast.makeText(MainActivity.this, "Đã có bài hát trong danh sách", Toast.LENGTH_SHORT).show();
                edtSong.selectAll();
                edtSong.requestFocus();
                return;
            }
        }
        try {
            pos = Integer.parseInt(edtPos.getText().toString());
            if (pos >= listSong.size() || pos <= 0) {
                listSong.add(newSong);
            } else {
                listSong.add(pos - 1, newSong);
            }
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Thêm bài hát " + newSong + " thành công", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            listSong.add(newSong);
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Thêm bài hát " + newSong + " thành công", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    void delete() {
        String song = edtSong.getText().toString();
        if (song.equals("")) {
            Toast.makeText(MainActivity.this, "Cần nhập tên bài hát", Toast.LENGTH_SHORT).show();
            edtSong.requestFocus();
            return;
        }
        for (String s : listSong) {
            if (song.equalsIgnoreCase(s)) {
                listSong.remove(s);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Xóa bài hát " + song + " thành công", Toast.LENGTH_SHORT).show();
                edtSong.setText("");
                edtPos.setText("");
                return;
            }
        }
        Toast.makeText(MainActivity.this, "Không tìm thấy tên bài hát để xóa", Toast.LENGTH_SHORT).show();
    }

    void edit(){
        String song = edtSong.getText().toString();
        int pos;
        try{
            pos = Integer.parseInt(edtPos.getText().toString());
            if(pos >= listSong.size() || pos <= 0){
                String temp = listSong.get(listSong.size() - 1);
                listSong.set(listSong.size() - 1, song);
                listSong.set(current_pos, temp);
            }else{
                if((pos - 1) == current_pos){
                    listSong.set(pos - 1, song);
                }else{
                    String temp = listSong.get(pos - 1);
                    listSong.set(pos - 1, song);
                    listSong.set(current_pos, temp);

                }
            }
            edtSong.setText("");
            edtPos.setText("");
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Sửa bài hát " + song + " thành công", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            String temp = listSong.get(listSong.size() - 1);
            listSong.set(listSong.size() - 1, song);
            listSong.set(current_pos, temp);
            edtSong.setText("");
            edtPos.setText("");
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Sửa bài hát " + song + " thành công", Toast.LENGTH_SHORT).show();
        }
    }

    void getControl() {
        lvSong = (ListView) findViewById(R.id.lvSong);
        edtSong = (EditText) findViewById(R.id.edtSong);
        edtPos = (EditText) findViewById(R.id.edtPos);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnEdit = (Button) findViewById(R.id.btnEdit);
    }
}