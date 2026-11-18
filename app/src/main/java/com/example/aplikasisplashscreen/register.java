package com.example.aplikasisplashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class register extends AppCompatActivity {

    EditText inputUsername, inputPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputUsername = findViewById(R.id.user);
        inputPassword = findViewById(R.id.pass);
        btnRegister = findViewById(R.id.btnsimpan);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = inputUsername.getText().toString();
                String pass = inputPassword.getText().toString();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(register.this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    // Kirim data ke MainActivity (Login) lewat Intent
                    Intent intent = new Intent(register.this, MainActivity.class);
                    intent.putExtra("username", user);
                    intent.putExtra("password", pass);
                    startActivity(intent);
                    finish(); // biar tidak kembali ke form daftar
                }
            }
        });
    }
}
