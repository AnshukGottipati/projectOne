package com.example.projectone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class account extends AppCompatActivity {

    private EditText editTextWN ,editTextE,editTextP;
    private String WN,E,P;
    private Button edit;
    List<AccountPassword> ap;
    MyApplication myApplication = (MyApplication) this.getApplication();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account2);
        ap = myApplication.getApList();
        initViews();

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int nextId = myApplication.getNextId();



                String WN = editTextWN.getText().toString();
                String E = editTextE.getText().toString();
                String P = editTextP.getText().toString();

                Intent intent1 = getIntent();
                String c = intent1.getStringExtra("ind");
                int index = Integer.parseInt(c);

                if (WN.matches("")) {
                    Toast.makeText(account.this, "You did not enter a Website Name/Link", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (E.matches("")) {
                    Toast.makeText(account.this, "You did not enter a Email/Username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (P.matches("")) {
                    Toast.makeText(account.this, "You did not enter a Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                ap.get(index).setWebsiteName(WN);
                ap.get(index).setEmail(E);
                ap.get(index).setPassword(P);

                Intent intent2 = new Intent(account.this,MainActivity2.class);
                startActivity(intent2);

            }
        });

    }



    private void initViews(){

        editTextWN = findViewById(R.id.editTextAC2Website);
        editTextE = findViewById(R.id.editTextAC2Email);
        editTextP = findViewById(R.id.editTextAC2Password);

        edit = findViewById(R.id.AC2Button);
    }
}