package ntu.mssv63134337;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class Quiz extends AppCompatActivity {
    TextView question;
    ArrayList<Button> options = new ArrayList<>();
    CountDownTimer countDownTimer;
    Button btnNext;
    Button correctOption;
    Boolean checkPress = false;
    Boolean checkCorrect = false;
    TextView count;
    Button btnBack;
    int numCount = 1;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        getControl();
        quiz();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quiz();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStop();
                Intent myIntent = new Intent(Quiz.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        for(final Button o : options) {
            o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!checkPress) {
                        if (o == correctOption) {
                            Drawable drawable = getResources().getDrawable(R.drawable.option_correct);
                            o.setBackground(drawable);
                            score++;
                        } else {
                            Drawable drawableWrong = getResources().getDrawable(R.drawable.option_wrong);
                            o.setBackground(drawableWrong);
                            for (Button o : options) {
                                if (o == correctOption) {
                                    Drawable drawableCorrect = getResources().getDrawable(R.drawable.option_correct);
                                    o.setBackground(drawableCorrect);
                                }
                            }
                        }
                        checkPress = true;
                    }
                }
            });
            break;
        }
    }

    public void getControl(){
        question = (TextView) findViewById(R.id.question);
        options.add((Button) findViewById(R.id.option1));
        options.add((Button) findViewById(R.id.option2));
        options.add((Button) findViewById(R.id.option3));
        options.add((Button) findViewById(R.id.option4));
        btnNext = (Button) findViewById(R.id.btn_next);
        count = (TextView) findViewById(R.id.count);
        btnBack = (Button) findViewById(R.id.btn_back);
    }

    public void quiz(){
        if(numCount <= 10){
            if(numCount == 10){
                btnNext.setText("Finish");
            }
            count.setText(String.valueOf(numCount + " / 10" ));
            numCount++;
        }else{
            Intent myIntent = new Intent(Quiz.this, Result.class);
            myIntent.putExtra("Score", score);
            startActivity(myIntent);
        }
        checkPress = false;
        for(Button o : options){
            Drawable drawable = getResources().getDrawable(R.drawable.option_normal);
            o.setBackground(drawable);
        }
        Random random = new Random();
        char[] operators = {'+', '-', 'x', '÷'};
        int a = random.nextInt(100) + 1;
        int b = random.nextInt(100) + 1;
        char operator = operators[random.nextInt(operators.length)];
        correctOption = options.get(random.nextInt(options.size() - 1));
        switch (operator){
            case '+':
                for(Button o : options){
                    if(o == correctOption) {
                        o.setText(String.valueOf(a + b));
                        continue;
                    }
                    int randomNum = random.nextInt(100) + 1;
                    o.setText(String.valueOf(randomNum));
                }
                break;
            case '-':
                correctOption.setText(String.valueOf(a - b));
                for(Button o : options){
                    if(o == correctOption) {
                        o.setText(String.valueOf(a - b));
                        continue;
                    }
                    int randomNum = random.nextInt(100) + 1;
                    o.setText(String.valueOf(randomNum));
                }
                break;
            case 'x':
                for(Button o : options){
                    if(o == correctOption) {
                        o.setText(String.valueOf(a * b));
                        continue;
                    }
                    int randomNum = random.nextInt(100) + 1;
                    o.setText(String.valueOf(randomNum));
                }
                break;
            case '÷':
                a = b * (random.nextInt(100) + 1);
                for(Button o : options){
                    if(o == correctOption) {
                        o.setText(String.valueOf(a / b));
                        continue;
                    }
                    int randomNum = random.nextInt(100) + 1;
                    o.setText(String.valueOf(randomNum));
                }
                break;
        }
        question.setText(a + " " + String.valueOf(operator) + " " + b + " = ?");
    }
}
