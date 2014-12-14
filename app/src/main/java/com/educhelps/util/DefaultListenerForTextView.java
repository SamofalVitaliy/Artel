package com.educhelps.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.example.app.Arteleria;
import com.example.app.R;

import java.util.Map;

/**
 * Created by Виталий on 17.10.14.
 */
public class DefaultListenerForTextView {
    public View getCurrentValue() {
        return currentValue;
    }

    private EditText[] ed = new EditText[2];
    private View.OnFocusChangeListener setFocusListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {
            currentValue = view;
            EditText tmpEditText = (EditText) view;
            String tmp = tmpEditText.getText().toString();
            String defaultTmp = defaultValueOfView.get(tmpEditText.getId());
            if (defaultTmp.equals(tmp)) {
                tmpEditText.setText("");

                if (defaultTmp.equals("X1")) {
                    Arteleria.x1 = 0.0;

                }
                if (defaultTmp.equals("Y1")) {
                    Arteleria.y1 = 0.0;
                }
                if (defaultTmp.equals("Дальность")) {
                    Arteleria.distance = 0.0f;
                }
                if (defaultTmp.equals("Угол места")) {
                    Arteleria.degree = 0.0f;
                }
                ed[0].setText("Y2");
                ed[1].setText("X2");
                return;
            }
            if (tmp.equals("")) {
                tmpEditText.setText(defaultTmp);
            }
        }
    };

    public DefaultListenerForTextView(ViewMap viewMap, Activity activity) {
        ed[0] = (EditText) activity.findViewById(R.id.y2);
        ed[1] = (EditText) activity.findViewById(R.id.x2);
        this.defaultValueOfView = viewMap.getDefaultValue();
        this.viewMap = viewMap.getViewMap();
        for (Integer key : this.viewMap.keySet()) {
            this.viewMap.get(key).setOnFocusChangeListener(setFocusListener);
        }
    }

    private View currentValue;
    private Map<Integer, View> viewMap;
    private Map<Integer, String> defaultValueOfView;

}
