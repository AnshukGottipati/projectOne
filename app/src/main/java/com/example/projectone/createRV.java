package com.example.projectone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class createRV extends AppCompatActivity {


    private EditText editTextWN ,editTextE,editTextP;
    private Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_rv);

        editTextWN = findViewById(R.id.editTextRVWebsite);
        editTextE = findViewById(R.id.editTextRVEmail);
        editTextP = findViewById(R.id.editTextRVPassword);

        enter = findViewById(R.id.RV2Button);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper db = new DataBaseHelper(createRV.this);
                db.addOne(editTextWN.getText().toString().trim(),
                          editTextE.getText().toString().trim(),
                          editTextP.getText().toString().trim());

            }
        });




    }


}