package thi.khoa_63134337.demobaithi;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_space, new HomeFragment()).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            int itemId = menuItem.getItemId();
            if (itemId == R.id.home) {
                selectedFragment = new HomeFragment();
            }else if (itemId == R.id.cau1) {
                selectedFragment = new Cau1Fragment();
            } else if (itemId == R.id.cau2) {
                selectedFragment = new Cau2Fragment();
            } else if (itemId == R.id.cau3) {
                selectedFragment = new Cau3Fragment();
            } else if (itemId == R.id.cau4) {
                selectedFragment = new Cau4Fragment();
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_space, selectedFragment).commit();
                return true;
            }
            return false;
        }
    };
}