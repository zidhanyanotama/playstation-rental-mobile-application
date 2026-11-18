package com.example.aplikasisplashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class dashboard extends AppCompatActivity {

    Button btnBeranda, btnPesan, btnHistori, btnAkun, btnPesanSekarang;
    RecyclerView promoRecycler;
    PromoAdapter promoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Inisialisasi tombol navigasi bawah
        btnBeranda = findViewById(R.id.bottom_nav).findViewWithTag("beranda");
        btnPesan = findViewById(R.id.bottom_nav).findViewWithTag("pesan");
        btnHistori = findViewById(R.id.bottom_nav).findViewWithTag("histori");
        btnAkun = findViewById(R.id.bottom_nav).findViewWithTag("akun");

        // Tombol "Pesan Sekarang"
        LinearLayout btnPesanSekarang = findViewById(R.id.btn_pesan);
        btnPesanSekarang.setOnClickListener(v -> {
            startActivity(new Intent(dashboard.this, pesan.class));
        });


        // Navigasi tombol bawah
        btnBeranda.setOnClickListener(v -> {
            // Sudah di beranda
        });

        btnPesan.setOnClickListener(v -> {
            startActivity(new Intent(dashboard.this, pesan.class));
        });

        btnHistori.setOnClickListener(v -> {
            startActivity(new Intent(dashboard.this, histori.class));
        });

        btnAkun.setOnClickListener(v -> {
            startActivity(new Intent(dashboard.this, akun.class));
        });

        btnPesanSekarang.setOnClickListener(v -> {
            startActivity(new Intent(dashboard.this, pesan.class));
        });

        // ====== PROMO RECYCLER SETUP ======
        promoRecycler = findViewById(R.id.promoRecycler);
        promoRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Isi data promo
        List<Integer> promoImages = Arrays.asList(
                R.drawable.ps3,
                R.drawable.ps4,
                R.drawable.ps5
        );

        List<String> promoTitles = Arrays.asList(
                "Playstation 3",
                "Playstation 4",
                "Playstation 5"
        );

        // Pasang adapter yang sudah support tombol dan title
        promoAdapter = new PromoAdapter(this, promoImages, promoTitles);
        promoRecycler.setAdapter(promoAdapter);
    }
}
