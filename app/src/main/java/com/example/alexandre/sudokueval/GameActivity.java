package com.example.alexandre.sudokueval;

import android.app.Activity;
import android.database.SQLException;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class GameActivity extends Activity implements View.OnClickListener{

    private SudokuGrid sud;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonX;

    private BDD mabase;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle objectBundle = this.getIntent().getExtras();
        String grille = objectBundle.getString("grille");
        int number = objectBundle.getInt("number");
        String[][] cases = new String[9][9];
        Case[][] cases2 = new Case[9][9];

        for(int i=0; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                if(grille.substring(i*9+j, i*9+j+1).equals("0")){
                    Paint paint = new Paint();
                    paint.setColor(Color.BLACK);
                    cases2[i][j] = new Case("", false, paint);
                }
                else{
                    Paint paint = new Paint();
                    paint.setColor(Color.BLUE);
                    cases2[i][j] = new Case(grille.substring(i*9+j, i*9+j+1), true, paint);
                }
            }
        }

        sud = findViewById(R.id.dessin);
        sud.context = this;
        //sud.setContent(cases);
        sud.setContent(cases2);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);
        buttonX = findViewById(R.id.buttonX);
        buttonX.setOnClickListener(this);

        mabase = new BDD();
        try{
            mabase.open(this);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v){
        TextView number = findViewById(R.id.textViewNumber);
        switch(v.getId()){
            case R.id.button1:
                number.setText("1");
                break;
            case R.id.button2:
                number.setText("2");
                break;
            case R.id.button3:
                number.setText("3");
                break;
            case R.id.button4:
                number.setText("4");
                break;
            case R.id.button5:
                number.setText("5");
                break;
            case R.id.button6:
                number.setText("6");
                break;
            case R.id.button7:
                number.setText("7");
                break;
            case R.id.button8:
                number.setText("8");
                break;
            case R.id.button9:
                number.setText("9");
                break;
            case R.id.buttonX:
                number.setText("X");
        }
    }

    public void initBase(int number){

    }
}
