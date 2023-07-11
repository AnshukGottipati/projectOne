package com.example.projectone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class account extends AppCompatActivity {

    private EditText editTextWN ,editTextE,editTextP;
    private String WN,E,P;
    private Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account2);
        initViews();

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String WN = editTextWN.getText().toString();
                String E = editTextE.getText().toString();
                String P = editTextP.getText().toString();
                Intent intent3 = new Intent(account.this,MainActivity2.class);
                intent3.putExtra("WebSite",WN);
                intent3.putExtra("Email",E);
                intent3.putExtra("Password",P);

                startActivity(intent3);

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