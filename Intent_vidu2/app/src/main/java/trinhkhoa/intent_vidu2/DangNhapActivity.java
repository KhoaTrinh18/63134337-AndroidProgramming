package trinhkhoa.intent_vidu2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DangNhapActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword, edtEmail;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getControl();
    }

    public void getControl(){
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnOK = (Button) findViewById(R.id.btnOK);
    }

    public boolean checkEmail(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void dangNhap(View v){
        //Intent iHome = new Intent(this, HomeActivity.class);
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        String email = edtEmail.getText().toString();
        if(!username.equals("KhoaTrinh") || !password.equals("181123")){
            Toast.makeText(this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
            edtUsername.setText("");
            edtPassword.setText("");
        } else if(!checkEmail(email)){
            Toast.makeText(this, "Email không đúng định dạng", Toast.LENGTH_SHORT).show();
        } else {
            Intent iHome = new Intent(this, HomeActivity.class);
            iHome.putExtra("Username", username);
            startActivity(iHome);
        }
    }
}