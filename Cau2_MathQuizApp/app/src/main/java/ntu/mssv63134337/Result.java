package ntu.mssv63134337;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {
    TextView score;
    Button btnBackMain;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        getControl();
        Intent myIntent = getIntent();
        int numScore = myIntent.getIntExtra("Score", 0);
        score.setText(String.valueOf(numScore) + " / 10");
        btnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Result.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Result.this, Quiz.class);
                startActivity(myIntent);
            }
        });
    }

    public void getControl(){
        score = (TextView) findViewById(R.id.score);
        btnBackMain = (Button) findViewById(R.id.btn_back_main);
        btnContinue = (Button) findViewById(R.id.btn_continue);
    }
}