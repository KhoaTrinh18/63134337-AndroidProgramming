package edu.ntu.ex_recyclerview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageGalleryAdapter2 adapter;
    RecyclerView recyclerView;
    ClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<ExamData> list = new ArrayList<>();
        list = getData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listener = new ClickListener() {
            @Override
            public void click(int index) {
                Toast.makeText(MainActivity.this, "clicked item index is " + index, Toast.LENGTH_LONG).show();
            }
        };
        adapter = new ImageGalleryAdapter2(list, getApplicationContext(), listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private ArrayList<ExamData> getData(){
        ArrayList<ExamData> list = new ArrayList<>();
        list.add(new ExamData("First Exam", "May 23, 2015", "Best Of Luck"));
        list.add(new ExamData("Second Exam", "June 09, 2015", "b of l"));
        list.add(new ExamData("My Test Exam", "April 27, 2017", "This is testing exam .."));
        return list;
    }
}