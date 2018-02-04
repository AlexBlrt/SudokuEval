package com.example.alexandre.sudokueval;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends Activity implements View.OnClickListener{

    private Button bEasy;
    private Button bNormal;
    private Button bHard;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        bEasy = findViewById(R.id.buttonEasy);
        bEasy.setOnClickListener(this);
        bNormal = findViewById(R.id.buttonNormal);
        bNormal.setOnClickListener(this);
        bHard = findViewById(R.id.buttonHard);
        bHard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this, ChoiceActivity.class);
        Bundle objectBundle = new Bundle();
        switch(v.getId()){
            case R.id.buttonEasy:
                objectBundle.putInt("level", 1);
                break;
            case R.id.buttonNormal:
                objectBundle.putInt("level", 2);
                break;
            case R.id.buttonHard:
                objectBundle.putInt("level", 3);
                break;
        }
        intent.putExtras(objectBundle);
        startActivity(intent);
    }
}
