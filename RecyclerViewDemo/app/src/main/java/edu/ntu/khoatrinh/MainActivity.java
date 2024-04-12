package edu.ntu.khoatrinh;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewData;
    RecyclerView recyclerViewLandScape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerViewData = getDataForRecycleView();
        recyclerViewLandScape = findViewById(R.id.recyclerLand);
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layoutLinear);
        landScapeAdapter = new LandScapeAdapter(this, recyclerViewData);
        recyclerViewLandScape.setAdapter(landScapeAdapter);
    }
    ArrayList<LandScape> getDataForRecycleView() {
        ArrayList<LandScape> lData = new ArrayList<>();
        lData.add(new LandScape("ha_long_bay", "Vịnh Hạ Long"));
        lData.add(new LandScape("leaning_tower_of_pisa", "Tháp nghiêng Pisa"));
        lData.add(new LandScape("pyramid", "Kim Tự Tháp"));
        lData.add(new LandScape("statue_of_liberty", "Tượng Nữ thần Tự do"));
        lData.add(new LandScape("venice_city", "Thành phố Venice"));
        return lData;
    }
}