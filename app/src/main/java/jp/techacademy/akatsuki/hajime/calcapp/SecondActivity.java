package jp.techacademy.akatsuki.hajime.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

import java.math.BigDecimal;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String value = intent.getStringExtra(("value"));

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(value);
    }
}
