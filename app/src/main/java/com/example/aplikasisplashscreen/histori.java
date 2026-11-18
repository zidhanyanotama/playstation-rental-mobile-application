package com.example.aplikasisplashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class histori extends AppCompatActivity {

    ListView listHistori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histori);

        listHistori = findViewById(R.id.list_histori);

        ArrayList<String> historiList = HistoriHelper.ambilHistori(this);
        HistoriAdapter adapter = new HistoriAdapter(this, historiList);
        listHistori.setAdapter(adapter);

        LinearLayout bottomnav = findViewById(R.id.bottom_nav);

        Button btnHapusHistori = findViewById(R.id.btn_hapus_histori);

        btnHapusHistori.setOnClickListener(v -> {
            HistoriHelper.hapusSemuaHistori(histori.this);
            Toast.makeText(histori.this, "Histori telah dihapus", Toast.LENGTH_SHORT).show();

            // Refresh list
            ArrayList<String> updatedList = new ArrayList<>();
            HistoriAdapter adapterBaru = new HistoriAdapter(histori.this, updatedList);
            listHistori.setAdapter(adapterBaru);
        });

        // BOTTOM NAVIGATION
        for (int i = 0; i < bottomnav.getChildCount(); i++) {
            View view = bottomnav.getChildAt(i);
            if (view instanceof Button) {
                Button navButton = (Button) view;
                navButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tag = v.getTag().toString();
                        switch (tag) {
                            case "beranda":
                                startActivity(new Intent(histori.this, dashboard.class));
                                break;
                            case "pesan":
                                startActivity(new Intent(histori.this, pesan.class));
                                break;
                            case "histori":
                                // Di sini lagi, jadi bisa kasih toast misalnya
                                Toast.makeText(histori.this, "Kamu sudah di halaman akun.", Toast.LENGTH_SHORT).show();
                                break;
                            case "akun":
                                startActivity(new Intent(histori.this, akun.class));
                                break;
                        }
                    }
                });
            }
        }

    }
}
