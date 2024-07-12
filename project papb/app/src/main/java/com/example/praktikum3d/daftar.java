package com.example.praktikum3d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText nim;
    private EditText no_hp;
    private EditText nama;
    private EditText alamat;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        nim = findViewById(R.id.nim);
        no_hp = findViewById(R.id.nmrhp);
        nama = findViewById(R.id.name);
        alamat = findViewById(R.id.almt);
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernim = nim.getText().toString();
                String userno = no_hp.getText().toString();
                String usernama = nama.getText().toString();
                String useralamat = alamat.getText().toString();

                Intent intent = new Intent(register.this,show_profile.class);
                intent.putExtra("keynim",usernim);
                intent.putExtra("keyno",userno);
                intent.putExtra("keynama",usernama);
                intent.putExtra("keyalamat",useralamat);
                startActivity(intent);

            }
        });


        Spinner spinner=findViewById(R.id.planets_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.option, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void clickAdd(View v){
        startActivity(new Intent(register.this, show.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long i) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public static void setUsername(Context context, String username) {
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", username);
        editor.commit();
    }
}