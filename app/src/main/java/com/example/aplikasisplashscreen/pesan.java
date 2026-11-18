package com.example.aplikasisplashscreen;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class pesan extends AppCompatActivity {

    Spinner spinnerPS, spinnerDurasi;
    ImageView imagePS;
    Button btnDate, btnKonfirmasi;
    TextView tvTanggal;
    EditText inputName, inputPhone, inputAlamat;
    CheckBox checkboxDelivery;

    Calendar selectedDate;
    String[] psModels = {"Pilih Model PS", "PS2", "PS3", "PS4", "PS5"};
    String[] durasiRental = {"Pilih Durasi", "1 hari", "2 hari", "3 hari", "4 hari", "5 hari", "6 hari", "7 hari"};
    int[] hargaPerHari = {0, 15000, 20000, 30000, 40000};
    int[] psImages = {R.drawable.ps2, R.drawable.ps2, R.drawable.ps3, R.drawable.ps4, R.drawable.ps5};

    int[][] gameImages = {
            {R.drawable.ps2gta, R.drawable.ps2god, R.drawable.ps2ff, R.drawable.ps2we},
            {R.drawable.ps3tlou, R.drawable.ps3cod, R.drawable.ps3uncharted, R.drawable.rdr2},
            {R.drawable.ps4spiderman, R.drawable.ps4god, R.drawable.ps4horizon, R.drawable.ps4thewitcher},
            {R.drawable.ps5demonsouls, R.drawable.ps5eldenring, R.drawable.ps5finalfantasy, R.drawable.ps5spiderman}
    };

    String[][] gameTitles = {
            {"GTA San Andreas", "God of War", "Final Fantasy", "Winning Eleven 10"},
            {"The Last of Us II", "Call Of Duty II", "Uncharted 2", "Red Dead Redemption II"},
            {"Spider-Man", "God of War", "Horizon", "The Witcher"},
            {"Demon Souls", "Elden Rings", "Final Fantasy XVI", "Spiderman 2"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        spinnerPS = findViewById(R.id.spinner_ps_model);
        spinnerDurasi = findViewById(R.id.spinner_duration);
        imagePS = findViewById(R.id.cardview).findViewById(R.id.imageView);
        btnDate = findViewById(R.id.button_date_picker);
        tvTanggal = findViewById(R.id.selected_date_text);
        btnKonfirmasi = findViewById(R.id.button_confirm);
        inputName = findViewById(R.id.input_name);
        inputPhone = findViewById(R.id.input_phone);
        checkboxDelivery = findViewById(R.id.checkbox_delivery);
        inputAlamat = findViewById(R.id.input_alamat);

        ImageView[] gameImagesView = new ImageView[]{
                findViewById(R.id.imageView2),
                findViewById(R.id.imageView3),
                findViewById(R.id.imageView4),
                findViewById(R.id.imageView5)
        };

        TextView[] gameTitlesView = new TextView[]{
                findViewById(R.id.textView2),
                findViewById(R.id.textView3),
                findViewById(R.id.textView4),
                findViewById(R.id.textView5)
        };

        ArrayAdapter<String> adapterPS = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, psModels);
        adapterPS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPS.setAdapter(adapterPS);

        ArrayAdapter<String> adapterDurasi = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, durasiRental);
        adapterDurasi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDurasi.setAdapter(adapterDurasi);

        spinnerPS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if (pos > 0 && pos < psImages.length) {
                    imagePS.setImageResource(psImages[pos]);

                    int modelIndex = pos - 1;
                    for (int i = 0; i < 4; i++) {
                        gameImagesView[i].setImageResource(gameImages[modelIndex][i]);
                        gameTitlesView[i].setText(gameTitles[modelIndex][i]);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        checkboxDelivery.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                inputAlamat.setVisibility(View.VISIBLE);
            } else {
                inputAlamat.setVisibility(View.GONE);
            }
        });

        btnDate.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, year, month, dayOfMonth) -> {
                        selectedDate = Calendar.getInstance();
                        selectedDate.set(year, month, dayOfMonth);
                        tvTanggal.setText("Tanggal dipilih: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                    },
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        btnKonfirmasi.setOnClickListener(v -> {
            int psIndex = spinnerPS.getSelectedItemPosition();
            int durasiIndex = spinnerDurasi.getSelectedItemPosition();

            if (psIndex == 0 || durasiIndex == 0 || selectedDate == null || inputName.getText().toString().isEmpty() || inputPhone.getText().toString().isEmpty() || (checkboxDelivery.isChecked() && inputAlamat.getText().toString().isEmpty())) {
                Toast.makeText(this, "Lengkapi semua data pemesanan!", Toast.LENGTH_SHORT).show();
                return;
            }

            int lamaHari = durasiIndex;
            Calendar endDate = (Calendar) selectedDate.clone();
            endDate.add(Calendar.DAY_OF_MONTH, lamaHari);

            int harga = hargaPerHari[psIndex];
            int totalHarga = harga * lamaHari;

            Intent intent = new Intent(pesan.this, pembayaran.class);
            intent.putExtra("nama", inputName.getText().toString());
            intent.putExtra("hp", inputPhone.getText().toString());
            intent.putExtra("model", psModels[psIndex]);
            intent.putExtra("durasi", durasiRental[durasiIndex]);
            intent.putExtra("tanggal_awal", formatTanggal(selectedDate));
            intent.putExtra("tanggal_akhir", formatTanggal(endDate));
            intent.putExtra("total", "Rp " + totalHarga);

            if (checkboxDelivery.isChecked()) {
                intent.putExtra("layanan", "Antar ke rumah");
                intent.putExtra("alamat", inputAlamat.getText().toString());
            } else {
                intent.putExtra("layanan", "Ambil sendiri");
                intent.putExtra("alamat", "-");
            }

            startActivity(intent);
        });
    }

    private String formatTanggal(Calendar cal) {
        return cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
    }
}