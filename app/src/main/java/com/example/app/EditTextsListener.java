package com.example.app;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Виталий on 30.09.14.
 */
class TextViewImpl extends EditText {
    EditText editText = null;

    public TextViewImpl(Context context) {
        super(context);
    }
    public TextViewImpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public TextViewImpl(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public void addTextChangedListener(android.text.TextWatcher watcher){
        try {
            editText = (EditText) this.clone();
            Log.v("1", editText.getText().toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        super.addTextChangedListener(watcher);
    }
}
