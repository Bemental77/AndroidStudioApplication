package com.example.firstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class HelloCaseyActivity extends AppCompatActivity {
    private TextView message;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);



        message = findViewById(R.id.clickCounter);
        ImageView droid = findViewById(R.id.caseyImage);

        //Define and attach click listener
        droid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapCasey();
            }
        });
    }

    private void tapCasey() {
        counter++;
        String countAsText;

        switch (counter) {
            case 1:
                countAsText = "once";
                break;
            case 2:
                countAsText = "twice";
                break;
            default:
                countAsText = String.format("%d times", counter);
        }
        message.setText(String.format("You clicked Casey %s", countAsText));
    }
}