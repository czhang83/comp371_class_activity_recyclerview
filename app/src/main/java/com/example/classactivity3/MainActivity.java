package com.example.classactivity3;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class MainActivity extends AppCompatActivity {

    private Button button_go;
    private TextInputLayout input;

    // Databse API
    private String city = "";
    private static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_go = findViewById(R.id.button_go);

        button_go.setOnClickListener(v -> launchNextActivity(v));
    }

    // create a new intent from main to city
    // get info from API
    public void launchNextActivity(View view){
        // get user input
        input = findViewById(R.id.textInputLayout);
        city = input.getEditText().getText().toString();
        String api_url = "https://api.openweathermap.org/data/2.5/forecast?q=" + city +
                "&appid=1516916cea2ac3c1f340519f69425b31&units=imperial";
        // send a get request to the api url
        client.get(api_url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                // when get a 200 status code
                Log.d("api response", new String(responseBody));

                Intent intent = new Intent(MainActivity.this, ForecastActivity.class);
                // send the response in string form
                intent.putExtra("weather", new String(responseBody));
                startActivity(intent);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // when get 400, go to NoCity page
                Log.e("api error", new String(responseBody)); // byte
                Intent intent = new Intent(MainActivity.this, NoCityActivity.class);
                startActivity(intent);
            }
        });
    }
}