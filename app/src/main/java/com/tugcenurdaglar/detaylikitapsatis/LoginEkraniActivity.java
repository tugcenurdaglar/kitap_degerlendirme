package com.tugcenurdaglar.detaylikitapsatis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tugcenurdaglar.detaylikitapsatis.ui.anasayfa.AnasayfaFragment;

public class LoginEkraniActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    private Button buttonGirisYap, buttonKaydol, buttonDevamEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ekrani);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonGirisYap = findViewById(R.id.buttonGirisYap);
        buttonKaydol = findViewById(R.id.buttonKaydol);
        buttonDevamEt = findViewById(R.id.buttonDevamEt);

        buttonDevamEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginEkraniActivity.this, MainActivity.class));
//                finish();
            }
        });
    }
}