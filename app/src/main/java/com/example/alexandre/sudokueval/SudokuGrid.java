package com.example.alexandre.sudokueval;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.constraint.solver.widgets.Rectangle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SudokuGrid extends View implements View.OnTouchListener{

    private Case[][] cases;
    private boolean isValueReady = false;
    int size = 150;
    int separator = 10;
    public GameActivity context;

    public SudokuGrid(Context context, AttributeSet attrs){
        super(context, attrs);

        this.setOnTouchListener(this);
    }

    @Override
    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.BLACK);
        Paint colorWhite = new Paint();
        Paint colorText = new Paint();
        colorWhite.setColor(Color.WHITE);
        colorText.setColor(Color.BLACK);
        colorText.setTextSize(100);
        boolean win = true;
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                Rect rect =  new Rect(j*(size+separator)+separator, i*(size+separator)+separator, size+j*(size+separator)+separator, size+i*(size+separator)+separator);
                canvas.drawRect(rect, colorWhite);
                if(isValueReady){
                    if(checkRules(j, i)){
                        colorText.setColor(Color.RED);
                    }else{
                        colorText.setColor(cases[i][j].getPaint().getColor());
                    }
                    if(colorText.getColor() == Color.RED || cases[i][j].getValue() == ""){
                        win = false;
                    }
                    canvas.drawText(cases[i][j].getValue(), j*(size+separator)+separator+size/2, i*(size+separator)+separator+size/2,colorText);
                }
            }
        }
        if(win){
            canvas.drawColor(Color.RED);
            colorText.setColor(Color.BLACK);
            canvas.drawText("Vous avez gagné !", 300, 200,colorText);
        }
    }

    public void setContent(Case[][] data){
        cases = data;
        isValueReady = true;
        invalidate();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        int x = (int)event.getX();
        int y = (int)event.getY();
        int x2 = 0;
        int y2 = 0;
        TextView number = context.findViewById(R.id.textViewNumber);
        if(number.getText().toString().compareToIgnoreCase(" ") != 0){
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN://touché en x,y
                    for(int i=0 ; i<9 ; i++){
                        x = x-size-separator;
                        if(x <= 0){
                            break;
                        }
                        else{
                            x2++;
                        }
                    }
                    for(int i=0 ; i<9 ; i++){
                        y = y-size-separator;
                        if(y <= 0){
                            break;
                        }
                        else{
                            y2++;
                        }
                    }
                    if(!cases[y2][x2].getLocked()){
                        if(number.getText().toString().equals("X")) {
                            cases[y2][x2].setValue("");
                        }
                        else{
                            cases[y2][x2].setValue(number.getText().toString());
                        }
                    }
                    number.setText(" ");
                    break;
            }
        }
        this.invalidate();
        return true;
    }

    public boolean checkRules(int x, int y){
        for(int i=0 ; i<9 ; i++){
            if(i != x){
                if(cases[y][i].getValue().equals(cases[y][x].getValue())){
                    return true;
                }
            }
            if(i != y){
                if(cases[i][x].getValue().equals(cases[y][x].getValue())){
                    return true;
                }
            }
        }

        int xcarre = 0;
        int ycarre = 0;
        switch(x){
            case 0:
            case 1:
            case 2:
                xcarre=0;
                break;
            case 3:
            case 4:
            case 5:
                xcarre=3;
                break;
            case 6:
            case 7:
            case 8:
                xcarre=6;
                break;
        }

        switch(y){
            case 0:
            case 1:
            case 2:
                ycarre=0;
                break;
            case 3:
            case 4:
            case 5:
                ycarre=3;
                break;
            case 6:
            case 7:
            case 8:
                ycarre=6;
                break;
        }

        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                if(i+ycarre != y || j+xcarre != x){
                    if(cases[i+ycarre][j+xcarre].getValue().equals(cases[y][x].getValue())){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
