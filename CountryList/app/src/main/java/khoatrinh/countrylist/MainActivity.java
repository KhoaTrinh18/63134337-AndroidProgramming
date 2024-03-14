package khoatrinh.countrylist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[] listFlagId = new int[]{R.drawable.vietnam, R.drawable.brunei, R.drawable.campuchia, R.drawable.lao, R.drawable.myanmmar, R.drawable.thailan};
    String[] listCountry = new String[]{"Việt Nam", "Bruiney", "Campuchia", "Lào", "Myanmar", "Thái lan"};
    int[] listPop = new int[]{99307144, 454864, 17069228, 7705995, 54849677, 71860608};
    ArrayList<Country> myList;
    MyArrayAdapter myArrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        myList = new ArrayList<>();
        for (int i = 0; i < listCountry.length; i++) {
            myList.add(new Country(listCountry[i], listFlagId[i], listPop[i]));

        }
        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.list_country, myList);
        listView.setAdapter(myArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CountryActivity.class);
                intent.putExtra("countryName", listCountry[position]);
                intent.putExtra("flagId", listFlagId[position]);
                intent.putExtra("population", listPop[position]);
                startActivity(intent);
            }
        });
    }
}