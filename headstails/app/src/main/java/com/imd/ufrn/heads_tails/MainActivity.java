package com.imd.ufrn.heads_tails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imBtn = findViewById(R.id.imbtn);

        imBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                ProcessHeadsTails pross = new ProcessHeadsTails();

                int value = pross.getResult();
                intent.putExtra("result",value);

                startActivity(intent);

            }
        });

    }
}