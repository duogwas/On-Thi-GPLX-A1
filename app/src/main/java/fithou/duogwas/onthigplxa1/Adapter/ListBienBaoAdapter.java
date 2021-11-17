package fithou.duogwas.onthigplxa1.Adapter;//
// Created by duogwas on 17/11/2021.
//


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fithou.duogwas.onthigplxa1.Class.BienBao;
import fithou.duogwas.onthigplxa1.R;

public class ListBienBaoAdapter extends ArrayAdapter<BienBao> {
    public ListBienBaoAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListBienBaoAdapter(Context context, int resource, ArrayList<BienBao> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.custom_lv_bienbao,null);
        }

        BienBao bienBao = getItem(position);
        if (bienBao!=null){
            TextView tvTenBien = (TextView) view.findViewById(R.id.tv_tenbien);
            tvTenBien.setText(bienBao.TenBien);

            TextView tvMoTa = (TextView) view.findViewById(R.id.tv_mota);
            tvMoTa.setText(bienBao.MoTa);

            ImageView imgHinhbienbao = (ImageView) view.findViewById(R.id.img_bienbao);
            Picasso.with(getContext()).load(bienBao.Hinh).into(imgHinhbienbao);
        }
        return view;
    }
}
