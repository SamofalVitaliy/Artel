package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * Created by Виталий on 01.12.14.
 */
public class Main extends Activity {
    TextView[] textViews = new TextView[2];
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.pgz:
                    startActivity(new Intent(Main.this, Arteleria.class));
                    break;
                case R.id.ogz:
                    startActivity(new Intent(Main.this, Ogz.class));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textViews[0] = (TextView) findViewById(R.id.pgz);
        textViews[1] = (TextView) findViewById(R.id.ogz);
        textViews[0].setOnClickListener(onClickListener);
        textViews[1].setOnClickListener(onClickListener);

    }
}
