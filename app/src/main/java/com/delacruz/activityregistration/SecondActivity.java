package com.delacruz.activityregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    TextView enlistedEvents, comments;

    FileInputStream reader = null;
    FileInputStream reader2 = null;
    String content = "";
    String content2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        enlistedEvents = findViewById(R.id.textView4);
        comments = findViewById(R.id.textView6);

        try {
            reader = openFileInput("data1.txt");

            int token;

            while((token = reader.read()) != -1){
                content = content + (char)token;
            }

        } catch (FileNotFoundException e) {
            Log.d("Error", "File Not Found...");
        } catch (IOException e){
            Log.d("Error", "Input/Output Error");
        }

        String[] events = content.split("/");
        int i = 0;

        while (i <=7){
            enlistedEvents.append(events[i]);
            i++;
        }

        try {
            reader2 = openFileInput("data2.txt");

            int token;

            while((token = reader2.read()) != -1){
                content2 = content2 + (char)token;
            }

        } catch (FileNotFoundException e) {
            Log.d("Error", "File Not Found...");
        } catch (IOException e){
            Log.d("Error", "Input/Output Error");
        }
        comments.append(content2);

    }

    public void send(View v){
        Toast.makeText(this ,"registration sent...",Toast.LENGTH_LONG).show();
    }

    public void prevScreen(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
