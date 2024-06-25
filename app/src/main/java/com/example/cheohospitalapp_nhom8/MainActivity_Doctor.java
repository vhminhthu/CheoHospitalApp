package com.example.cheohospitalapp_nhom8;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.cheohospitalapp_nhom8.fragment.TaikhoanFragment_Doctor;
import com.example.cheohospitalapp_nhom8.fragment.ThongbaoFragment_Doctor;
import com.example.cheohospitalapp_nhom8.fragment.TrangchuFragment_Doctor;

import com.example.cheohospitalapp_nhom8.sqlite.TintucDAO;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.example.cheohospitalapp_nhom8.adapter.AdapterViewPaper_Doctor;

import java.util.ArrayList;

import javax.xml.transform.TransformerException;

public class MainActivity_Doctor extends AppCompatActivity {

    ViewPager2 pagerMain;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_doctor);

        pagerMain = findViewById(R.id.pagerMain);
        bottomNav = findViewById(R.id.bottomNav);

        fragmentArrayList.add(new TrangchuFragment_Doctor());
        fragmentArrayList.add(new ThongbaoFragment_Doctor());
        fragmentArrayList.add(new TaikhoanFragment_Doctor());

        AdapterViewPaper_Doctor adapterViewPager = new AdapterViewPaper_Doctor(this, fragmentArrayList);
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
                        bottomNav.setSelectedItemId(R.id.itThongbao);
                        break;
                    case 2:
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
                } else if (menuItem.getItemId() == R.id.itThongbao) {
                    pagerMain.setCurrentItem(1);
                } else if (menuItem.getItemId() == R.id.itTaikhoan) {
                    pagerMain.setCurrentItem(2);
                }
                return true;
            }
        });

    }
}