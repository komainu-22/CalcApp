package jp.techacademy.akatsuki.hajime.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.support.design.widget.*;
import java.math.BigDecimal;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);

    }


    @Override
    public void onClick(View v){
        EditText editText1 = (EditText)findViewById(R.id.A);
        EditText editText2 = (EditText)findViewById(R.id.B);
        BigDecimal CalcValue = BigDecimal.valueOf(0);


        if(editText1.length() == 0 | editText2.length() == 0){
            Snackbar.make(v, "数値を入力してください。",Snackbar.LENGTH_LONG).show();
        } else {
            double a = Double.parseDouble(editText1.getText().toString());
            double b = Double.parseDouble(editText2.getText().toString());

            BigDecimal A = BigDecimal.valueOf(a);
            BigDecimal B = BigDecimal.valueOf(b);


            switch(v.getId()){
                case R.id.button1:
                    CalcValue = A.add(B);
                    break;

                case R.id.button2:
                    CalcValue = A.subtract(B);
                    break;

                case R.id.button3:
                    CalcValue = A.multiply(B);
                    break;

                case R.id.button4:
                    CalcValue = A.divide(B);
                    break;

            }

            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("value", CalcValue.toString());
            startActivity(intent);

            Log.d("UI-PARTS",CalcValue.toString());

        }
    }

}


