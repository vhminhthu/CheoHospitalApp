package com.example.cheohospitalapp_nhom8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cheohospitalapp_nhom8.model.Benhnhan;
import com.example.cheohospitalapp_nhom8.sqlite.BenhnhanDAO;

public class DangkyActivity extends AppCompatActivity {

    private EditText edtTenBN, edtEmail, edtMatkhau;
    private Button btnDangKi, btnDangNhap;
    private BenhnhanDAO benhnhanDAO;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        // Initialize BenhnhanDAO
        benhnhanDAO = new BenhnhanDAO(this);

        // Initialize EditText and Buttons
        edtTenBN = findViewById(R.id.edttenbn);
        edtEmail = findViewById(R.id.edtemail);
        edtMatkhau = findViewById(R.id.edtmatkhau);
        btnDangKi = findViewById(R.id.btndangki);
        btnDangNhap = findViewById(R.id.btndangnhapbenhnhan);


        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input data from EditText fields
                String email = edtEmail.getText().toString().trim();
                String tenBN = edtTenBN.getText().toString().trim();
                String matKhau = edtMatkhau.getText().toString();


                if (tenBN.isEmpty() || email.isEmpty() || matKhau.isEmpty()) {
                    Toast.makeText(DangkyActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {

                    Benhnhan benhnhan = new Benhnhan();
                    benhnhan.setEmail(email);
                    benhnhan.setTenBN(tenBN);
                    benhnhan.setMatKhau(matKhau);


                    long result = benhnhanDAO.insert(benhnhan);


                    if (result > 0) {
                        Toast.makeText(DangkyActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(DangkyActivity.this, MainActivity.class);
                        startActivity(intent);


                        finish();
                    } else {
                        Toast.makeText(DangkyActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DangkyActivity.this, DangnhapActivity.class);
                startActivity(intent);
            }
        });
    }
}