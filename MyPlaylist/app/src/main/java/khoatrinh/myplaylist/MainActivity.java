package khoatrinh.myplaylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> playList;
    ArrayAdapter<String> adapterPLayList;
    ListView listViewPLayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timDK();

        playList = new ArrayList<>();
        playList.add("Nơi này có anh");
        playList.add("Cơn mưa ngang qua");
        playList.add("Em xinh");
        playList.add("Không phải dạng vừa đâu");
        playList.add("Chúng ta của hiện tại");
        playList.add("Trốn tìm");

        adapterPLayList = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, playList);
        listViewPLayList.setAdapter(adapterPLayList);

        listViewPLayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strNoti = "Bạn chọn bài hát " + playList.get(position);
                Toast.makeText(MainActivity.this, strNoti, Toast.LENGTH_SHORT).show();
            }
        });
    }

    void timDK(){
        listViewPLayList = (ListView) findViewById(R.id.lvPlayList);
    }
}