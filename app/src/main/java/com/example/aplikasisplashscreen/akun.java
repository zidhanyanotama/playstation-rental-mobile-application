package com.example.aplikasisplashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class akun extends AppCompatActivity {

    Button btnLogout;
    LinearLayout bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // ganti dengan nama layout lo, misalnya activity_profile

        btnLogout = findViewById(R.id.btn_logout);
        bottomNav = findViewById(R.id.bottom_nav);

        // Tombol Logout
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman login (MainActivity)
                Intent intent = new Intent(akun.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Biar ga bisa balik pake tombol back
                startActivity(intent);
                finish();
            }
        });

        // BOTTOM NAVIGATION
        for (int i = 0; i < bottomNav.getChildCount(); i++) {
            View view = bottomNav.getChildAt(i);
            if (view instanceof Button) {
                Button navButton = (Button) view;
                navButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tag = v.getTag().toString();
                        switch (tag) {
                            case "beranda":
                                startActivity(new Intent(akun.this, dashboard.class));
                                break;
                            case "pesan":
                                startActivity(new Intent(akun.this, pesan.class));
                                break;
                            case "histori":
                                startActivity(new Intent(akun.this, histori.class));
                                break;
                            case "akun":
                                // Di sini lagi, jadi bisa kasih toast misalnya
                                Toast.makeText(akun.this, "Kamu sudah di halaman akun.", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            }
        }
    }
}
