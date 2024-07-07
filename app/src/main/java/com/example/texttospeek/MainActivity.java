package com.example.texttospeek;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
        Button start;
        EditText res;
        TextToSpeech ts;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        res=findViewById(R.id.res);
        ts=new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    ts.setLanguage(Locale.ENGLISH);
                    Toast.makeText(getBaseContext(),"sucess",Toast.LENGTH_LONG).show();
                }
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Speech();
            }
        });
    }

    private void Speech() {
        String test=res.getText().toString();
        ts.speak(test,TextToSpeech.QUEUE_FLUSH,null);
    }
}