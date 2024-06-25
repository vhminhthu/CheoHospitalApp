package com.example.cheohospitalapp_nhom8.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cheohospitalapp_nhom8.R;
import com.example.cheohospitalapp_nhom8.TaikhoanCapnhatActivity;
import com.example.cheohospitalapp_nhom8.sqlite.BenhnhanDAO;

public class TaikhoanFragment extends Fragment {
    private TextView tvtenbn;
    private TextView tvemailbn;
    private BenhnhanDAO benhnhanDAO;
    private int maBN;
    private static final String ARG_MA_BN = "maBN";

    public TaikhoanFragment() {
        // Required empty public constructor
    }

    public static TaikhoanFragment newInstance(int maBN) {
        TaikhoanFragment fragment = new TaikhoanFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_MA_BN, maBN);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            maBN = getArguments().getInt(ARG_MA_BN, -1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_taikhoan, container, false);

        tvtenbn = view.findViewById(R.id.tvtenbn);
        tvemailbn = view.findViewById(R.id.tvemailbn);

        benhnhanDAO = new BenhnhanDAO(requireContext());
        displayBenhNhanInfo();

        // Button cập nhật tài khoản
        view.findViewById(R.id.btnhosonguoidung).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCapNhatTaiKhoanButtonClick();
            }
        });

        return view;
    }

    private void displayBenhNhanInfo() {
        String tenBN = benhnhanDAO.getTenBNByMaBN(maBN);
        String email = benhnhanDAO.getEmailByMaBN(maBN);

        if (tenBN != null) {
            tvtenbn.setText(tenBN);
            tvemailbn.setText(email);
        } else {
            tvtenbn.setText("Không tìm thấy");
            tvemailbn.setText("Không tìm thấy");
        }
    }

    private void onCapNhatTaiKhoanButtonClick() {
        Intent intent = new Intent(requireActivity(), TaikhoanCapnhatActivity.class);
        intent.putExtra("MaBN", maBN);
        intent.putExtra("TenBN", tvtenbn.getText().toString());
        intent.putExtra("Email", tvemailbn.getText().toString());
        startActivityForResult(intent, 1);
    }

    // Xử lý khi activity CapNhatTaiKhoan trả về kết quả
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String tenBNMoi = data.getStringExtra("TenBNMoi");
                String emailMoi = data.getStringExtra("EmailMoi");

                if (tenBNMoi != null && emailMoi != null) {
                    tvtenbn.setText(tenBNMoi);
                    tvemailbn.setText(emailMoi);
                }
            }
        }
    }
}
