package com.example.alexandre.sudokueval;

import android.graphics.Paint;

public class Case {
    private String value;
    private boolean isLocked;
    private Paint paint;

    public Case(String _value, boolean _isLocked, Paint _paint){
        value = _value;
        isLocked = _isLocked;
        paint = _paint;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String _value){
        value = _value;
    }

    public boolean getLocked(){
        return isLocked;
    }

    public Paint getPaint(){
        return paint;
    }
}