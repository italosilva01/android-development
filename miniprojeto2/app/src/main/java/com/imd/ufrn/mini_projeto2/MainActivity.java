package com.imd.ufrn.mini_projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etValor;
    Switch swDeconto;
    EditText etDesconto;
    TextView tvCashBackPercentagem;
    SeekBar seCashBack;
    TextView tvCashBack;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init variables
       etValor = findViewById(R.id.etvalueproduto);
       swDeconto = findViewById(R.id.swswitch);
       etDesconto= findViewById(R.id.etDesconto);
       tvCashBackPercentagem= findViewById(R.id.percent);
       seCashBack=findViewById(R.id.desconto);
       tvCashBack=findViewById(R.id.tvcashbackValue);
       tvTotal=findViewById(R.id.tvTotalValue);


       swDeconto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               System.out.println(isChecked);
                   etDesconto.setEnabled(isChecked);

           }
       });

    }
}