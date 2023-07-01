package com.example.projectone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView passwordRecyclerView;
    private passwordRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        adapter = new passwordRecyclerViewAdapter(this);
        passwordRecyclerView = findViewById(R.id.passwordRecyclerview);

        passwordRecyclerView.setAdapter(adapter);
        passwordRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ArrayList<AccountPassword> ap= new ArrayList<>();
        ap.add(new AccountPassword(1,"oculus","uknown@gmail.com","password1"));
        ap.add(new AccountPassword(2,"youtube","hello@gmail.com","password2"));
        ap.add(new AccountPassword(3,"twitter","world@gmail.com","password3"));
        adapter.setDetails(ap);

    }
}