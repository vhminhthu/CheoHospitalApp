package com.example.cheohospitalapp_nhom8.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cheohospitalapp_nhom8.ChonbacsiActivity;
import com.example.cheohospitalapp_nhom8.ChonchuyenkhoaActivity;
import com.example.cheohospitalapp_nhom8.HuongdanActivity;
import com.example.cheohospitalapp_nhom8.R;
import com.example.cheohospitalapp_nhom8.TaikhoanCapnhatActivity;
import com.example.cheohospitalapp_nhom8.TintucChitietActivity;
import com.example.cheohospitalapp_nhom8.adapter.TintucAdapter;
import com.example.cheohospitalapp_nhom8.model.Benhnhan;
import com.example.cheohospitalapp_nhom8.model.Tintuc;
import com.example.cheohospitalapp_nhom8.sqlite.BenhnhanDAO;
import com.example.cheohospitalapp_nhom8.sqlite.TintucDAO;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrangchuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrangchuFragment extends Fragment {
    private static final String ARG_MA_BN = "maBN";
    private int maBN =-1;
    private TextView tvTenBenhnhan;
    private ListView lvTintuc;
    private List<Tintuc> list;
    private TintucAdapter adapterTintuc;
    private long tintucID;
    private BenhnhanDAO benhnhanDAO;

    public TrangchuFragment() {
    }

    public static TrangchuFragment newInstance(int maBN) {
        TrangchuFragment fragment = new TrangchuFragment();
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
        benhnhanDAO = new BenhnhanDAO(requireActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trangchu, container, false);

        tvTenBenhnhan = view.findViewById(R.id.tvTenBenhnhan);
        lvTintuc = view.findViewById(R.id.lvTintuc);

        displayBenhNhanInfo();

        TintucDAO dao = new TintucDAO(getActivity());
        list = dao.getAll();

        adapterTintuc = new TintucAdapter(getActivity(), list);
        lvTintuc.setAdapter(adapterTintuc);

        lvTintuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tintuc emp = list.get(i);
                tintucID = emp.getMaTT();
                Intent intent = new Intent(getActivity(), TintucChitietActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("id", String.valueOf(tintucID));
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.btnDatlichkham).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(), ChonchuyenkhoaActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        view.findViewById(R.id.btnChonbacsi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(), ChonbacsiActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        view.findViewById(R.id.btnHuongdan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(), HuongdanActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        return view;
    }

    private void displayBenhNhanInfo() {
        String tenBN = benhnhanDAO.getTenBNByMaBN(maBN);
        if (tenBN != null) {
            tvTenBenhnhan.setText(tenBN);
        } else {
            tvTenBenhnhan.setText("Không tìm thấy");
        }
    }
}