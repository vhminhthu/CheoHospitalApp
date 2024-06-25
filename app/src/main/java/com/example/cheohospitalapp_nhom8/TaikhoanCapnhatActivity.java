package com.example.cheohospitalapp_nhom8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cheohospitalapp_nhom8.model.Benhnhan;
import com.example.cheohospitalapp_nhom8.sqlite.BenhnhanDAO;

public class TaikhoanCapnhatActivity extends AppCompatActivity {

    private EditText edttenBN;
    private EditText edtEmail;
    private Button btnCapNhat;
    private int maBN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taikhoan_capnhat);

        edttenBN = findViewById(R.id.edttenBN);
        edtEmail = findViewById(R.id.edtEmail);
        btnCapNhat = findViewById(R.id.btnCapNhat);


        Intent intent = getIntent();
        if (intent != null) {
            maBN = intent.getIntExtra("MaBN", -1);
            String tenBN = intent.getStringExtra("TenBN");
            String email = intent.getStringExtra("Email");

            edttenBN.setText(tenBN);
            edtEmail.setText(email);
        }


        btnCapNhat.setOnClickListener(view -> {
            // Lấy dữ liệu mới từ EditText
            String tenBNMoi = edttenBN.getText().toString().trim();
            String emailMoi = edtEmail.getText().toString().trim();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("MaBN", maBN);
            resultIntent.putExtra("TenBNMoi", tenBNMoi);
            resultIntent.putExtra("EmailMoi", emailMoi);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}