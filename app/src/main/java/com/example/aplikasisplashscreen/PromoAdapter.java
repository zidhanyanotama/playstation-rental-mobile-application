package com.example.aplikasisplashscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> {

    private List<Integer> promoImages;
    private List<String> promoTitles;
    private Context context;

    public PromoAdapter(Context context, List<Integer> promoImages, List<String> promoTitles) {
        this.context = context;
        this.promoImages = promoImages;
        this.promoTitles = promoTitles;
    }

    @NonNull
    @Override
    public PromoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.promo_slider_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromoAdapter.ViewHolder holder, int position) {
        holder.imagePromo.setImageResource(promoImages.get(position));
        holder.promoTitle.setText(promoTitles.get(position));
    }

    @Override
    public int getItemCount() {
        return promoImages.size(); // atau promoTitles.size(), harus sama panjang
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePromo;
        TextView promoTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePromo = itemView.findViewById(R.id.promo_image);
            promoTitle = itemView.findViewById(R.id.promo_title);
        }
    }
}
