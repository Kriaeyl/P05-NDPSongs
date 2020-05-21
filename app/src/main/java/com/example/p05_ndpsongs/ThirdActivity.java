package com.example.p05_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ThirdActivity extends AppCompatActivity {
    TextView tv1;
    EditText et1, et2, et3;
    RadioGroup rg1;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    Button b1, b2, b3;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        tv1 = findViewById(R.id.textView14);
        et1 = findViewById(R.id.editText4);
        et2 = findViewById(R.id.editText5);
        et3 = findViewById(R.id.editText6);
        rg1 = findViewById(R.id.rg2);
        b1 = findViewById(R.id.button4);
        b2 = findViewById(R.id.button5);
        b3 = findViewById(R.id.button6);
        rb1 = findViewById(R.id.radioButton6);
        rb2 = findViewById(R.id.radioButton7);
        rb3 = findViewById(R.id.radioButton8);
        rb4 = findViewById(R.id.radioButton9);
        rb5 = findViewById(R.id.radioButton10);
        ArrayList<RadioButton> rbList = new ArrayList<>(Arrays.asList(rb1, rb2, rb3, rb4, rb5));

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");
        tv1.setText(data.get_id() + "");
        et1.setText(data.getTitle());
        et2.setText(data.getSinger());
        et3.setText(data.getYear() + "");
        rbList.get(data.getStars()-1).setChecked(true);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                Song copyrightInfringement = new Song(data.get_id(), et1.getText().toString(), et2.getText().toString(), Integer.parseInt(et3.getText().toString()), Integer.parseInt(((RadioButton) rg1.getChildAt(rg1.indexOfChild(rg1.findViewById(rg1.getCheckedRadioButtonId())))).getText().toString()));
                dbh.updateSong(copyrightInfringement);
                dbh.close();
                Intent i = new Intent();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                dbh.deleteSong(data.get_id());
                dbh.close();
                Intent i = new Intent();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
