package com.example.projectone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    private FloatingActionButton btnNewEntry;
    private RecyclerView passwordRecyclerView;
    private passwordRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        adapter = new passwordRecyclerViewAdapter(this);
        passwordRecyclerView = findViewById(R.id.passwordRecyclerview);

        passwordRecyclerView.setAdapter(adapter);
        passwordRecyclerView.setLayoutManager(new GridLayoutManager(this,1));

        ArrayList<AccountPassword> ap= new ArrayList<>();
        ap.add(new AccountPassword(1,"oculus","uknown@gmail.com","password1"));



        adapter.setDetails(ap);

        initViews();
        btnNewEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // ap.add(new AccountPassword(ap.size()+1,"Enter Website","Enter Email","Enter Password"));

                adapter.setDetails(ap);

            }
        });
    }

    private void initViews(){
        btnNewEntry = findViewById(R.id.fab1);


    }
}