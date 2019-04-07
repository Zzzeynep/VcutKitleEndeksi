package com.example.dilara_zeynep.vcutkitleendeksi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;

public class MainActivity extends AppCompatActivity {
Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomMenu);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Button hesap = (Button) findViewById(R.id.buttonHesap);
        hesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Bilgi", "Hesapla butonuna tıklandı...");
                EditText kilo = (EditText) findViewById(R.id.editKilo);
                EditText boy = (EditText) findViewById(R.id.editBoy);
                TextView sonuc = (TextView) findViewById(R.id.texttitle);

                calculate(kilo, boy, sonuc);
            }
        });

    }

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.diyet:
                   Log.i("Bilgi","anasayfaya tıklandı");

                    intent = new Intent(getApplicationContext(),Liste.class);
                   startActivity(intent);
                    break;

                case R.id.favori:
                    Log.i("Bilgi","Sağlık menusüne tıklandı");

                     intent = new Intent(getApplicationContext(), Anasayfa.class);
                    startActivity(intent);
                    break;
                case R.id.anasayfa:
                    Log.i("Bilgi","Diyet listesine tıklandı");

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    break;

            }
            return true;
        }

    };
        private void calculate(EditText userWeightEt, EditText userLengthtEt, TextView userResultTv) {


            if (userWeightEt.getText().toString().length() > 0 && userLengthtEt.getText().toString().length() > 0) {

                Log.i("Bilgi", "calculate: Hesaplama başlıyor...");


                float userWeight = Float.parseFloat(userWeightEt.getText().toString());
                float userLength = Float.parseFloat(userLengthtEt.getText().toString());
                if (userLength > 0) {
                    userLength = userLength / 100;
                    float result = (userWeight / ((userLength * userLength)));

                    String resultDescription = "";

                    if (result < 15) {
                        resultDescription = "Aşırı Zayıf";
                    } else if (result > 15 && result <= 30) {
                        resultDescription = "Zayıf";
                    } else if (result > 30 && result <= 40) {
                        resultDescription = "Normal";
                    } else if (result > 40) {
                        resultDescription = "Aşırı Şişman (Morbid Obez)";
                    } else {
                        resultDescription = "Aşırı Şişman (Morbid Obez)";
                    }
                    Log.i("Bilgi", "Sonuc: " + resultDescription);
                    userResultTv.setText("Vücut kitle endeksiniz: " + result + "\n" + resultDescription);
                }
            } else {

                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Hata!");
                builder.setMessage("Kilo ya da boy boş bırakılamaz.");
                builder.setNegativeButton("TAMAM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

                builder.show();
            }
        }
    }
