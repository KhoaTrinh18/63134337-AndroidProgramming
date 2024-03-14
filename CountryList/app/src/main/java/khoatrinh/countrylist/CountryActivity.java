package khoatrinh.countrylist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class CountryActivity extends AppCompatActivity {
    ImageView subFlagImg;
    TextView txtSubCountry, txtSubPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        subFlagImg = (ImageView) findViewById(R.id.subFlagImg);
        txtSubCountry = (TextView) findViewById(R.id.txtSubCountry);
        txtSubPop = (TextView) findViewById(R.id.txtSubPop);
        Intent intent = getIntent();
        String nameCountry = intent.getStringExtra("countryName");
        int flagId = intent.getIntExtra("flagId", 0);
        int population = intent.getIntExtra("population", 0);
        subFlagImg.setImageResource(flagId);
        txtSubCountry.setText(nameCountry);
        txtSubPop.setText("Population: " + population);
    }
}