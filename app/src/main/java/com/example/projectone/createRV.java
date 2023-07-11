package com.example.projectone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class createRV extends AppCompatActivity {


    private EditText editTextWN ,editTextE,editTextP;
    private Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_rv);

        initViews();
    }

    private void initViews(){

        editTextWN = findViewById(R.id.editTextRVWebsite);
        editTextE = findViewById(R.id.editTextRVEmail);
        editTextP = findViewById(R.id.editTextRVPassword);

        enter = findViewById(R.id.RV2Button);
    }
}