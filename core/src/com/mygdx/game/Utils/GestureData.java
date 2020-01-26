package com.mygdx.game.Utils;

import java.util.ArrayList;

public class GestureData {
    public String gestureType;
    public ArrayList<Float> gestureData;
    public GestureData(){
        gestureData = new ArrayList<>();
    }
    public void clearData(){
        gestureData.clear();
    }
    public void add(Float toAdd){
        gestureData.add(toAdd);
    }
}
//TODO implemt dictionary instead of arrayList