package com.example.classactivity3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ForecastActivity extends AppCompatActivity {
    private ArrayList<Forecast> forecasts;
    private RecyclerView recyclerView;
    private TextView textView_city;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        recyclerView = findViewById(R.id.recyclerView_forecasts);
        forecasts = new ArrayList<>();
        textView_city = findViewById(R.id.textView_city);

        Intent intent = getIntent();
        JSONObject receivedMessage;
        try {
            // unpack the string to json
            receivedMessage = new JSONObject(intent.getStringExtra("weather"));

            String location = receivedMessage.getJSONObject("city").getString("name").concat(
                   ", " + receivedMessage.getJSONObject("city").getString("country")
            );
            textView_city.setText(location);

            JSONArray forecastsArray =  receivedMessage.getJSONArray("list");
            for (int i = 0; i < forecastsArray.length(); i++){
                JSONObject forecastObject = forecastsArray.getJSONObject(i);
                String feels_like = forecastObject.getJSONObject("main").getString("feels_like");
                String description = forecastObject.getJSONArray("weather").
                        getJSONObject(0).getString("description");
                String[] time = forecastObject.getString("dt_txt").split(" ");
                Forecast forecast = new Forecast(time[0], time[1], description, feels_like);
                forecasts.add(forecast);
            }

            ForecastAdapter adapter = new ForecastAdapter(forecasts);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
