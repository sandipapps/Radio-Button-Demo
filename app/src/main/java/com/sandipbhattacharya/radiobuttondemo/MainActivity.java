package com.sandipbhattacharya.radiobuttondemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgLanguages;
    Button btnReset, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgLanguages = findViewById(R.id.rgLanguages);
        btnReset = findViewById(R.id.btnReset);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = rgLanguages.getCheckedRadioButtonId();
                if(checkedId == -1){
                    // No radio buttons are checked
                    Message.message(getApplicationContext(), "Please select a language.");
                }else{
                    // One of the radio buttons is checked
                    findRadioButton(checkedId);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rgLanguages.clearCheck();
            }
        });
        rgLanguages.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                findRadioButton(checkedId);
                /*rbLanguage = findViewById(checkedId);
                Message.message(getApplicationContext(), rbLanguage.getText().toString());*/
            }
        });
    }

    private void findRadioButton(int checkedId) {
        switch (checkedId) {
            case R.id.radioButton:
                Message.message(getApplicationContext(), "I like C.");
                break;
            case R.id.radioButton2:
                Message.message(getApplicationContext(), "I like C++.");
                break;
            case R.id.radioButton3:
                Message.message(getApplicationContext(), "I like Java.");
                break;
            case R.id.radioButton4:
                Message.message(getApplicationContext(), "I like PHP.");
                break;
            case R.id.radioButton5:
                Message.message(getApplicationContext(), "I like Python.");
                break;
        }
    }
}
