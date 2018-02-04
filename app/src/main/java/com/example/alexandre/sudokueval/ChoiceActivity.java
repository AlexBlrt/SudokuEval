package com.example.alexandre.sudokueval;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChoiceActivity extends Activity {

    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        myContext = this;

        Bundle objectBundle = this.getIntent().getExtras();
        int level = objectBundle.getInt("level");
        int fileResourceId = 0;

        switch(level){
            case 1:
                fileResourceId = R.raw.easy;
                break;
            case 2:
                fileResourceId = R.raw.normal;
                break;
            case 3:
                fileResourceId = R.raw.hard;
                break;
        }

        InputStream is = this.getResources().openRawResource(fileResourceId);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String str="";
        String buf="";
        final List<String> gameList = new ArrayList<String>();
        List<Integer> indexList = new ArrayList<Integer>();
        GridView grid = findViewById(R.id.gridview);
        int counter = 0;
        if (is!=null) {
            try {
                while ((str = reader.readLine()) != null) {
                    Log.w(" BDD \n\n", str);
                    gameList.add(str);
                    indexList.add(counter);
                    counter++;
                }
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final ArrayAdapter<Integer> gridViewArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, indexList);

        grid.setAdapter(gridViewArrayAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedItem = Integer.parseInt(parent.getItemAtPosition(position).toString());
                Intent intent = new Intent(myContext, GameActivity.class);
                Bundle objectBundle = new Bundle();
                objectBundle.putString("grille", gameList.get(selectedItem));
                objectBundle.putInt("number", selectedItem);
                intent.putExtras(objectBundle);
                startActivity(intent);
            }
        });
    }
}
