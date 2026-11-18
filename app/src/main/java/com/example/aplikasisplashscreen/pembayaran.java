package com.example.aplikasisplashscreen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class pembayaran extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    TextView tvNama, tvHP, tvModel, tvDurasi, tvTanggalAwal, tvTanggalAkhir, tvLayanan, tvAlamat, tvTotal;
    LinearLayout layoutTransferDetail;
    Button btnCod, btnTransfer, btnUpload, btnKonfirmasiTransfer;
    ImageView imageBukti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pembayaran);

        // Inisialisasi semua View
        tvNama = findViewById(R.id.text_nama);
        tvHP = findViewById(R.id.text_phone);
        tvModel = findViewById(R.id.text_model);
        tvDurasi = findViewById(R.id.text_durasi);
        tvTanggalAwal = findViewById(R.id.text_tanggal_awal);
        tvTanggalAkhir = findViewById(R.id.text_tanggal_akhir);
        tvLayanan = findViewById(R.id.text_layanan);
        tvAlamat = findViewById(R.id.text_alamat);
        tvTotal = findViewById(R.id.text_total);

        layoutTransferDetail = findViewById(R.id.layout_transfer_detail);
        btnCod = findViewById(R.id.btn_cod);
        btnTransfer = findViewById(R.id.btn_transfer);
        btnUpload = findViewById(R.id.btn_upload_bukti);
        btnKonfirmasiTransfer = findViewById(R.id.btn_konfirmasi_transfer);
        imageBukti = findViewById(R.id.image_bukti);

        // Ambil data dari Intent
        Intent intent = getIntent();
        tvNama.setText("Nama: " + intent.getStringExtra("nama"));
        tvHP.setText("No HP: " + intent.getStringExtra("hp"));
        tvModel.setText("Model PS: " + intent.getStringExtra("model"));
        tvDurasi.setText("Durasi: " + intent.getStringExtra("durasi"));
        tvTanggalAwal.setText("Tanggal Awal: " + intent.getStringExtra("tanggal_awal"));
        tvTanggalAkhir.setText("Tanggal Akhir: " + intent.getStringExtra("tanggal_akhir"));
        tvTotal.setText("Total Harga: " + intent.getStringExtra("total"));

        String layanan = intent.getStringExtra("layanan");
        tvLayanan.setText("Layanan: " + layanan);
        if (layanan.equals("Antar ke rumah")) {
            tvAlamat.setText("Alamat: " + intent.getStringExtra("alamat"));
            tvAlamat.setVisibility(View.VISIBLE);
        } else {
            tvAlamat.setVisibility(View.GONE);
        }

        // Tombol COD
        btnCod.setOnClickListener(v -> {
            String histori = ambilDetailHistori();
            HistoriHelper.simpanHistori(pembayaran.this, histori);

            Toast.makeText(pembayaran.this, "Pembayaran COD berhasil!", Toast.LENGTH_SHORT).show();
            Intent goToDashboard = new Intent(pembayaran.this, dashboard.class);
            goToDashboard.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(goToDashboard);
            finish();
        });

        // Tombol Transfer: munculkan detail transfer
        btnTransfer.setOnClickListener(v -> {
            layoutTransferDetail.setVisibility(View.VISIBLE);
        });

        // Upload bukti: buka galeri
        btnUpload.setOnClickListener(v -> {
            Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickIntent, PICK_IMAGE_REQUEST);
        });

        // Tombol konfirmasi transfer
        btnKonfirmasiTransfer.setOnClickListener(v -> {
            String histori = ambilDetailHistori();
            HistoriHelper.simpanHistori(pembayaran.this, histori);

            Toast.makeText(pembayaran.this, "Pembayaran berhasil via Transfer!", Toast.LENGTH_SHORT).show();
            Intent goToDashboard = new Intent(pembayaran.this, dashboard.class);
            goToDashboard.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(goToDashboard);
            finish();
        });
    }

    // Menampilkan gambar bukti transfer
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            imageBukti.setImageURI(selectedImage);
            imageBukti.setVisibility(View.VISIBLE);
        }
    }

    // Buat string histori dari data pemesanan
    private String ambilDetailHistori() {
        return tvModel.getText().toString() + " | " +
                tvDurasi.getText().toString() + " | " +
                tvTanggalAwal.getText().toString() + " s/d " +
                tvTanggalAkhir.getText().toString() + " | " +
                tvTotal.getText().toString();
    }
}
