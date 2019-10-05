package com.delacruz.activityregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;
    EditText ml1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        cb6 = findViewById(R.id.cb6);
        cb7 = findViewById(R.id.cb7);
        cb8 = findViewById(R.id.cb8);

        ml1 = findViewById(R.id.editText);

    }

    public void writeData(View v){

        boolean [] cbChecked = {
                cb1.isChecked(),
                cb2.isChecked(),
                cb3.isChecked(),
                cb4.isChecked(),
                cb5.isChecked(),
                cb6.isChecked(),
                cb7.isChecked(),
                cb8.isChecked()
        };

        String[] cbData = {
                cb1.getText().toString(),
                cb2.getText().toString(),
                cb3.getText().toString(),
                cb4.getText().toString(),
                cb5.getText().toString(),
                cb6.getText().toString(),
                cb7.getText().toString(),
                cb8.getText().toString()
        };

        String mlData = ml1.getText().toString();

        String entry="";

        FileOutputStream writer = null;

        for(int i = 0; i <= cbChecked.length; i++){

            if(cbChecked[i]){
                entry = cbData[i] + "/";

                try {
                    writer = openFileOutput("data1.txt", MODE_APPEND);
                    writer.write(entry.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.d("Error","File Not Found..");
                } catch (IOException e) {
                    Log.d("Error","Input/Output Error..");
                }finally {
                    try {
                        writer.flush();
                        writer.close();
                    }catch (IOException e){
                        Log.d("Error", "File Not Found..");
                    }
                }
            }
        }

        FileOutputStream writer2 = null;

        try {
            writer2 = openFileOutput("data2.txt", MODE_PRIVATE);
            writer2.write(mlData.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("Error","File Not Found..");
        } catch (IOException e) {
            Log.d("Error","Input/Output Error..");
        }finally {
            try {
                writer2.flush();
                writer2.close();
            }catch (IOException e){
                Log.d("Error", "File Not Found..");
            }
        }

        Toast.makeText(this, "Data Saved...", Toast.LENGTH_SHORT).show();

    }

    public void nextScreen(View v){
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }

}

