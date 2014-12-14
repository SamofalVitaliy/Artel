package com.educhelps.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.Map;

/**
 * Created by Виталий on 17.10.14.
 */
public class OnChangeListener {
    private Map<Integer, View> viewMap;
    TextWatcher a = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            //Здесь нужно узнать какое именно View вызвало этот метод, если для всех установлен один обработчик )
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    public OnChangeListener(ViewMap viewMap ,TextWatcher textWatcher){
        this.viewMap = viewMap.getViewMap();
        for(int k:this.viewMap.keySet()){
            ((EditText)this.viewMap.get(k)).addTextChangedListener(textWatcher);
        }
    }
}
