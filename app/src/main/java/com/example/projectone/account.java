package com.example.projectone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class account extends AppCompatActivity {

    private EditText editTextWN ,editTextE,editTextP;
    private String id,website,email,password;
    private Button edit,remove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Update Details");
        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        initViews();
        getAndSetIntentData();

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
                //Intent intent2 = new Intent(account.this,MainActivity2.class);
               // startActivity(intent2);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DataBaseHelper db = new DataBaseHelper(account.this);
                website = editTextWN.getText().toString().trim();
                email = editTextE.getText().toString().trim();
                password = editTextP.getText().toString().trim();

                db.updateData(website,email,password,id);

                Intent intent2 = new Intent(account.this,MainActivity2.class);
                startActivity(intent2);

            }
        });


    }
    public void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete ?");
        builder.setMessage("Are you sure you want to delete ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataBaseHelper myDB = new DataBaseHelper(account.this);
                myDB.deleteData(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    public void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("website") && getIntent().hasExtra("email") &&  getIntent().hasExtra("password")){
            id = getIntent().getStringExtra("id");
            website = getIntent().getStringExtra("website");
            email = getIntent().getStringExtra("email");
            password = getIntent().getStringExtra("password");

            editTextWN.setText(website);
            editTextE.setText(email);
            editTextP.setText(password);
        }else{
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out,R.anim.slide_in);
    }

    private void initViews(){

        editTextWN = findViewById(R.id.editTextAC2Website);
        editTextE = findViewById(R.id.editTextAC2Email);
        editTextP = findViewById(R.id.editTextAC2Password);
        remove = findViewById(R.id.AC2Button2);
        edit = findViewById(R.id.AC2Button);
    }
}