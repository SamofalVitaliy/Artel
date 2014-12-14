package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Виталий on 01.12.14.
 */
public class Ogz extends Activity {
    Map<Integer, EditText> viewMap = new HashMap<>();
    Map<Integer, TextView> textViewMap = new HashMap<>();
    Double x1, x2, y1, y2, x, y, alfa, m, h1, h2;
    Long d, ro;
    Integer [][]a = {{1,2,3,4},{1,2}};
    String [][] st = {{"Sasa", "qwea"}, {"sfdsf","asdsad"}};
    public void solve() {
        if (x1 != null && x2 != null && y1 != null && y2 != null) {
            x = x1 - x2;
            y = y1 - y2;
            d = Math.round(Math.sqrt(x * x + y * y));
            ro = Math.round(Math.acos(x / d)*(180 / Math.PI /6)*100);
            Log.v("1", Double.toString(Math.acos(x/d)));
            if (y > 0) alfa = ro / 100.0;
            else alfa = Math.round(6000.0 - ro) / 100.0;

            textViewMap.get(R.id.x).setText(Double.toString(x));
            textViewMap.get(R.id.y).setText(Double.toString(y));
            textViewMap.get(R.id.d).setText(Long.toString(d));
            textViewMap.get(R.id.ro).setText(Long.toString(ro));
            textViewMap.get(R.id.alfa).setText(Double.toString(alfa));
            if (h1 != null && h2 != null) {
                m = ((h2 - h1) / d) * 9.55;
                textViewMap.get(R.id.m).setText(Double.toString(m));
            }
        }
    }

    TextWatcher textWatcherX1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!charSequence.toString().equals("") && charSequence != null && !charSequence.toString().equals("X1")) {
                x1 = Double.parseDouble(charSequence.toString());
                solve();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    TextWatcher textWatcherY1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!charSequence.toString().equals("") && charSequence != null && !charSequence.toString().equals("Y1")) {
                y1 = Double.parseDouble(charSequence.toString());
                solve();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    TextWatcher textWatcherX2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!charSequence.toString().equals("") && charSequence != null && !charSequence.toString().equals("X2")) {
                x2 = Double.parseDouble(charSequence.toString());
                solve();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    TextWatcher textWatcherY2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!charSequence.toString().equals("") && charSequence != null && !charSequence.toString().equals("Y2")) {
                y2 = Double.parseDouble(charSequence.toString());
                solve();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    TextWatcher textWatcherH1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!charSequence.toString().equals("") && charSequence != null && !charSequence.toString().equals("H1")) {
                h1 = Double.parseDouble(charSequence.toString());
                solve();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    TextWatcher textWatcherH2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!charSequence.toString().equals("") && charSequence != null && !charSequence.toString().equals("H2")) {
                h2 = Double.parseDouble(charSequence.toString());
                solve();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    View.OnFocusChangeListener on = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {
            EditText editText = (EditText) view;
            switch (view.getId()) {
                case R.id.x1:
                    editText.setText(editText.getText().toString().equals("X1") ? ""
                            : editText.getText().toString().equals("") ? "X1" : editText.getText());
                    break;
                case R.id.y1:
                    editText.setText(editText.getText().toString().equals("Y1") ? ""
                            : editText.getText().toString().equals("") ? "Y1" : editText.getText());
                    break;
                case R.id.x2:
                    editText.setText(editText.getText().toString().equals("X2") ? ""
                            : editText.getText().toString().equals("") ? "X2" : editText.getText());
                    break;
                case R.id.y2:
                    editText.setText(editText.getText().toString().equals("Y2") ? ""
                            : editText.getText().toString().equals("") ? "Y2" : editText.getText());
                    break;
                case R.id.h1:
                    editText.setText(editText.getText().toString().equals("H1") ? ""
                            : editText.getText().toString().equals("") ? "H1" : editText.getText());
                    break;
                case R.id.h2:
                    editText.setText(editText.getText().toString().equals("H2") ? ""
                            : editText.getText().toString().equals("") ? "H2" : editText.getText());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ogz);
        viewMap.put(R.id.x1, (EditText) findViewById(R.id.x1));
        viewMap.put(R.id.y1, (EditText) findViewById(R.id.y1));
        viewMap.put(R.id.y2, (EditText) findViewById(R.id.y2));
        viewMap.put(R.id.x2, (EditText) findViewById(R.id.x2));
        viewMap.put(R.id.h2, (EditText) findViewById(R.id.h2));
        viewMap.put(R.id.h1, (EditText) findViewById(R.id.h1));
        for (Integer i : viewMap.keySet()) {
            viewMap.get(i).setOnFocusChangeListener(on);
        }
        viewMap.get(R.id.x1).addTextChangedListener(textWatcherX1);
        viewMap.get(R.id.y1).addTextChangedListener(textWatcherY1);
        viewMap.get(R.id.x2).addTextChangedListener(textWatcherX2);
        viewMap.get(R.id.y2).addTextChangedListener(textWatcherY2);
        viewMap.get(R.id.h1).addTextChangedListener(textWatcherH1);
        viewMap.get(R.id.h2).addTextChangedListener(textWatcherH2);

        textViewMap.put(R.id.x, (TextView) findViewById(R.id.x));
        textViewMap.put(R.id.y, (TextView) findViewById(R.id.y));
        textViewMap.put(R.id.alfa, (TextView) findViewById(R.id.alfa));
        textViewMap.put(R.id.d, (TextView) findViewById(R.id.d));
        textViewMap.put(R.id.m, (TextView) findViewById(R.id.m));
        textViewMap.put(R.id.ro, (TextView) findViewById(R.id.ro));
    }
}
