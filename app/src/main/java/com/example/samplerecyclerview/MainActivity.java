package com.example.samplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    RecyclerView recyclerView;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter = new PersonAdapter();
        for (int i = 0; i < 20; i++) {
            adapter.addItem(new Person("LGH"+i, "010-3446-737"+i));
        }
        recyclerView.setAdapter(adapter);

        adapter.setListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person person = adapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(), PersonCardView.class);
                intent.putExtra("item", person);
                startActivity(intent);
            }
        });
    }
}