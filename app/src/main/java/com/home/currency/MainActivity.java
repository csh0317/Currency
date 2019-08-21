package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ntd;
    private TextView jpy;
    private TextView usd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        ntd = findViewById(R.id.ntd);
        jpy = findViewById(R.id.jpy);
        usd = findViewById(R.id.usd);
    }

    public void convert(View view){
//        getResources().getString(R.string.app_name);
        String dollar = ntd.getText().toString();
        if(dollar.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.problem))
                    .setMessage(getString(R.string.please_enter))
                    .setPositiveButton(getString(R.string.ok),null )
                    .show();
        }else{
            int input_money = Integer.parseInt(dollar);
            float conv_usd = (float)(input_money / 30.9);
            usd.setText(""+conv_usd);
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.result))
                    .setMessage(getString(R.string.usd_is)+ conv_usd)
                    .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ntd.setText("");
                        }
                    })
                    .show();
        }

    }
}
