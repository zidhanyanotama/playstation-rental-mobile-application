package com.example.aplikasisplashscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoriAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> historiList;

    public HistoriAdapter(Context context, ArrayList<String> historiList) {
        this.context = context;
        this.historiList = historiList;
    }

    @Override
    public int getCount() {
        return historiList.size();
    }

    @Override
    public Object getItem(int position) {
        return historiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate layout item_custom_histori
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_histori, parent, false);
        }

        TextView tvHistori = convertView.findViewById(R.id.text_histori);
        tvHistori.setText(historiList.get(position));

        return convertView;
    }
}
