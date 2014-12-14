package com.educhelps.util;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Виталий on 05.10.14.
 */
public class Results {
    public Results(ViewMap vm){
        Map<Integer, View> viewMap = vm.getViewMap();
        capacity = viewMap.size();
        for(Integer k : viewMap.keySet()){
            Log.v("", String.valueOf(((EditText) viewMap.get(k)).getText()));
            String currentValue = String.valueOf(((EditText) viewMap.get(k)).getText());
            if(currentValue.equals("") || currentValue.equals(String.valueOf(vm.getDefaultValue().get(k))))
            {
                results.put(k, null);
                continue;
            }
            results.put(k, Float.parseFloat(currentValue));
        }
    }
    public Map<Integer, Float> getResults(){
        return results;
    }
    private int capacity;
    private Map<Integer, Float> results = new HashMap<>(capacity);

}
