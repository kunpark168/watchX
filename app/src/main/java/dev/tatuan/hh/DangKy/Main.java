package dev.tatuan.hh.DangKy;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import dev.tatuan.hh.R;


public class Main extends AppCompatActivity {
    TextView tv_signUp, tv_signIn;
    TextView tvWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//        tvWatch = findViewById(R.id.tvWatch);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "icielbambola.ttf");
//        tvWatch.setTypeface(typeface);

        tv_signUp = (TextView) findViewById(R.id.dk);
        tv_signIn = (TextView) findViewById(R.id.dn);
        //
        tv_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DangKy.class));
            }
        });

        //
        tv_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DangNhap.class));
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}
