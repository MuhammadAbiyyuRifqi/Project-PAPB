package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class show_profile extends AppCompatActivity {

    private TextView nim;
    private TextView no_hp;
    private TextView nama;
    private TextView alamat;
    private Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);

        nim = findViewById(R.id.text_nim);
        no_hp = findViewById(R.id.text_no_hp);
        nama = findViewById(R.id.text_nama);
        alamat = findViewById(R.id.text_alamat);

        String usernim = getIntent().getStringExtra("keynim");
        String userno = getIntent().getStringExtra("keyno");
        String usernama = getIntent().getStringExtra("keynama");
        String useralamat = getIntent().getStringExtra("keyalamat");

        nim.setText(usernim);
        no_hp.setText(userno);
        nama.setText(usernama);
        alamat.setText(useralamat);
    }
}