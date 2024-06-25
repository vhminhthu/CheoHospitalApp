package com.example.cheohospitalapp_nhom8;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cheohospitalapp_nhom8.model.Tintuc;
import com.example.cheohospitalapp_nhom8.sqlite.TintucDAO;

public class TintucChitietActivity_Doctor extends AppCompatActivity {

    private Context context;
    TextView tvTD,tvNoidung;
    ImageView image;
    CardView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tintuc_chitiet_doctor);
        tvTD = findViewById(R.id.tvTieude);
        tvNoidung = findViewById(R.id.tvNoidung);
        image = findViewById(R.id.imageHinh);

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TintucChitietActivity_Doctor.this, MainActivity_Doctor.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        readTỉntuc();
    }

    private void readTỉntuc(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if(bundle==null){
            return;
        }
        String id = bundle.getString("id");
        TintucDAO dao = new TintucDAO(this);
        Tintuc emp = dao.getById(id);

        tvTD.setText(emp.getTieuDe());
        tvNoidung.setText(emp.getNoiDung());
        String hinhAnh = emp.getHinhAnh();

        int resId = getResources().getIdentifier(hinhAnh, "drawable", getPackageName());
        image.setImageResource(resId);
    }
}