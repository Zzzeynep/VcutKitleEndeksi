package com.example.dilara_zeynep.vcutkitleendeksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class Liste extends AppCompatActivity {
    String[] dietListesi = {"yumurta,peynir,zeytin", "mevsim yeşillikleri salata","Badem,fındık,ceviz", "Kivi,çilek, muz" } ;
    Integer[] imageArray = {R.drawable.kahvalti,
                             R.drawable.salata,
                            R.drawable.cerez,
                             R.drawable.meyve};
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        Log.i("Bilgi", "Liste gösterilecek... ");


        listview = (ListView)findViewById(R.id.listeDiet);


    }
}
