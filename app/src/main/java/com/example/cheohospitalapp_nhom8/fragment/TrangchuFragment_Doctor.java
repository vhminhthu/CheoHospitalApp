package com.example.cheohospitalapp_nhom8.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cheohospitalapp_nhom8.ChonbacsiActivity;
import com.example.cheohospitalapp_nhom8.ChonchuyenkhoaActivity;
import com.example.cheohospitalapp_nhom8.LichhenActivity_Doctor;
import com.example.cheohospitalapp_nhom8.LichtrinhActivity_Doctor;
import com.example.cheohospitalapp_nhom8.R;
import com.example.cheohospitalapp_nhom8.TintucChitietActivity;
import com.example.cheohospitalapp_nhom8.TintucChitietActivity_Doctor;
import com.example.cheohospitalapp_nhom8.adapter.TintucAdapter;
import com.example.cheohospitalapp_nhom8.model.Lichtrinh;
import com.example.cheohospitalapp_nhom8.model.Tintuc;
import com.example.cheohospitalapp_nhom8.sqlite.TintucDAO;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrangchuFragment_Doctor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrangchuFragment_Doctor extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private ListView lvTintuc;
    private List<Tintuc> list;
    private TintucAdapter adapterTintuc;
    private long tintucID;

    public TrangchuFragment_Doctor() {
    }
    public static TrangchuFragment_Doctor newInstance(String param1, String param2) {
        TrangchuFragment_Doctor fragment = new TrangchuFragment_Doctor();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trangchu__doctor, container, false);

        lvTintuc = view.findViewById(R.id.lvTintuc);
        TintucDAO dao = new TintucDAO(getActivity());
        list = dao.getAll();

        adapterTintuc = new TintucAdapter(getActivity(), list);
        lvTintuc.setAdapter(adapterTintuc);

        lvTintuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tintuc emp = list.get(i);
                tintucID = emp.getMaTT();
                Intent intent = new Intent(getActivity(), TintucChitietActivity_Doctor.class);

                Bundle bundle = new Bundle();
                bundle.putString("id", String.valueOf(tintucID));
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.btnLichtrinh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(), LichtrinhActivity_Doctor.class);
                startActivityForResult(intent, 1);
            }
        });

        view.findViewById(R.id.btnLichhen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(), LichhenActivity_Doctor.class);
                startActivityForResult(intent, 1);
            }
        });

        return view;
    }
}