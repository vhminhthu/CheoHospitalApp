package com.example.cheohospitalapp_nhom8;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.cheohospitalapp_nhom8.adapter.AdapterViewPaper;
import com.example.cheohospitalapp_nhom8.adapter.AdapterViewPaper_Doctor;
import com.example.cheohospitalapp_nhom8.fragment.HosoFragment;
import com.example.cheohospitalapp_nhom8.fragment.LichhenFragment;
import com.example.cheohospitalapp_nhom8.fragment.TaikhoanFragment;
import com.example.cheohospitalapp_nhom8.fragment.TaikhoanFragment_Doctor;
import com.example.cheohospitalapp_nhom8.fragment.ThongbaoFragment;
import com.example.cheohospitalapp_nhom8.fragment.ThongbaoFragment_Doctor;
import com.example.cheohospitalapp_nhom8.fragment.TrangchuFragment;
import com.example.cheohospitalapp_nhom8.fragment.TrangchuFragment_Doctor;
import com.example.cheohospitalapp_nhom8.sqlite.TintucDAO;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 pagerMain;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TintucDAO tintucDAO = new TintucDAO(this);
        tintucDAO.addInitialDataIfNotExists();

        pagerMain = findViewById(R.id.pagerMain);
        bottomNav = findViewById(R.id.bottomNav);

        // Lấy dữ liệu từ Intent (nếu có)
        Intent intent = getIntent();
        int maBN = intent.getIntExtra("MaBN", -1); // -1 là giá trị mặc định nếu không tìm thấy "MaBN" trong Intent

        fragmentArrayList.add(TrangchuFragment.newInstance(maBN));
        fragmentArrayList.add(new HosoFragment());
        fragmentArrayList.add(new LichhenFragment());
        fragmentArrayList.add(new ThongbaoFragment());
        fragmentArrayList.add(TaikhoanFragment.newInstance(maBN));

        AdapterViewPaper adapterViewPager = new AdapterViewPaper(this, fragmentArrayList);
        //set Adapter
        pagerMain.setAdapter(adapterViewPager);

        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNav.setSelectedItemId(R.id.itTrangchu);
                        break;
                    case 1:
                        bottomNav.setSelectedItemId(R.id.itHoso);
                        break;
                    case 2:
                        bottomNav.setSelectedItemId(R.id.itLichhen);
                        break;
                    case 3:
                        bottomNav.setSelectedItemId(R.id.itThongbao);
                        break;
                    case 4:
                        bottomNav.setSelectedItemId(R.id.itTaikhoan);
                        break;
                }
                super.onPageSelected(position);
            }
        });
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.itTrangchu) {
                    pagerMain.setCurrentItem(0);
                } else if (menuItem.getItemId() == R.id.itHoso) {
                    pagerMain.setCurrentItem(1);
                } else if (menuItem.getItemId() == R.id.itLichhen) {
                    pagerMain.setCurrentItem(2);
                } else if (menuItem.getItemId() == R.id.itThongbao) {
                    pagerMain.setCurrentItem(3);
                } else if (menuItem.getItemId() == R.id.itTaikhoan) {
                    pagerMain.setCurrentItem(4);
                }
                return true;
            }
        });
    }
}