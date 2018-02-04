package com.example.alexandre.sudokueval;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonLevel);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == button){
            Intent intent = new Intent(this, LevelActivity.class);
            startActivity(intent);
        }
    }
}
