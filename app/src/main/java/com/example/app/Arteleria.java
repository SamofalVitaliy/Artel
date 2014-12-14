package com.example.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.educhelps.util.DefaultListenerForTextView;
import com.educhelps.util.TypeOfView;
import com.educhelps.util.ViewMap;
import java.util.HashMap;
import java.util.Map;

public class Arteleria extends ActionBarActivity {
    Map<Integer, Float> results = new HashMap<>();
    ViewMap viewMap;
    Map map;
    boolean a = false;
    boolean b = false;
    public static Double x1;
    public static Double x2;
    public static Double y1;
    public static Double y2;
    public static Float distance;
    public static Float distanceDefDot;
    public static Float degree;
    public static Float degreeDirection;

    public void solveSimpleGeodez() {
        if (x1 != null && y1 != null && distance != null && degree != null) {
            if (!getText(R.id.x1).equals(viewMap.getDefaultValue().get(R.id.x1)) &&
                    !getText(R.id.y1).equals(viewMap.getDefaultValue().get(R.id.y1)) &&
                    !getText(R.id.distance).equals(viewMap.getDefaultValue().get(R.id.distance)) &&
                    !getText(R.id.degree).equals(viewMap.getDefaultValue().get(R.id.degree))
                    ) {
                ((TextView) findViewById(R.id.x2)).setText(Long.toString(
                        Math.round(x1 + Math.cos((degree * 6 * Math.PI) / 180) * distance)
                ));
                ((TextView) findViewById(R.id.y2)).setText(Long.toString(
                        Math.round(y1 + Math.sin((degree * 6 * Math.PI) / 180) * distance)
                ));
            }
        }
    }




    public void solveReverseGeodez() {
        if (x2 != null && y2 != null && distance != null && degree != null) {
            if (!getText(R.id.x2).equals(viewMap.getDefaultValue().get(R.id.x2)) &&
                    !getText(R.id.y2).equals(viewMap.getDefaultValue().get(R.id.y2)) &&
                    !getText(R.id.distance).equals(viewMap.getDefaultValue().get(R.id.distance)) &&
                    !getText(R.id.degree).equals(viewMap.getDefaultValue().get(R.id.degree))
                    ) {
                x1 = x2 - Math.cos((degree * 6 * Math.PI) / 180) * distance;
                y1 = y2 - Math.sin((degree * 6 * Math.PI) / 180) * distance;
                ((TextView) findViewById(R.id.x1)).setText(Double.toString(x1));
                ((TextView) findViewById(R.id.y1)).setText(Double.toString(y1));

            }
        }
    }

    TextWatcher textWatcherForX1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!charSequence.toString().equals("") && charSequence != null && !charSequence.toString().equals(viewMap.getDefaultValue().get(R.id.x1))) {
                    Log.v(charSequence.toString(), "123456");
                    x1 = Double.parseDouble(charSequence.toString());
                    solveSimpleGeodez();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        TextWatcher textWatcherForY1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!charSequence.toString().equals("") && charSequence != null && !charSequence.toString().equals(viewMap.getDefaultValue().get(R.id.y1))) {
                    y1 = Double.parseDouble(charSequence.toString());
                    solveSimpleGeodez();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        TextWatcher textWatcherForDistance = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!charSequence.toString().equals("") && charSequence != null && !charSequence.toString().equals(viewMap.getDefaultValue().get(R.id.distance))) {
                    distance = Float.parseFloat(charSequence.toString());
                    solveSimpleGeodez();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        TextWatcher textWatcherForDegrees = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!charSequence.toString().equals("") && charSequence != null && !charSequence.toString().equals(viewMap.getDefaultValue().get(R.id.degree)))
                    degree = Float.parseFloat(charSequence.toString());
                solveSimpleGeodez();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_arteleria);
            viewMap = new ViewMap(TypeOfView.EDIT_TEXT, R.id.mainLayout, this);
            map = viewMap.getViewMap();
            DefaultListenerForTextView def = new DefaultListenerForTextView(viewMap, this);
            ((TextView) map.get(R.id.x1)).addTextChangedListener(textWatcherForX1);
            ((TextView) map.get(R.id.y1)).addTextChangedListener(textWatcherForY1);
            ((TextView) map.get(R.id.distance)).addTextChangedListener(textWatcherForDistance);
            ((TextView) map.get(R.id.degree)).addTextChangedListener(textWatcherForDegrees);
        }


    }
