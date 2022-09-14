package com.projetpicto.caantalk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextToSpeech lecture;
    ImageButton banane;
    Button bananeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lecture = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR){
                    lecture.setLanguage(Locale.CANADA_FRENCH);
                }
            }
        });

        banane = (ImageButton) findViewById(R.id.banane);

        bananeButton = (Button) findViewById(R.id.bananebutton);

        banane.setOnClickListener(this);
        bananeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bananebutton:
                banane.performClick();
                break;

            case R.id.banane:
                lecture.speak(getString(R.string.banane), TextToSpeech.QUEUE_FLUSH, null);
                break;
        }
    }

    public void onPause(){
        if(lecture !=null){
            lecture.stop();
            lecture.shutdown();
        }
        super.onPause();
    }

}