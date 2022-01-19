package com.imd.ufrn.heads_tails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    ImageButton btnBack;
    ImageView imageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int[] imagensIds = {
                R.drawable.moeda_cara,
                R.drawable.moeda_coroa,
        };

        btnBack = findViewById(R.id.imgBtnBack);
        imageResult = findViewById(R.id.imgResult);

        Intent intent = getIntent();
        int result = intent.getExtras().getInt("result");
        System.out.println(result);
        imageResult.setImageResource(imagensIds[result]);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}