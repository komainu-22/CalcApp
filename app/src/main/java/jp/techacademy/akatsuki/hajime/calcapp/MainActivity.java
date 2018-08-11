package jp.techacademy.akatsuki.hajime.calcapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;
    TextView mTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener(this);

        Button button3 = (Button)findViewById(R.id.button3);
        button1.setOnClickListener(this);

        Button button4 = (Button)findViewById(R.id.button4);
        button1.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.A);
        mEditText2 = (EditText) findViewById(R.id.B);

        mEditText1 = (EditText) findViewById(R.id.A);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                Intent intent = getIntent();
                double value_a =intent.getDoubleExtra("value_A",0.0);
                double value_b =intent.getDoubleExtra("value_B",0.0);

                if(TextUtils.isEmpty(String.valueOf(value_a)) == false | TextUtils.isEmpty(String.valueOf(value_b)) ==false) {
                    TextView textView = (TextView)findViewById(R.id.textView);
                    textView.setText(String.valueOf(value_a + value_b));
                } else {
                    showAlertDialog();
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                Intent intent = getIntent();
                double value_a =intent.getDoubleExtra("value_A",0.0);
                double value_b =intent.getDoubleExtra("value_B",0.0);


                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText(String.valueOf(value_a - value_b));

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                Intent intent = getIntent();
                double value_a =intent.getDoubleExtra("value_A",0.0);
                double value_b =intent.getDoubleExtra("value_B",0.0);


                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText(String.valueOf(value_a * value_b));

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                Intent intent = getIntent();
                double value_a =intent.getDoubleExtra("value_A",0.0);
                double value_b =intent.getDoubleExtra("value_B",0.0);


                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText(String.valueOf(value_a / value_b));

            }
        });
    }


/*    @Override
    public void onClick(View v){

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("value_A", R.id.A);
        intent.putExtra("value_B", R.id.B);
        startActivity(intent);
    }
*/
    private void showAlertDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("未入力の項目があります");
        alertDialogBuilder.setMessage("数値を入力してください");

        alertDialogBuilder.setPositiveButton("肯定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
