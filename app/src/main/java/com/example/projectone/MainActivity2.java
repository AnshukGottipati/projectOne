package com.example.projectone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
//import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    private FloatingActionButton btnNewEntry,btnReload;
    private RecyclerView passwordRecyclerView;
    private passwordRecyclerViewAdapter adapter;

    DataBaseHelper myDB;

    ArrayList<String> id, website,email,password;




    MyApplication myApplication = (MyApplication) this.getApplication();
    List<AccountPassword> ap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Details List");

        btnNewEntry = findViewById(R.id.fab1);
        btnReload = findViewById(R.id.fab2);
        passwordRecyclerView = findViewById(R.id.passwordRecyclerview);

        /**
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);



        ap = myApplication.getApList();
        adapter = new passwordRecyclerViewAdapter(ap,MainActivity2.this);
        passwordRecyclerView.setAdapter(adapter);
        passwordRecyclerView.setLayoutManager(new GridLayoutManager(this,1));



        adapter.setDetails(ap);
         **/

        btnNewEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity2.this,createRV.class);
                startActivity(intent);

            }
        });

        myDB = new DataBaseHelper(MainActivity2.this);
        website = new ArrayList<>();
        email = new ArrayList<>();
        password = new ArrayList<>();
        id = new ArrayList<>();

        storeDataInArray();


        adapter = new passwordRecyclerViewAdapter(id,website,email,password,this,MainActivity2.this);

        passwordRecyclerView.setAdapter(adapter);
        passwordRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));



        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    public void storeDataInArray(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data.",Toast.LENGTH_SHORT).show();
        } else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                website.add(cursor.getString(1));
                email.add(cursor.getString(2));
                password.add(cursor.getString(3));
            }

        }


    }
    public void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete ?");
        builder.setMessage("Are you sure you want to delete ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataBaseHelper myDB = new DataBaseHelper(MainActivity2.this);
                myDB.deleteAllData();
                //finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    /**
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
**/
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out,R.anim.slide_in);
    }




}