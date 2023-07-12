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
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    private FloatingActionButton btnNewEntry,btnReload;
    private RecyclerView passwordRecyclerView;
    private passwordRecyclerViewAdapter adapter;

    MyApplication myApplication = (MyApplication) this.getApplication();
    List<AccountPassword> ap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ap = myApplication.getApList();

        adapter = new passwordRecyclerViewAdapter(ap,MainActivity2.this);
        passwordRecyclerView = findViewById(R.id.passwordRecyclerview);

        passwordRecyclerView.setAdapter(adapter);
        passwordRecyclerView.setLayoutManager(new GridLayoutManager(this,1));



        //adapter.setDetails(ap);

        initViews();
        btnNewEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ap.add(new AccountPassword(myApplication.getNextId(),"Enter Website","Enter Email","Enter Password"));
                MyApplication.setNextId(MyApplication.getNextId()+1);

                adapter.setDetails(ap);

            }
        });

        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adapter.setDetails(ap);

            }
        });



    }



    private void initViews(){
        btnNewEntry = findViewById(R.id.fab1);
        btnReload = findViewById(R.id.fab2);

    }
}