package com.example.p05_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Button b1, b2;
    RadioGroup rg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        rg1 = findViewById(R.id.rg1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = et1.getText().toString();
                String singer = et2.getText().toString();
                int year = Integer.parseInt(et3.getText().toString());
                RadioButton r = (RadioButton) rg1.getChildAt(rg1.indexOfChild(rg1.findViewById(rg1.getCheckedRadioButtonId())));
                int stars = Integer.parseInt(r.getText().toString());
                DBHelper dbh = new DBHelper(MainActivity.this);
                dbh.insertSong(title, singer, year, stars);
                dbh.close();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
