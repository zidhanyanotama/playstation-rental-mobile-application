package com.example.aplikasisplashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin, btndaftar;
    String keyname, keypass;

    String registeredUser=null;
    String registeredPass=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnlogin = (Button) findViewById(R.id.btnlogin);
        btndaftar = (Button) findViewById(R.id.btndaftar);
        username=findViewById(R.id.user);
        password=findViewById(R.id.pass);

        //ambil data dari register
        Intent intent = getIntent();
        String registeredUser = intent.getStringExtra("username");
        String registeredPass = intent.getStringExtra("password");

        //isi otomatis data dari register
        if (registeredUser != null && registeredPass != null) {
            username.setText(registeredUser);
            password.setText(registeredPass);
        }

        //perintah button click daftar
        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftarIntent = new Intent(MainActivity.this, register.class);
                startActivity(daftarIntent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyname = username.getText().toString();
                keypass = password.getText().toString();

                // Cek login dengan dua kemungkinan:
                if ((keyname.equals("admin") && keypass.equals("admin")) ||
                        (keyname.equals(registeredUser) && keypass.equals(registeredPass))) {

                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent loginintent = new Intent(MainActivity.this, dashboard.class);
                    startActivity(loginintent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username atau password salah")
                            .setNegativeButton("Ulangi", null)
                            .create()
                            .show();

                    username.setText("");
                    password.setText("");

                }


            }
        });


    }
}