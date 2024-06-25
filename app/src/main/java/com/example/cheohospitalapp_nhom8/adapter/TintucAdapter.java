package com.example.cheohospitalapp_nhom8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cheohospitalapp_nhom8.R;
import com.example.cheohospitalapp_nhom8.model.Tintuc;

import java.util.List;

public class TintucAdapter extends BaseAdapter {
    private Context context;
    private List<Tintuc> list;

    public TintucAdapter(Context context, List<Tintuc> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int iposition) {
        return list.get(iposition);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_layout_tintuc, null);
        }

        TextView tvTieude = view.findViewById(R.id.tvTieude);
        ImageView img = view.findViewById(R.id.imgTintuc);
        TextView id = view.findViewById(R.id.id);

        Tintuc emp = list.get(i);
        tvTieude.setText(emp.getTieuDe());
        id.setText(String.valueOf(emp.getMaTT()));

        Tintuc tintuc = list.get(i);
        tintuc.getHinhAnh();

        int resId = context.getResources().getIdentifier(tintuc.getHinhAnh(), "drawable", context.getPackageName());
        img.setImageResource(resId);

        return view;
    }
}