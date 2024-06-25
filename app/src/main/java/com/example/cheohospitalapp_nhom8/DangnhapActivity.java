package com.example.cheohospitalapp_nhom8;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cheohospitalapp_nhom8.fragment.TaikhoanFragment;
import com.example.cheohospitalapp_nhom8.model.Benhnhan;
import com.example.cheohospitalapp_nhom8.sqlite.BenhnhanDAO;

public class DangnhapActivity extends AppCompatActivity {

    private EditText edtemail;
    private EditText edtmatkhau;
    private BenhnhanDAO benhnhanDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        // Khởi tạo BenhnhanDAO
        benhnhanDAO = new BenhnhanDAO(this);

        edtemail = findViewById(R.id.edtemail);
        edtmatkhau = findViewById(R.id.edtmatkhauBN);
    }


    public void onDangNhapButtonClick(View view) {
        String email = edtemail.getText().toString().trim();
        String password = edtmatkhau.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ email và mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!benhnhanDAO.checkEmailExists(email)) {
            Toast.makeText(this, "Email không tồn tại", Toast.LENGTH_SHORT).show();
            return;
        }

        Benhnhan benhnhan = benhnhanDAO.getByEmailAndPassword(email, password);

        if (benhnhan != null) {
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("MaBN", benhnhan.getMaBN());
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Sai email hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }
    }

    public void onDangKyButtonClick(View view) {
        Intent intent = new Intent(this, DangkyActivity.class);
        startActivity(intent);
    }


    public void onDangNhapBacSiButtonClick(View view) {
        Intent intent = new Intent(this, DangnhapActivity_Doctor.class);
        startActivity(intent);
    }
}