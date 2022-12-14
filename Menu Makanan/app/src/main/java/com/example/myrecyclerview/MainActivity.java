package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myrecyclerview.adapter.ListPlaceAdapter;
import com.example.myrecyclerview.model.Place;
import com.example.myrecyclerview.model.PlacesData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Place> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        list.addAll(PlacesData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListPlaceAdapter listPlaceAdapter = new ListPlaceAdapter(list);
        rvHeroes.setAdapter(listPlaceAdapter);
        listPlaceAdapter.setOnItemClickCallback(new ListPlaceAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(int id) {
                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });
    }

    private void showSelectedHero(Place place) {
        Toast.makeText(this, "Kamu memilih " + place.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
