package com.educhelps.util;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Виталий on 03.10.14.
 */
public class ViewMap{
    public Map<Integer, View> getViewMap(){
        return viewMap;
    }
    public TypeOfView getTypeOfView(){
        return typeOfView;
    }
    public Set<Integer> getKeysOfView(){
        return this.keysOfView;
    }
    public Map<Integer, String> getDefaultValue(){
        return defaultValue;
    }
    public ViewMap(TypeOfView typeOfView, int idOfMainLayout, Activity activity) {
        ViewGroup v = (ViewGroup) activity.findViewById(idOfMainLayout).getParent();
        getAllChildrenView(typeOfView, v);
        keysOfView = viewMap.keySet();
        for(int k : keysOfView){
           defaultValue.put(k, String.valueOf(((EditText) viewMap.get(k)).getText()));
        }
    }
    private void getAllChildrenView(TypeOfView typeOfView, ViewGroup viewGroup) {
        View tempStorage;
        switch (typeOfView) {
            case EDIT_TEXT:
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (viewGroup == null) {
                        return;
                    }
                    tempStorage = viewGroup.getChildAt(i);
                    if (tempStorage instanceof EditText) {
                        for(int j = 0; i < viewGroup.getChildCount(); i++){
                            viewMap.put(viewGroup.getChildAt(i).getId(), viewGroup.getChildAt(i));
                        }
                        return;
                    }
                    getAllChildrenView(typeOfView, viewGroup.getChildAt(i) instanceof EditText ? null : (ViewGroup) viewGroup.getChildAt(i));
                }
        }
    }
    private TypeOfView typeOfView;
    private Map<Integer, String> defaultValue = new HashMap<>();
    private Map<Integer, View> viewMap = new HashMap<>();
    private Set<Integer> keysOfView = new HashSet<>();

}
